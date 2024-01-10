package utils.db.managers;

import classi.Autori;
import utils.Costanti;

import java.sql.*;

public class AutoriManager {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    String sql = "";

    public AutoriManager(Connection con) {
        this.connection = con;
    }

    public int aggiungiAutore(Autori person) throws SQLException {
        sql = String.format("INSERT INTO %s VALUES (NULL,?,?)", Costanti.TABELLA_AUTORI);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, person.getNome());
        preparedStatement.setString(2, person.getCognome());
        preparedStatement.executeUpdate();
        int id = getID();
        person.setId(id);
        preparedStatement.close();
        return id;
    }

    public void rimuoviAutoreId(int id) throws SQLException {
        sql = String.format("DELETE FROM %s WHERE id = %d;",Costanti.TABELLA_AUTORI, id);
        creaStatement();
        statement.executeUpdate(sql);
        chiudiStatement();
    }

    public void stampaAutori() throws SQLException {
        creaStatement();
        sql = String.format("SELECT * FROM %s", Costanti.TABELLA_AUTORI);
        rs = statement.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getInt("id") +
                    " -- " + rs.getString("nome") +
                    " -- " + rs.getString("cognome"));
        }
    }

    private void creaStatement() throws SQLException {
        statement = connection.createStatement();
    }

    private void chiudiStatement() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    private int getID() throws SQLException {
        creaStatement();
        rs = statement.executeQuery("SELECT LAST_INSERT_ID();");
        if(rs.next()) {
            return rs.getInt(1);
        }
        chiudiStatement();
        return -1;
    }
}
