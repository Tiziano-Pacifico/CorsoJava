package utils.dbutils;

import classi.Utente;
import utils.Costanti;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che crea una interfaccia per l'utilizzo del db
 * Si occupa anche della gestione delle eccezioni lanciate dai metodi degli oggetti attributo
 */
public class DbInterface {

    private DBManager dbManager;
    private DbCRUD dbCRUD;

    public DbInterface() {
        this.dbManager = DBManager.getInstance();
        this.dbCRUD = new DbCRUD(dbManager.getConnection());
    }

    public void inizializeDB() {

        //Controllo se esiste il DB altrimenti lo creo
        hasDB();
        //Controllo se esiste la tabella utenti altrimenti la creo
        hasTable();

    }

    public void closeConnection() {
        try {
            this.dbManager.disconnetti();
        } catch (SQLException e) {
            System.out.println("Problemi di disconnessione: "  + e.getMessage());
        }
    }

    public void insertRecord(Utente user) {
        try {
            this.dbCRUD.insertRecord(user);
        } catch (SQLException e) {
            System.out.println("Problemi di inserimento utente: " + e.getMessage());
        }
    }

    public void deleteRecord(int id) {
        try {
            this.dbCRUD.deleteRecord(id);
        } catch (SQLException e) {
            System.out.println("Problema durante la cancellazione del record: " + e.getMessage());
        }
    }

    public Utente estraiRecord(int id) {
        Utente user = null;
        try {
            user = this.dbCRUD.extractRecord(id);
        } catch (SQLException e) {
            System.out.println("Problemi durante l'estrazione dell'utente: " + e.getMessage());
        }
        return user;
    }
    public ArrayList<Integer> stampaTabella() {
        ArrayList<Integer> listaIds = new ArrayList<>();
        try {
            listaIds = dbCRUD.stampaTabella(Costanti.NOME_TABELLA);
        } catch (SQLException e) {
            System.out.println("Problemi durante la stampa della tabella: " + e.getMessage());
        }
        return listaIds;
    }

    public void setDbConnection() {
        try {
            this.dbManager.connetti(Costanti.NOME_DB);
            this.dbCRUD.setConnection(this.dbManager.getConnection());
        } catch (SQLException e) {
            System.out.println("Problema di connessione: " + e.getMessage());
        }
    }

    //Metodi privati
    private void hasDB() {
        try {
            if (!dbCRUD.isDb(Costanti.NOME_DB)) {
                System.out.println("\nIl database degli utenti non è presente, lo creo");
                dbCRUD.creaDb(Costanti.NOME_DB); //Devo ristabilire una connessione dopo aver creato il db
                this.dbCRUD.setConnection(this.dbManager.getConnection());
            }
        } catch (SQLException e) {
            System.out.println("Problema nella creazione del db: " + e.getMessage());
        }
        try {

            this.dbManager.connetti(Costanti.NOME_DB);
            this.dbCRUD.setConnection(this.dbManager.getConnection());
        } catch (SQLException e) {
            System.out.println("Problema di connessione dopo la creazione del DB: " + e.getMessage());
        }
    }

    private void hasTable() {
        try {
            if(!dbCRUD.isTable(Costanti.NOME_TABELLA)) {
                System.out.println("Non è presente una tabella per gli utenti, la creo");
                dbCRUD.creaTabella(Costanti.NOME_TABELLA);
            }
        } catch (SQLException e) {
            System.out.println("Problemi nella creazione della tabella: " +  e.getMessage()
            );
        }
    }


}
