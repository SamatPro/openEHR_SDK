package org.ehrbase.client.phenotypes.optentities.openehrconfirmedcovid19infectionreportv0composition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.phenotypes.optentities.shareddefinition.Language;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.symptom_sign_screening.v0")
public class SymptomSignScreeningObservation {
  @Path("/protocol[at0007]/items[at0021]")
  private List<Cluster> extension;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0001]/events[at0002]")
  @Choice
  private List<SymptomSignScreeningAtTestChoice> atTest;

  @Path("/language")
  private Language language;

  public void setExtension(List<Cluster> extension) {
     this.extension = extension;
  }

  public List<Cluster> getExtension() {
     return this.extension ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setOriginValue(TemporalAccessor originValue) {
     this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
     return this.originValue ;
  }

  public void setAtTest(List<SymptomSignScreeningAtTestChoice> atTest) {
     this.atTest = atTest;
  }

  public List<SymptomSignScreeningAtTestChoice> getAtTest() {
     return this.atTest ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }
}