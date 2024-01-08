import java.sql.*;

public class DbManager {
    //Dichiarazione oggetti
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String username;
    private String password;
    private String dbName;
    private final String path = DbUtility.loadDati()[3];

    //Impostazione connessione

    public DbManager(String username, String password, String dbName) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;

    }

    //metodo connessione
    public boolean connetti() throws SQLException {
        boolean connesso = false;
        String URLConnessione = path + dbName;
        connection = DriverManager.getConnection(URLConnessione, username, password);
        if(connection != null) {
            connesso = true;
        }
        return connesso;
    }

    private Statement creaStatement() throws SQLException {
        return statement = connection.createStatement();
    }

    //Metodo per creare una tabella
    public int creaTabella(String nomeTabella) throws SQLException {
        String sql = String.format("CREATE TABLE %s (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "numDoc VARCHAR(15) NOT NULL," +
                "scadenza VARCHAR(10) NOT NULL," +
                "datarilascio VARCHAR(10) NOT NULL)" , nomeTabella);
        System.out.println(sql);
        int numRowUpdated = 0;
        statement = creaStatement();
        numRowUpdated = statement.executeUpdate(sql);
        return numRowUpdated;
    }

    public void craDb(String dbName) throws SQLException {
        connection = DriverManager.getConnection(path, username, password);
        statement = creaStatement();
        String sql = "CREATE DATABASE " + dbName;
        statement.executeUpdate(sql);
        connection.close();
    }

    //Inserimento dati nella tabella dei documenti
    public int inserisciDatiInDocumento(String nomeTabella, String numDocumento, String scad, String rilascio) throws SQLException {
        String sql = String.format("INSERT INTO %s VALUES (NULL,?,?,?)", nomeTabella);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, numDocumento);
        preparedStatement.setString(2, scad);
        preparedStatement.setString(3, rilascio);

        //eseguo la query di aggiornamento
        int recordIseriti = preparedStatement.executeUpdate();
        return  recordIseriti;
    }

    //select sulla tabella usando i metadati
    public void estraiDatiTabella(String tabella) throws SQLException {
        //ottengo i metadati riferiti alla tabella
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String sql = "SELECT * FROM " + tabella;
        ResultSet rsQuery = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = rsQuery.getMetaData();
        int numeroColonne = resultSetMetaData.getColumnCount();
        System.out.println("Totale colonne: " + numeroColonne);
        System.out.println("Dettagli colonne");
        for (int i = 1; i<=numeroColonne; i++) {
            System.out.println("-- " + resultSetMetaData.getColumnName(i) + " è di tipo " + resultSetMetaData.getColumnTypeName(i));
        }
    }

    //inserimento dati nelle tabelle di gestione dei documenti
    public int insertIntoDocument(String nomeTabella, String numDoc, String scadenza, String datarilascio) throws SQLException {
        String sql = "INSERT INTO " + nomeTabella + " VALUES (NULL,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, numDoc);
        preparedStatement.setString(2, scadenza);
        preparedStatement.setString(3, datarilascio);

        return preparedStatement.executeUpdate();
    }

    //Metodo di chiusura della connessione
    public void disconnetti () throws SQLException {
        connection.close();
        //statement.close();
    }
    //estraiamo un singolo record
    public void estraiDocumento (String tabella, String id) throws SQLException {
        String sql = "SELECT * FROM "+tabella+ " WHERE id = ? ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Reocrd numero " + resultSet.getRow());
            System.out.println("Id: " + resultSet.getString("id"));
            System.out.println("Numero Documento: " + resultSet.getString("numDoc"));
            System.out.println("Data Rilascio: " + resultSet.getString("datarilascio"));
            System.out.println("Data Scadenza: " + resultSet.getString("scadenza"));
        }

    }
}
