package utils.db.managers;

import classi.Book;
import utils.Costanti;

import java.sql.*;

public class BookManager {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;
    String sql = "";

    public BookManager(Connection con) {
        this.connection = con;
    }

    public int aggiungiLibro(Book book) throws SQLException {
        sql = String.format("INSERT INTO %S VALUES (NULL,?,?,?)", Costanti.TABELLA_BOOK);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getIdAutore());
        preparedStatement.setString(2, book.getTitolo());
        preparedStatement.setString(3, book.getAnnoPubblicazione());
        preparedStatement.executeUpdate();
        int id = getID();
        book.setId(id);
        preparedStatement.close();
        return id;
    }

    public void rimuoviLibroId(int id) throws SQLException {
        sql = String.format("DELETE FROM %s WHERE id = %d;",Costanti.TABELLA_BOOK, id);
        creaStatement();
        statement.executeUpdate(sql);
        chiudiStatement();

    }

    public void stampaLibri() throws SQLException {
        creaStatement();
        sql = String.format("SELECT\n" +
                "   autori.nome AS nomeAutore,\n" +
                "   autori.cognome AS cognomeAutore,\n" +
                "   book.titolo AS titoloLibro,\n" +
                "   book.anno_pubblicazione AS annoPubblicazione,\n" +
                "   book.id AS idLibro\n" +
                "FROM\n" +
                "   book\n" +
                "INNER JOIN autori ON book.id_autore = autori.id;");
        rs = statement.executeQuery(sql);
        while(rs.next()) {
            System.out.println("Autore: " + rs.getString("nomeAutore") +
                    " -- " + rs.getString("cognomeAutore") + "\n" +
                    "Id Libro: " + rs.getInt("idLibro") + "\n" +
                    "Libro: " + rs.getString("titoloLibro") +
                    " -- " + rs.getString("annoPubblicazione"));
            System.out.println();
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
