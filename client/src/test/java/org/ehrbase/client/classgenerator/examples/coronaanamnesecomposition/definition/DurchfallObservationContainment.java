package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;

public class DurchfallObservationContainment extends Containment {
  public SelectAqlField<DurchfallObservation> DURCHFALL_OBSERVATION = new AqlFieldImp<DurchfallObservation>(DurchfallObservation.class, "", "DurchfallObservation", DurchfallObservation.class, this);

  public SelectAqlField<String> BEZEICHNUNG_DES_SYMPTOMS_ODER_ANZEICHENS_VALUE = new AqlFieldImp<String>(DurchfallObservation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0004]/value|value", "bezeichnungDesSymptomsOderAnzeichensValue", String.class, this);

  public SelectAqlField<VorhandenDefiningCode> VORHANDEN_DEFINING_CODE = new AqlFieldImp<VorhandenDefiningCode>(DurchfallObservation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/value|defining_code", "vorhandenDefiningCode", VorhandenDefiningCode.class, this);

  public ListSelectAqlField<Cluster> DETAILLIERTE_ANGABEN_ZUM_SYMPTOM_ANZEICHEN = new ListAqlFieldImp<Cluster>(DurchfallObservation.class, "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0026]", "detaillierteAngabenZumSymptomAnzeichen", Cluster.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(DurchfallObservation.class, "/data[at0001]/events[at0002]/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(DurchfallObservation.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(DurchfallObservation.class, "/protocol[at0007]/items[at0021]", "erweiterung", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(DurchfallObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(DurchfallObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(DurchfallObservation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private DurchfallObservationContainment() {
    super("openEHR-EHR-OBSERVATION.symptom_sign_screening.v0");
  }

  public static DurchfallObservationContainment getInstance() {
    return new DurchfallObservationContainment();
  }
}
