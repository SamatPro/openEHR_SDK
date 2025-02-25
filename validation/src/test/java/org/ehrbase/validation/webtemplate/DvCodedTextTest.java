/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.validation.webtemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.support.identification.TerminologyId;
import java.util.List;
import org.ehrbase.validation.ConstraintViolation;
import org.ehrbase.validation.ConstraintViolationException;
import org.ehrbase.validation.terminology.ExternalTerminologyValidationException;
import org.ehrbase.validation.terminology.FhirTerminologyValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 */
class DvCodedTextTest extends AbstractRMObjectValidatorTest {

  private FhirTerminologyValidation fhirTerminologyValidationMock;

  @BeforeEach
  public void setUp() {
    fhirTerminologyValidationMock = Mockito.mock(FhirTerminologyValidation.class);
  }

  @Test
  void testValidate() throws Exception {
    var validator = new DvCodedTextValidator();

    var node = parseNode("/webtemplate_nodes/dv_codedtext.json");
    var dvCodedText = new DvCodedText("First",
        new CodePhrase(new TerminologyId("local"), "at0028"));

    var result = validator.validate(dvCodedText, node);
    assertTrue(result.isEmpty());

    dvCodedText = new DvCodedText("Test", new CodePhrase(new TerminologyId("local"), "at0028"));
    result = validator.validate(dvCodedText, node);
    assertEquals(1, result.size());
    dvCodedText = new DvCodedText("First", new CodePhrase(new TerminologyId("local"), "at0029"));
    result = validator.validate(dvCodedText, node);
    assertEquals(1, result.size());
  }

  @Test
  void testValidate_UnsupportedExternalTerminology() throws Exception {
    Mockito.when(fhirTerminologyValidationMock.supports("ICD10"))
        .thenReturn(false);

    var node = parseNode("/webtemplate_nodes/dv_codedtext_unsupported.json");
    var dvCodedText = new DvCodedText(
        "Iodine-deficiency related thyroid disorders and allied conditions",
        new CodePhrase(new TerminologyId("ICD10"), "E01"));

    var result = new DvCodedTextValidator(fhirTerminologyValidationMock)
        .validate(dvCodedText, node);
    assertTrue(result.isEmpty());
  }

  @Test
  void testValidate_FhirCodeSystem() throws Exception {
    var codePhrase = new CodePhrase(new TerminologyId("http://hl7.org/fhir/observation-status"),
        "final");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status"))
        .thenReturn(true);

    Mockito.doNothing()
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_code_system",
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status", codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_codesystem.json");

    var result = validator.validate(new DvCodedText("Final", codePhrase), node);
    assertTrue(result.isEmpty());
  }

  @Test
  void testValidate_FhirCodeSystem_WrongTerminologyId() throws Exception {
    var codePhrase = new CodePhrase(new TerminologyId("http://hl7.org/fhir/name-use"),
        "usual");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status"))
        .thenReturn(true);
    Mockito.doThrow(
            new ConstraintViolationException(List.of(
                new ConstraintViolation("/test/dv_coded_text_fhir_value_set",
                    "The terminology http://hl7.org/fhir/name-use must be http://hl7.org/fhir/observation-status"))))
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_code_system",
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status",
            codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_codesystem.json");

    var result = validator.validate(new DvCodedText("Usual", codePhrase), node);
    assertEquals(1, result.size());
  }

  @Test
  void testValidate_FhirCodeSystem_WrongCode() throws Exception {
    var codePhrase = new CodePhrase(new TerminologyId("http://hl7.org/fhir/observation-status"),
        "casual");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status"))
        .thenReturn(true);
    Mockito.doThrow(
            new ConstraintViolationException(List.of(
                new ConstraintViolation("/test/dv_coded_text_fhir_code_system",
                    "The specified code 'casual' is not known to belong to the specified code system 'http://hl7.org/fhir/observation-status'"))))
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_code_system",
            "//fhir.hl7.org/CodeSystem?url=http://hl7.org/fhir/observation-status",
            codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_codesystem.json");

    var result = validator.validate(new DvCodedText("Casual", codePhrase), node);
    assertEquals(1, result.size());
  }

  @Test
  void testValidate_FhirValueSet() throws Exception {
    var codePhrase = new CodePhrase(
        new TerminologyId("http://terminology.hl7.org/CodeSystem/v3-EntityNameUseR2"), "UKN");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2"))
        .thenReturn(true);
    Mockito.doNothing()
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_value_set",
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2",
            codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_valueset.json");

    var result = validator.validate(new DvCodedText("Anonymous", codePhrase), node);
    assertTrue(result.isEmpty());
  }

  @Test
  void testValidate_FhirValueSet_WrongTerminologyId() throws Exception {
    var codePhrase = new CodePhrase(new TerminologyId("http://snomed.info/sct"), "ANON");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2"))
        .thenReturn(true);
    Mockito.doThrow(
            new ConstraintViolationException(List.of(
                new ConstraintViolation("/test/dv_coded_text_fhir_value_set",
                    "The terminology http://snomed.info/sct must be http://terminology.hl7.org/CodeSystem/v3-EntityNameUseR2"))))
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_value_set",
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2",
            codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_valueset.json");

    var result = validator.validate(new DvCodedText("Anonymous", codePhrase), node);
    assertEquals(1, result.size());
  }

  @Test
  void testValidate_FhirValueSet_WrongCode() throws Exception {
    var codePhrase = new CodePhrase(
        new TerminologyId("http://terminology.hl7.org/CodeSystem/v3-EntityNameUseR2"), "UKN");

    // Mockito initialization
    Mockito.when(fhirTerminologyValidationMock.supports(
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2"))
        .thenReturn(true);
    Mockito.doThrow(
            new ConstraintViolationException(List.of(
                new ConstraintViolation("/test/dv_coded_text_fhir_value_set",
                    "The value UKN does not match any option from value set http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2"))))
        .when(fhirTerminologyValidationMock)
        .validate("/test/dv_coded_text_fhir_value_set",
            "//fhir.hl7.org/ValueSet/$expand?url=http://terminology.hl7.org/ValueSet/v3-EntityNameUseR2",
            codePhrase);

    var validator = new DvCodedTextValidator(fhirTerminologyValidationMock);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_valueset.json");

    var result = validator.validate(new DvCodedText("Anonymous", codePhrase), node);
    assertEquals(1, result.size());
  }

  @Test
  void testFailOnError_Enabled() throws Exception {
    var validationSupport = new FhirTerminologyValidation("https://wrong.terminology.server/fhir");

    var codePhrase = new CodePhrase(new TerminologyId("http://hl7.org/fhir/observation-status"),
        "B");
    var dvCodedText = new DvCodedText("Buccal", codePhrase);

    var validator = new DvCodedTextValidator(validationSupport);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_valueset.json");

    assertThrows(
        ExternalTerminologyValidationException.class,
        () -> validator.validate(dvCodedText, node));

  }

  @Test
  void testFailOnError_Disabled() throws Exception {
    var validationSupport = new FhirTerminologyValidation("https://wrong.terminology.server/fhir");

    var codePhrase = new CodePhrase(new TerminologyId("http://hl7.org/fhir/observation-status"),
        "B");
    var dvCodedText = new DvCodedText("Buccal", codePhrase);

    var validator = new DvCodedTextValidator(validationSupport);
    var node = parseNode("/webtemplate_nodes/dv_codedtext_fhir_valueset.json");

    assertThrows(
        ExternalTerminologyValidationException.class,
        () -> validator.validate(dvCodedText, node));
  }
}
