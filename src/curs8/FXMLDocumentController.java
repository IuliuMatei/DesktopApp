package curs8;
import java.awt.Window;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
*
* @author vali
*/
public class FXMLDocumentController implements Initializable {
 
 @FXML
 private TableView<Client> tabela_Clienti;
 @FXML
 private Tab tab_Client;
 @FXML
 private Button buton_IncarcareClienti;
 @FXML
 private TableColumn<Client, Integer> atribut_idClient;
 @FXML
 private TableColumn<Client, String> atribut_NumeC;
 @FXML
 private TableColumn<Client, String> atribut_PrenumeC;
 @FXML
 private TableColumn<Client, String> atribut_AdresaC;
 @FXML
 private TableColumn<Client, String> atribut_JudetC;
 @FXML
 private TableColumn<Client, String> atribut_CNPC;
 @FXML
 private TextField text_IdClient;
 @FXML
 private TextField text_NumeC;
 @FXML
 private TextField text_PrenumeC;
 @FXML
 private TextField text_Adresa;
 @FXML
 private TextField text_Judet;
 @FXML
 private TextField text_CNP;
 @FXML
 private Button buton_adaugaClient;
 @FXML
 private Button buton_modificaClient;
 @FXML
 private Button buton_stergeClient;
 @FXML
 private TableView<CanalTV> tabela_Canale;
 @FXML
 private Tab tab_CanaleTV;
 @FXML
 private Button buton_incarcareCanal;
 @FXML
 private TableColumn<CanalTV, Integer> atribut_IdCanal;
 @FXML
 private TableColumn<CanalTV, String> atribut_NumeCa;
 @FXML
 private TableColumn<CanalTV, String> atribut_Tip;
 @FXML
 private TableColumn<CanalTV, String> atribut_Locatie;
 @FXML
 private Button buton_adaugaCanal;
 @FXML
 private Button buton_modificaCanal;
 @FXML
 private Button buton_stergeCanal;
 @FXML
 private TextField text_idCanal;
 @FXML
 private TextField text_NumeCa;
 @FXML
 private TextField text_Tip;
 @FXML
 private TextField text_Locatie;
 @FXML
 private TableView<Abonament> tabela_Abonamente;
 @FXML
 private Tab tab_Abonament;
 @FXML
 private Button buton_incarcaAbonamente;
 @FXML
 private TableColumn<Abonament, Integer> atribut_idAbonament;
 @FXML
 private TableColumn<Abonament, String> atribut_NumeAb;
 @FXML
 private TableColumn<Abonament, Integer> atribut_iDClient;
 @FXML
 private TableColumn<Abonament, Integer> atribut_iDCanal;
 @FXML
 private TableColumn<Client, String> atribut_Pret;
 @FXML
 private TableColumn<Client, String> atribut_NumeCA;
 @FXML
 private TableColumn<Client, String> atribut_NumeCaA;
 @FXML
 private TextField text_idAbonament;
 @FXML
 private Button buton_stergeAbonament;
 @FXML
 private TextField text_NumeAb;
 @FXML
 private TextField text_Pret;
 @FXML 
 private TextField text_idClientAb;
 @FXML 
 private TextField text_idCanalAb;
 @FXML
 private Button buton_adaugaAbonament;
 @FXML
 private Button buton_modificaAbonament;
 
 private ObservableList<Client> dateClienti;
 private ObservableList<CanalTV> dateCanale;
 private ObservableList<Abonament> dateAbonamente;
 private DBOperations jb;
 
 @Override
 public void initialize(URL url, ResourceBundle rb) {
 jb = new DBOperations();
 } 
 @FXML
 private void incarcaClient(ActionEvent event) throws SQLException, Exception {
 jb.connect();
 dateClienti = FXCollections.observableArrayList();
 ResultSet rs = jb.vedeTabel("clients");
 while (rs.next()) {
 dateClienti.add(new Client(rs.getInt("idClient"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("adress"), rs.getString("county"), rs.getString("cnp")));
 }
 atribut_idClient.setCellValueFactory(new PropertyValueFactory<>("IdClient"));
 atribut_NumeC.setCellValueFactory(new PropertyValueFactory<>("Nume"));
 atribut_PrenumeC.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
 atribut_AdresaC.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
 atribut_JudetC.setCellValueFactory(new PropertyValueFactory<>("Judet"));
 atribut_CNPC.setCellValueFactory(new PropertyValueFactory<>("CNP"));
 
 
 tabela_Clienti.setItems(null);
 tabela_Clienti.setItems(dateClienti);
 jb.disconnect();
 }
 
 @FXML
 private void adaugaClienti(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 jb.adaugaClient(text_NumeC.getText(), text_PrenumeC.getText(), text_Adresa.getText(), text_Judet.getText(), text_CNP.getText());
	 jb.disconnect();
 }
 
 @FXML
 private void stergeClient(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_IdClient.getText();
	 long id;
	 id = java.lang.Long.parseLong(s);
	 jb.stergeTabela("clients", "idClient", id);
	 jb.disconnect();
 }
 
 @FXML
 private void modificaClient(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_IdClient.getText();
	 long aux = java.lang.Long.parseLong(s);
	 String nume = text_NumeC.getText();
	 String prenume = text_PrenumeC.getText();
	 String adresa = text_Adresa.getText();
	 String judet = text_Judet.getText();
	 String cnp = text_CNP.getText();
	 String[] valori = {nume, prenume, adresa, judet, cnp};
     String[] campuri = {"firstName", "lastName", "adress", "county", "cnp"};
     jb.modificaTabela("clients", "idClient", aux, campuri, valori);
     jb.disconnect();
	 
	 }
 @FXML
 private void incarcaCanal(ActionEvent event) throws SQLException, Exception {
 jb.connect();
 dateCanale = FXCollections.observableArrayList();
 ResultSet rs = jb.vedeTabel("tvchannels");
 while (rs.next()) {
 dateCanale.add(new CanalTV(rs.getInt("idChannel"), rs.getString("Name"), rs.getString("type"), rs.getString("locationChannel")));
 }
 atribut_IdCanal.setCellValueFactory(new PropertyValueFactory<>("idCanalTV"));
 atribut_NumeCa.setCellValueFactory(new PropertyValueFactory<>("NumeCa"));
 atribut_Tip.setCellValueFactory(new PropertyValueFactory<>("Tip"));
 atribut_Locatie.setCellValueFactory(new PropertyValueFactory<>("Locatie"));
 
 tabela_Canale.setItems(null);
 tabela_Canale.setItems(dateCanale);
 jb.disconnect();
 }
 
 @FXML
 private void adaugaCanal(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 jb.adaugaCanalTV(text_NumeCa.getText(), text_Tip.getText(), text_Locatie.getText());
	 jb.disconnect();
 }
 
 @FXML
 private void stergeCanal(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_idCanal.getText();
	 long id;
	 id = java.lang.Long.parseLong(s);
	 jb.stergeTabela("tvchannels", "idChannel", id);
	 jb.disconnect();
 }

@FXML
private void modificaCanal(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_idCanal.getText();
	 long aux = java.lang.Long.parseLong(s);
	 String numeCa = text_NumeCa.getText();
	 String tip = text_Tip.getText();
	 String locatie = text_Locatie.getText();
	 String[] valori = {numeCa, tip, locatie};
	 String[] campuri = {"name", "type", "locationChannel"};
	 jb.modificaTabela("tvchannels", "idChannel", aux, campuri, valori);
	 jb.disconnect();
		}
@FXML
private void incarcaAbonamente(ActionEvent event) throws SQLException, Exception {
	jb.connect();
	dateAbonamente = FXCollections.observableArrayList();
	String numeC;
	String numeCa;
	ResultSet rs = jb.vedeTabel("subscription");
	while (rs.next()) {
	numeC = jb.intoarcefirstName("clients", rs.getInt("idClient"));
	numeCa = jb.intoarceName("tvchannels", rs.getInt("idChannel"));
	dateAbonamente.add(new Abonament(rs.getInt("idSubscription"), rs.getString("nameSubscription"), rs.getInt("idClient"), rs.getInt("idChannel"), rs.getString("price"), numeC, numeCa));
	}
	atribut_idAbonament.setCellValueFactory(new PropertyValueFactory<>("idAbonament"));
	atribut_NumeAb.setCellValueFactory(new PropertyValueFactory<>("NumeAb"));
	atribut_iDClient.setCellValueFactory(new PropertyValueFactory<>("idClient"));
	atribut_iDCanal.setCellValueFactory(new PropertyValueFactory<>("iDChannel"));
	atribut_Pret.setCellValueFactory(new PropertyValueFactory<>("price"));
	atribut_NumeCA.setCellValueFactory(new PropertyValueFactory<>("clientNume"));
	atribut_NumeCaA.setCellValueFactory(new PropertyValueFactory<>("canalNume"));
	
	tabela_Abonamente.setItems(null);
	tabela_Abonamente.setItems(dateAbonamente);
	jb.disconnect();
}

@FXML
private void adaugaAbonament(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 int id1, id2;
	 id1 = java.lang.Integer.parseInt(text_idClientAb.getText());
	 id2 = java.lang.Integer.parseInt(text_idCanalAb.getText());
	 jb.adaugaAbonament(text_NumeAb.getText(), id1, id2, text_Pret.getText());
	 jb.disconnect();
}

@FXML
private void modificaAbonament(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_idAbonament.getText();
	 long aux = java.lang.Long.parseLong(s);
	 String numeAb = text_NumeAb.getText();
	 String idClient = text_idClientAb.getText();
	 String idCanal = text_idCanalAb.getText();
	 String pret = text_Pret.getText();
	 String[] valori = {numeAb, idClient, idCanal, pret};
	 String[] campuri = {"nameSubscription", "idClient", "idChannel", "price"};
	 jb.modificaTabela("subscription", "idSubscription", aux, campuri, valori);
	 jb.disconnect();
		}

@FXML
private void stergeAbonament(ActionEvent event) throws SQLException, Exception{
	 jb.connect();
	 String s = text_idAbonament.getText();
	 long id;
	 id = java.lang.Long.parseLong(s);
	 jb.stergeTabela("subscription", "idSubscription", id);
	 jb.disconnect();
}
	 
	 }
