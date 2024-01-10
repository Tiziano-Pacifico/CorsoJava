package utils.db;

import classi.Autori;
import classi.Book;
import classi.Cliente;
import classi.Loan;
import utils.Costanti;
import utils.db.managers.AutoriManager;
import utils.db.managers.BookManager;
import utils.db.managers.ClienteManager;
import utils.db.managers.LoanManager;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Interfaccia al DB per il CLient, gestisce tutti i manager delle varie tabelle
 */
public class DbInterface {

    private LibrayDatabase libraryDb;
    private BookManager bm;
    private ClienteManager pm;
    private AutoriManager am;
    private LoanManager lm;

    public DbInterface() {
        this.libraryDb = LibrayDatabase.getInstance();
        bm = new BookManager(libraryDb.getConnection());
        pm = new ClienteManager(libraryDb.getConnection());
        am = new AutoriManager(libraryDb.getConnection());
        lm = new LoanManager(libraryDb.getConnection());
    }

    public void connetti() {

        try {
            if(libraryDb.connetti(Costanti.NOME_DB)){
                System.out.printf("Connessione al DB %s avvenuta con successo\n", Costanti.NOME_DB);
            }
        } catch (SQLException e) {
            System.out.println("Problema di connessione" + e.getMessage());
        }
    }

    public void disconnetti() {
        try {
            if(libraryDb.disconnetti()){
                System.out.printf("Disconnessione dal DB %s avvenuta con successo", Costanti.NOME_DB);
            }
        } catch (SQLException e) {
            System.out.println("Problema di disconnessione" + e.getMessage());
        }
    }

    public int aggiungi(Object obj) {
        int id = -1;
        try {
            if(obj instanceof Book){
                id = this.bm.aggiungiLibro((Book) obj);
                System.out.println("Libro aggiunto");
            }
            if(obj instanceof Autori) {
                id = this.am.aggiungiAutore((Autori) obj);
                System.out.println("Autore aggiunto");
            }
            if(obj instanceof Cliente) {
                id = this.pm.aggiungiPersona((Cliente) obj);
                System.out.println("Cliente aggiunto");
            }
        } catch (SQLException e) {
            System.out.println("Problema inserimento :" + e.getMessage());
        }
        System.out.println();
        return id;
    }

    public void cancellaPerId(int id, int oggetto) {
        try {
            if(oggetto == Costanti.LIBRO){
                this.bm.rimuoviLibroId(id);
                System.out.println("Libro cancellato");
            }
            if(oggetto == Costanti.AUTORE) {
                this.am.rimuoviAutoreId(id);
                System.out.println("Autore cancellato");
            }
            if(oggetto == Costanti.CLIENTE) {
                this.pm.rimuoviPersonaId(id);
                System.out.println("Cliente cancellato");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Non posso cancellare l'autore di un libro in archivio");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void stampa(int oggetto) {
        try {
            if(oggetto == Costanti.LIBRO) {
                this.bm.stampaLibri();
            }
            if(oggetto == Costanti.AUTORE) {
                this.am.stampaAutori();
            }
            if(oggetto == Costanti.CLIENTE) {
                this.pm.stampaPersone();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserisciPrestito(Loan loan) {
        try {
            lm.aggiungiPrestito(loan);
        } catch (SQLIntegrityConstraintViolationException e) {
            if(e.getMessage().contains("Duplicate entry")) {
                System.out.println("Il libro è già in prestito");
            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void stampaListaPrestiti() {
        try {
            lm.stampaPrestiti();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void annullaPrestito(int idLibro) {
        try {
            lm.rimuoviPrestitoId(idLibro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
