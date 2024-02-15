package curs8;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
*
* @author vali
*/
public class Client {
 private final IntegerProperty idClient;
 private final StringProperty Nume;
 private final StringProperty Prenume;
 private final StringProperty Adresa;
 private final StringProperty Judet;
 private final StringProperty CNP;
 public Client(Integer idClient, String Nume, String Prenume, String Adresa, String Judet, String CNP) {
 this.idClient = new SimpleIntegerProperty(idClient);
 this.Nume = new SimpleStringProperty(Nume);
 this.Prenume = new SimpleStringProperty(Prenume);
 this.Adresa = new SimpleStringProperty(Adresa);
 this.Judet = new SimpleStringProperty(Judet);
 this.CNP = new SimpleStringProperty(CNP);
 }
 public Integer getIdClient() {
 return idClient.get();
 }
 public String getNume() {
 return Nume.get();
 }
 public String getPrenume() {
 return Prenume.get();
 }
 public String getAdresa() {
 return Adresa.get();
 }
 public String getJudet() {
	 return Judet.get();
	 }
 public String getCNP() {
	 return Judet.get();
	 }
 public void setIdClient(Integer valoare) {
 idClient.set(valoare);
 }
 public void setNume(String valoare) {
 Nume.set(valoare);
 }
 public void setPrenume(String valoare) {
 Prenume.set(valoare);
 }
 public void setAdresa(String valoare) {
 Adresa.set(valoare);
 }
 public void setJudet(String valoare) {
 Judet.set(valoare);
 }
 public void setCNP(String valoare) {
 CNP.set(valoare);
 }
 public IntegerProperty idClientProperty() {
 return idClient;
 }
 public StringProperty NumeProperty() {
 return Nume;
 }
 public StringProperty PrenumeProperty() {
 return Prenume;
 }
 public StringProperty AdresaProperty() {
 return Adresa;
 }
 public StringProperty JudetProperty() {
 return Judet;
 }
 public StringProperty CNPProperty() {
 return CNP;
 }
}
