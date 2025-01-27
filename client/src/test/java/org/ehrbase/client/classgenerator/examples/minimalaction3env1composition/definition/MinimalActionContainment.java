package org.ehrbase.client.classgenerator.examples.minimalaction3env1composition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datavalues.encapsulated.DvMultimedia;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;
import org.ehrbase.client.classgenerator.shareddefinition.Transition;

public class MinimalActionContainment extends Containment {
  public SelectAqlField<MinimalAction> MINIMAL_ACTION = new AqlFieldImp<MinimalAction>(MinimalAction.class, "", "MinimalAction", MinimalAction.class, this);

  public SelectAqlField<DvMultimedia> MULTIMEDIA = new AqlFieldImp<DvMultimedia>(MinimalAction.class, "/description[at0001]/items[at0002]/value", "multimedia", DvMultimedia.class, this);

  public SelectAqlField<NullFlavour> MULTIMEDIA_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(MinimalAction.class, "/description[at0001]/items[at0002]/null_flavour|defining_code", "multimediaNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(MinimalAction.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(MinimalAction.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(MinimalAction.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(MinimalAction.class, "/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<CareflowStepDefiningCode> CAREFLOW_STEP_DEFINING_CODE = new AqlFieldImp<CareflowStepDefiningCode>(MinimalAction.class, "/ism_transition/careflow_step|defining_code", "careflowStepDefiningCode", CareflowStepDefiningCode.class, this);

  public SelectAqlField<CurrentStateDefiningCode> CURRENT_STATE_DEFINING_CODE = new AqlFieldImp<CurrentStateDefiningCode>(MinimalAction.class, "/ism_transition/current_state|defining_code", "currentStateDefiningCode", CurrentStateDefiningCode.class, this);

  public SelectAqlField<Transition> TRANSITION_DEFINING_CODE = new AqlFieldImp<Transition>(MinimalAction.class, "/ism_transition/transition|defining_code", "transitionDefiningCode", Transition.class, this);

  private MinimalActionContainment() {
    super("openEHR-EHR-ACTION.minimal.v1");
  }

  public static MinimalActionContainment getInstance() {
    return new MinimalActionContainment();
  }
}
