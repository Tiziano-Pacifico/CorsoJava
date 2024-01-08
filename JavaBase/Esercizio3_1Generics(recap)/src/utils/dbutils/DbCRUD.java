package utils.dbutils;

import classi.Utente;
import utils.Costanti;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di tutte le operazioni CRUD sul db
 */
public class DbCRUD {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    //Costruttore
    public DbCRUD(Connection connection) {
        this.connection = connection;
    }


    //Metodi pubblici
    public void creaDb(String dbName) throws SQLException {
        creaStatement();
        String sql = "CREATE DATABASE " + dbName;
        statement.executeUpdate(sql);
        chiudiStatement();
    }

    public void creaTabella(String nomeTabella) throws SQLException {
        creaStatement();
        String sql = String.format("CREATE TABLE %s (id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(30) NOT NULL," +
                "indirizzo VARCHAR(30) NOT NULL)", nomeTabella);
        statement.executeUpdate(sql);
        chiudiStatement();
    }

    public ArrayList<Integer> stampaTabella(String nomeTabella) throws SQLException {
        ArrayList<Integer> listaIds = new ArrayList<>();
        creaStatement();
        String sql = String.format("SELECT * FROM %s", nomeTabella);
        rs = statement.executeQuery(sql);
        while(rs.next()) {
            listaIds.add(rs.getInt("id"));
            System.out.println(rs.getInt("id") + " -- " + rs.getString("nome") + " -- " + rs.getString("indirizzo"));
        }

        chiudiStatement();
        return listaIds;
    }

    public boolean isDb(String nomeDb) throws SQLException {
        creaStatement();
        rs = statement.executeQuery("SHOW DATABASES");
        while (rs.next()) {
            String db = rs.getString(1);
            if(db.equalsIgnoreCase(nomeDb)){
                chiudiStatement();
                return true;
            }
        }
        chiudiStatement();
        return false;
    }

    public boolean isTable(String nomeTabella) throws SQLException {
        creaStatement();
        String[] types = {"TABLE"}; //filtro per determinare il tipo di dati restituiti dalla query
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        rs = databaseMetaData.getTables(Costanti.NOME_DB, null, null, types);

        while(rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if(tableName.equalsIgnoreCase(nomeTabella)) {
                chiudiStatement();
                return true;
            }
        }
        chiudiStatement();
        return false;
    }

    public void insertRecord(Utente user) throws SQLException {
        String sql = String.format("INSERT INTO %s VALUES (NULL,?,?)", Costanti.NOME_TABELLA);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getNome());
        preparedStatement.setString(2, user.getIndirizzo());
        preparedStatement.executeUpdate();
        creaStatement();
        rs = statement.executeQuery("SELECT LAST_INSERT_ID();");
        if(rs.next()) {
            user.setId(rs.getInt(1));
        }
        chiudiStatement();
        preparedStatement.close();
    }

    public void deleteRecord(int id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = %d;",Costanti.NOME_TABELLA, id);
        creaStatement();
        statement.executeUpdate(sql);
        chiudiStatement();

    }

    public Utente extractRecord(int id) throws SQLException {
        Utente user = null;
        String sql = "SELECT * FROM "+ Costanti.NOME_TABELLA + " WHERE id = ? ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        rs = preparedStatement.executeQuery();
        if(rs.next()) {
            user = new Utente(rs.getString("nome"), rs.getString("indirizzo"));
        }
        else
        preparedStatement.close();
        return user;
    }


    //Metodi privati
    private void creaStatement() throws SQLException {
        statement = connection.createStatement();
    }

    private void chiudiStatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Getter Setter

    public void setConnection(Connection connection) throws SQLException {
        //connection.close();
        this.connection = connection;
    }
}
