package utils.creators;

import classi.Utente;
import utils.dbutils.DbInterface;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe che si occupa della creazione degli oggetti e di tutte le azioni conseguenti(Esempio inserimento nel db, salvataggio su file etc...)
 */
public class Creator {

    private Scanner scanner = new Scanner(System.in);

    private DbInterface dbInterface = new DbInterface();

    public Creator() {
        //Di default dbInterface setta solo la connessione a mySql, devo forzare la connessione allo specifico DB
        dbInterface.setDbConnection();
    }

    /**
     * Crea un utente e lo inserisce direttamente nel db degli utenti
     * @return Utente
     */
    public Utente creaUtente() {
        String nome, indirizzo;
        System.out.println("Nome utente: ");
        nome = scanner.next();
        System.out.println("Indirizzo: ");
        indirizzo = scanner.next();
        Utente user = new Utente(nome, indirizzo);
        dbInterface.insertRecord(user);
        return user;
    }

    public void cancellaUtente() {
        ArrayList<Integer> listaIDs = this.dbInterface.stampaTabella();
        int id;
        do {
            System.out.println("Inserisci id utente da cancellare");
            id = scanner.nextInt();
            if(!listaIDs.contains(id)) {
                System.out.println("Id non presente");
            }
        }while (!listaIDs.contains(id));
        dbInterface.deleteRecord(id);
    }
}
