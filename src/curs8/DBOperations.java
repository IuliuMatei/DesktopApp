package curs8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
*
* @author vali
*/
public class DBOperations {
 String error;
 Connection con;
 // Conectarea la baza de date
 public DBOperations() {
 }
 public void connect() throws ClassNotFoundException, SQLException, Exception {
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/broadcasting?useSSL=false", "root", "SwAg1211#$16");
 } catch (ClassNotFoundException cnfe) {
 error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
 throw new ClassNotFoundException(error);
 } catch (SQLException cnfe) {
 error = "SQLException: Nu se poate conecta la baza de date.";
 throw new SQLException(error);
 } catch (Exception e) {
 error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
 throw new Exception(error);
 }
 }
 // end connect()
 public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
	 ResultSet rs = null;
	 try {
		 String queryString = ("select * from `broadcasting`.`" + tabel + "`;");
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery(queryString);
	 } catch (SQLException sqle) {
		 error = "SQLException: Interogarea nu a fost posibila.";
		 throw new SQLException(error);
	 } catch (Exception e) {
		 error = "A aparut o exceptie in timp ce se extrageau datele.";
		 throw new Exception(error);
	 }
	 return rs;
 }
 // end vedeTabel()
 public void disconnect() throws SQLException {
 try {
 if (con != null) {
 con.close();
 }
 } catch (SQLException sqle) {
 error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
 throw new SQLException(error);
 }
 } // disconnect()
 public void adaugaClient(String Nume, String Prenume, String Adresa, String Judet, String CNP) throws SQLException {
 try {
 // create a prepared SQL statement
 Statement stmt;
 stmt = con.createStatement();
 stmt.executeUpdate("insert into `broadcasting`.`clients`(firstName, lastName, adress, county, cnp) values('" + Nume + "', '" + Prenume + 
"', '" + Adresa + "' , '" + Judet + "' , '" + CNP + "');");
 } catch (SQLException sqle) {
 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
 throw new SQLException(error);
 }
 }
 // end adaugaClient()
 
 public void adaugaCanalTV(String NumeCa, String Tip, String Locatie) throws SQLException {
 try {
 // create a prepared SQL statement
 Statement stmt;
 stmt = con.createStatement();
 stmt.executeUpdate("insert into `broadcasting`.`TVchannels`(name, type, locationChannel) values('" + NumeCa + "', '" + Tip + "', '" + Locatie + "');");
 } catch (SQLException sqle) {
 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
 throw new SQLException(error);
 }
 }
 
 public void adaugaAbonament(String name, int idClient, int idChannel, String price)
         throws SQLException, Exception {
     if (con != null) {
         try {
//creaza un "prepared SQL statement"
             Statement stmt;
             stmt = con.createStatement();
             stmt.executeUpdate("insert into subscription(idClient, idChannel, nameSubscription, price) values('" + idClient + "'  , '" + idChannel + "', '" + name + "' , '"+ price + "');");
             // se poate modifica valoarea datei astfel incat sa se ia data curenta a sistemului:

         } catch (SQLException sqle) {
             error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
             throw new SQLException(error);
         }
     } else {
         error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
         throw new Exception(error);
     }
 }
 
 
 
 public ResultSet vedeAbonament() throws SQLException, Exception {
     ResultSet rs = null;
     try {
         String queryString = ("select a.firstName firstName, a.lastName lastName, a.adress, a.county, a.cnp, b.name name, b.type, c.idSubscription, c.idClient idClient, c.idChannel idChannel, c.nameSubscription, c.price from clients a, tvchannels b, subscription c where a.idClient = c.idClient and b.idChannel = c.idChannel;");
         Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY*/);
         rs = stmt.executeQuery(queryString);
     } catch (SQLException sqle) {
         error = "SQLException: Interogarea nu a fost posibila.";
         throw new SQLException(error);
     } catch (Exception e) {
         error = "A aparut o exceptie in timp ce se extrageau datele.";
         throw new Exception(error);
     }
     return rs;
 }
 public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
	 if (con != null) {
	 try {
		 Statement stmt;
		 stmt = con.createStatement();
		 stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
	 } catch (SQLException sqle) {
		 error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
		 throw new SQLException(error);
	 }
	 } else {
		 error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
		 throw new Exception(error);
	 }
 } // end of stergeTabela()
 public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
 throws SQLException, Exception {
	 String update = "update " + tabela + " set ";
	 String temp = "";
	 if (con != null) {
		 try {
			 for (int i = 0; i < campuri.length; i++) {
			 if (i != (campuri.length - 1)) {
			 temp = temp + campuri[i] + "='" + valori[i] + "', ";
		 } else {
			 temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
		 		}
			 }
			 update = update + temp;
			 Statement stmt;
			 stmt = con.createStatement();
			 stmt.executeUpdate(update);
		 } catch (SQLException sqle) {
			 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			 throw new SQLException(error);
		 }
		 } else {
			 error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			 throw new Exception(error);
	 }
 } // end of modificaTabela()
 
 public String intoarcefirstName(String tabela, int ID) throws SQLException, Exception {
     ResultSet rs = null;
     String name = null;
     try {
//Executa interogarea
         String queryString = ("SELECT firstName FROM " + tabela + " where idClient=" + ID + ";");
         Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         rs = stmt.executeQuery(queryString); //sql exception
         while (rs.next()) {
        	 name = rs.getString("firstName");
         }
         //return name;
     } catch (SQLException sqle) {
         error = "SQLException: Interogarea nu a fost posibila.";
         throw new SQLException(error);
     } catch (Exception e) {
         error = "A aparut o exceptie in timp ce se extrageau datele.";
         throw new Exception(error);
     }
     return name;
 }
 
 public String intoarceName(String tabela, int ID) throws SQLException, Exception {
     ResultSet rs = null;
     String name = null;
     try {
//Executa interogarea
         String queryString = ("SELECT name FROM " + tabela + " where idChannel=" + ID + ";");
         Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         rs = stmt.executeQuery(queryString); //sql exception
         while (rs.next()) {
        	 name = rs.getString("name");
         }
         //return name;
     } catch (SQLException sqle) {
         error = "SQLException: Interogarea nu a fost posibila.";
         throw new SQLException(error);
     } catch (Exception e) {
         error = "A aparut o exceptie in timp ce se extrageau datele.";
         throw new Exception(error);
     }
     return name;
 }
 
 public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception{
int idClient;
String Nume, Prenume, Adresa, County, CNP;
while(rs.next()){
idClient = rs.getInt("idClient");
Nume = rs.getString("firstName");
Prenume = rs.getString("lastName");
Adresa = rs.getString("adress");
County = rs.getString("county");
CNP = rs.getString("cnp");
 System.out.println("IdClient = " + idClient + ", Nume = " + Nume + ", Prenume = " + Prenume + ", Adresa = " + Adresa + ", Judet = " + County + ", CNP = " + CNP);
}
}
}