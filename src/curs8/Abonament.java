package curs8;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
*
* @author vali
*/
public class Abonament {
 private final IntegerProperty idAbonament;
 private final StringProperty NumeAb;
 private final IntegerProperty iDClient;
 private final IntegerProperty iDChannel;
 private final StringProperty price;
 private final StringProperty clientNume;
 private final StringProperty canalNume;
 public Abonament(Integer idAbonament, String NumeAb, Integer idClient, Integer idChannel, String price, String clientNume, String canalNume) {
 this.idAbonament = new SimpleIntegerProperty(idAbonament);
 this.NumeAb = new SimpleStringProperty(NumeAb);
 this.iDClient = new SimpleIntegerProperty(idClient);
 this.iDChannel = new SimpleIntegerProperty(idChannel);
 this.price = new SimpleStringProperty(price);
 this.clientNume = new SimpleStringProperty(clientNume);
 this.canalNume = new SimpleStringProperty(canalNume);
 }

 public Integer getIdAbonament() {
 return idAbonament.get();
 }
 public String getNumeAb() {
 return NumeAb.get();
 }
 public Integer getIdClient() {
 return iDClient.get();
 }
 public Integer getidChannel() {
 return iDChannel.get();
 }
 public String getprice() {
	 return price.get();
	 }
 public String getclientNume() {
	 return clientNume.get();
	 } 
 public String getcanalNume() {
	 return canalNume.get();
	 }
 
 public void setidAbonament(Integer valoare) {
	 idAbonament.set(valoare);
 }
 public void setNumeAb(String valoare) {
	 NumeAb.set(valoare);
 }
 public void setidClient(Integer valoare) {
	 iDClient.set(valoare);
 }
 public void setidChannel(Integer valoare) {
	 iDChannel.set(valoare);
 }
 public void setprice(String valoare) {
	 price.set(valoare);
 }
 public void setclientNume(String valoare) {
	 clientNume.set(valoare);
 }
 public void setcanalNume(String valoare) {
	 canalNume.set(valoare);
 }
 public IntegerProperty idAbonamentProperty() {
 return idAbonament;
 }
 public StringProperty NumeAbProperty() {
 return NumeAb;
 }
 public IntegerProperty iDClientpProperty() {
 return iDClient;
 }
 public IntegerProperty iDChannelProperty() {
 return iDChannel;
 }
 public StringProperty priceProperty() {
	 return price;
	 }
 public StringProperty clientNumeProperty() {
	 return clientNume;
	 }
 public StringProperty canalNumeProperty() {
	 return canalNume;
	 }
 
}