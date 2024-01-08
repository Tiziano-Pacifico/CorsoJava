import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        a) importo il driver
        b) collegare il driver al database
            1)Url di connessione: il path dove si trova mysql
            2)User
            3)Password
                --> creo un'unica stringa di connessione URL+USER+path
        c) Aprire una connessione verso il database
        d) creare un oggetto di tipo Statement --> consente di eseguire operazioni sul db
        e) eseguo operazioni CRUD su database e tabelle
         */

        String db_url = "jdbc:mysql://localhost:3306/javabase";
        String user = "root";
        String password = "Ferolux1!";
        String database = "javabase";

        try {
            Connection con = DriverManager.getConnection(db_url, user, password);
            Statement statement = con.createStatement();
            String insert = "INSERT INTO fimmine VALUES (null,'qewr','fgdfg')";
            boolean inserimento = statement.execute(insert);
            System.out.println(inserimento);
            String risultato = (inserimento)? "Dati inseriti" : "Dati non inseriti";
            System.out.println(risultato);

            String sql = "SELECT id, nome, cognome FROM fimmine";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("Record numero: " + rs.getRow());
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Nome: " + rs.getString("nome"));
                System.out.print(", Cognome: " + rs.getString("cognome"));
                System.out.println();
            }

            //Per recuperare i vari dati del database, tabelle colonne etc
            String[] types = {"TABLE"}; //filtro per determinare il tipo di dati restituiti dalla query
            DatabaseMetaData databaseMetaData = con.getMetaData();
            ResultSet rsmd = databaseMetaData.getTables(database, null, null, types);


            System.out.println("------INFORMAZIONI SUL DATABASE ------");
            System.out.println("Versione: " + databaseMetaData.getDatabaseProductVersion());
            System.out.println("Driver Usato: " + databaseMetaData.getDriverName());
            System.out.println("Driver Versione: " + databaseMetaData.getDriverVersion());
            System.out.println("Username: " + databaseMetaData.getUserName());
            System.out.println("URL database: " + databaseMetaData.getURL());

            while (rsmd.next()) {
                String tableName = rsmd.getString("TABLE_NAME");
                System.out.println("Nome della tabella: " + tableName);
                sql = "SELECT * FROM " + tableName;
                ResultSet rsQuery = statement.executeQuery(sql);
                ResultSetMetaData resultSetMetaData = rsQuery.getMetaData();
                int numeroColonne = resultSetMetaData.getColumnCount();
                System.out.println("Totale colonne: " + numeroColonne);
                System.out.println("Dettagli colonne");
                for (int i = 1; i<=numeroColonne; i++) {
                    System.out.println("-- " + resultSetMetaData.getColumnName(i) + " è di tipo " + resultSetMetaData.getColumnTypeName(i));
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {

        }
    }
}