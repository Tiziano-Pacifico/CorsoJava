package utils.dbutils;

import utils.Costanti;

import java.sql.*;

/**
 * Classe per la gestione del DB
 * Si occupa di caricare le properties, di avviare e chiudere la connessione
 * Implementa il pattern Singleton, voglio avere una sola risorsa di connessione al DB
 */
public class DBManager {

    private Connection connection = null;

    private String username;
    private String password;
    private String dbName;
    private String path;

    private String[] datiConfigurazione;

    private static DBManager instance;

    private DBManager() {
        datiConfigurazione = DbUtility.loadDati();
        this.username = datiConfigurazione[Costanti.USERNAME];
        this.dbName = datiConfigurazione[Costanti.DB_NAME];
        this.password = datiConfigurazione[Costanti.PASSWORD];
        this.path = datiConfigurazione[Costanti.PATH];
        try {
            connetti("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public boolean connetti(String dbName) throws SQLException {
        boolean connesso = false;
        String URLConnessione = path + dbName;
        //if(connection != null) {connection.close();}
        connection = DriverManager.getConnection(URLConnessione, username, password);
        if(connection != null) {
            connesso = true;
        }
        return connesso;
    }

    public void disconnetti () throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
