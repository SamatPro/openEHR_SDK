package org.ehrbase.client.classgenerator.examples.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.examples.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.laboratory_test_result.v1")
public class LaborergebnisObservation {
  @Path("/protocol[at0004]/items[at0110]")
  private List<Cluster> testDetails;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.specimen.v1]")
  private List<ProbeCluster> probe;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.laboratory_test_panel.v0]")
  private List<LabortestPanelCluster> labortestPanel;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0118]")
  private List<Cluster> multimediaDarstellung;

  @Path("/protocol[at0004]/items[at0094]/items[at0062]/value")
  private DvIdentifier einsendendenSystems;

  @Path("/protocol[at0004]/items[at0094]/items[at0063]/value")
  private DvIdentifier auftragsIdEmpfanger;

  @Path("/protocol[at0004]/items[openEHR-EHR-CLUSTER.location.v1]")
  private StandortCluster standort;

  @Path("/name")
  private DvText name;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0005]/value|value")
  private String labortestBezeichnungValue;

  @Path("/data[at0001]/events[at0002]/state[at0112]/items[at0114]")
  private List<Cluster> strukturierteErfassungDerStorfaktoren;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0122]")
  private List<Cluster> strukturierteTestdiagnostik;

  @Path("/protocol[at0004]/items[at0117]")
  private List<Cluster> erweiterung;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/protocol[at0004]/items[at0094]/items[at0106]")
  private List<StandortOriginalerNameDerAngefordertenTestungElement> originalerNameDerAngefordertenTestung;

  @Path("/protocol[at0004]/items[at0094]/items[openEHR-EHR-CLUSTER.location.v1]")
  private StandortCluster2 standortItemsOpenehrEhrClusterLocationV1;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/protocol[at0004]/items[at0094]/items[at0035]")
  private List<Cluster> verteilerliste;

  public void setTestDetails(List<Cluster> testDetails) {
     this.testDetails = testDetails;
  }

  public List<Cluster> getTestDetails() {
     return this.testDetails ;
  }

  public void setProbe(List<ProbeCluster> probe) {
     this.probe = probe;
  }

  public List<ProbeCluster> getProbe() {
     return this.probe ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setLabortestPanel(List<LabortestPanelCluster> labortestPanel) {
     this.labortestPanel = labortestPanel;
  }

  public List<LabortestPanelCluster> getLabortestPanel() {
     return this.labortestPanel ;
  }

  public void setMultimediaDarstellung(List<Cluster> multimediaDarstellung) {
     this.multimediaDarstellung = multimediaDarstellung;
  }

  public List<Cluster> getMultimediaDarstellung() {
     return this.multimediaDarstellung ;
  }

  public void setEinsendendenSystems(DvIdentifier einsendendenSystems) {
     this.einsendendenSystems = einsendendenSystems;
  }

  public DvIdentifier getEinsendendenSystems() {
     return this.einsendendenSystems ;
  }

  public void setAuftragsIdEmpfanger(DvIdentifier auftragsIdEmpfanger) {
     this.auftragsIdEmpfanger = auftragsIdEmpfanger;
  }

  public DvIdentifier getAuftragsIdEmpfanger() {
     return this.auftragsIdEmpfanger ;
  }

  public void setStandort(StandortCluster standort) {
     this.standort = standort;
  }

  public StandortCluster getStandort() {
     return this.standort ;
  }

  public void setLabortestBezeichnungValue(String labortestBezeichnungValue) {
     this.labortestBezeichnungValue = labortestBezeichnungValue;
  }

  public String getLabortestBezeichnungValue() {
     return this.labortestBezeichnungValue ;
  }

  public void setStrukturierteErfassungDerStorfaktoren(
      List<Cluster> strukturierteErfassungDerStorfaktoren) {
     this.strukturierteErfassungDerStorfaktoren = strukturierteErfassungDerStorfaktoren;
  }

  public List<Cluster> getStrukturierteErfassungDerStorfaktoren() {
     return this.strukturierteErfassungDerStorfaktoren ;
  }

  public void setStrukturierteTestdiagnostik(List<Cluster> strukturierteTestdiagnostik) {
     this.strukturierteTestdiagnostik = strukturierteTestdiagnostik;
  }

  public List<Cluster> getStrukturierteTestdiagnostik() {
     return this.strukturierteTestdiagnostik ;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
     this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
     return this.erweiterung ;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
  }

  public void setOriginalerNameDerAngefordertenTestung(
      List<StandortOriginalerNameDerAngefordertenTestungElement> originalerNameDerAngefordertenTestung) {
     this.originalerNameDerAngefordertenTestung = originalerNameDerAngefordertenTestung;
  }

  public List<StandortOriginalerNameDerAngefordertenTestungElement> getOriginalerNameDerAngefordertenTestung(
      ) {
     return this.originalerNameDerAngefordertenTestung ;
  }

  public void setStandortItemsOpenehrEhrClusterLocationV1(
      StandortCluster2 standortItemsOpenehrEhrClusterLocationV1) {
     this.standortItemsOpenehrEhrClusterLocationV1 = standortItemsOpenehrEhrClusterLocationV1;
  }

  public StandortCluster2 getStandortItemsOpenehrEhrClusterLocationV1() {
     return this.standortItemsOpenehrEhrClusterLocationV1 ;
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

  public void setVerteilerliste(List<Cluster> verteilerliste) {
     this.verteilerliste = verteilerliste;
  }

  public List<Cluster> getVerteilerliste() {
     return this.verteilerliste ;
  }

    public DvText getName() {
        return name;
    }

    public void setName(DvText name) {
        this.name = name;
    }
}