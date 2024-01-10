package utils.db;

import utils.Costanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La classe gestisce la connessione e la disconnessione dal DB
 */
public class LibrayDatabase {

    private Connection connection = null;

    private String username;
    private String password;
    private String dbName;
    private String path;

    private String[] datiConfigurazione;

    private static LibrayDatabase instance;

    private LibrayDatabase() {
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

    public static LibrayDatabase getInstance() {
        if (instance == null) {
            instance = new LibrayDatabase();
        }
        return instance;
    }

    public boolean connetti(String dbName) throws SQLException {
        boolean connesso = false;
        String URLConnessione = path + dbName;
        connection = DriverManager.getConnection(URLConnessione, username, password);
        if(connection != null) {
            connesso = true;
        }
        return connesso;
    }

    public boolean disconnetti () throws SQLException {
        boolean disconnesso = false;
        if(connection != null) {
            connection.close();
            disconnesso = true;
            return disconnesso;
        }
        return disconnesso;
    }

    public Connection getConnection() {
        return connection;
    }
}
