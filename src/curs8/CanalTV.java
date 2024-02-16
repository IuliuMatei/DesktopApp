package curs8;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CanalTV {
 private final IntegerProperty idCanalTV;
 private final StringProperty NumeCa;
 private final StringProperty Tip;
 private final StringProperty Locatie;
 public CanalTV(Integer idCanalTV, String NumeCa, String Tip, String Locatie) {
 this.idCanalTV = new SimpleIntegerProperty(idCanalTV);
 this.NumeCa = new SimpleStringProperty(NumeCa);
 this.Tip = new SimpleStringProperty(Tip);
 this.Locatie = new SimpleStringProperty(Locatie);
 }
 public Integer getIdCanalTV() {
 return idCanalTV.get();
 }
 public String getNumeCa() {
 return NumeCa.get();
 }
 public String getTip() {
 return Tip.get();
 }
 public String getLocatie() {
 return Locatie.get();
 }
 public void setIdCanalTV(Integer valoare) {
	 idCanalTV.set(valoare);
 }
 public void setNumeCa(String valoare) {
	 NumeCa.set(valoare);
 }
 public void setLocatie(String valoare) {
	 Locatie.set(valoare);
 }
 public void setTip(String valoare) {
	 Tip.set(valoare);
 }
 public IntegerProperty idCanalTVProperty() {
 return idCanalTV;
 }
 public StringProperty NumeCaProperty() {
 return NumeCa;
 }
 public StringProperty TipProperty() {
 return Tip;
 }
 public StringProperty LocatieProperty() {
 return Locatie;
 }
}
