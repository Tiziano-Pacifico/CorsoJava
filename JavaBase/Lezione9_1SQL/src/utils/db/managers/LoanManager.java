package utils.db.managers;

import classi.Autori;
import classi.Loan;
import utils.Costanti;

import java.sql.*;

public class LoanManager {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    String sql = "";
    
    public LoanManager(Connection con) {
        this.connection = con;
    }

    public void aggiungiPrestito(Loan loan) throws SQLException {
        sql = String.format("INSERT INTO %s VALUES (?,?)", Costanti.TABELLA_PRESTITI);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, loan.getId_person());
        preparedStatement.setInt(2, loan.getid_book());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void rimuoviPrestitoId(int idLibro) throws SQLException {
        sql = String.format("DELETE FROM %s WHERE id_libro = %d;",Costanti.TABELLA_PRESTITI, idLibro);
        creaStatement();
        statement.executeUpdate(sql);
        chiudiStatement();
    }

    public void stampaPrestiti() throws SQLException {
        creaStatement();
        sql = String.format("SELECT\n" +
                "    person.nome AS nomePersona,\n" +
                "    person.cognome AS cognomePersona,\n" +
                "    book.titolo AS titoloLibro,\n" +
                "    book.id AS idLibro,\n" +
                "    autori.nome AS nomeAutore,\n" +
                "    autori.cognome AS cognomeAutore\n" +
                "FROM\n" +
                "    prestiti\n" +
                "INNER JOIN person ON prestiti.id_persona = person.id\n" +
                "INNER JOIN book ON prestiti.id_libro = book.id\n" +
                "INNER JOIN autori ON book.id_autore = autori.id;");
        rs = statement.executeQuery(sql);
        while(rs.next()) {
            System.out.println("Cliente: " + rs.getString("nomePersona") +
                    " -- " + rs.getString("cognomePersona") + "\n" +
                    "Titolo Libro: " + rs.getString("titoloLibro") + "\n" +
                    "Id Libro: " + rs.getInt("idLibro") + "\n" +
                    "Autore: " + rs.getString("nomeAutore") +
                    " -- " + rs.getString("cognomeAutore"));
            System.out.println();
        }
        System.out.println();
    }
    
    private void creaStatement() throws SQLException {
        statement = connection.createStatement();
    }

    private void chiudiStatement() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

}
