package utils.loggedFunctionalities;

import classi.Utente;
import classi.prodotti.ArchivioProdotti;
import classi.prodotti.Prodotto;
import utils.Costanti;
import utils.dbutils.DbInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private DbInterface dbInterface = new DbInterface();

    Scanner scanner = new Scanner(System.in);
    int scelta;
    ArchivioProdotti archivioProdotti = new ArchivioProdotti();

    public Store() {
        dbInterface.setDbConnection();
    }

    public int logIn() {
        System.out.println("Ecco la lista degli utenti: ");
        ArrayList<Integer> listaIDs = this.dbInterface.stampaTabella();
        int id;
        do {
            System.out.println("Inserisci id utente");
            id = scanner.nextInt();
            if(!listaIDs.contains(id)) {
                System.out.println("Id non presente");
            }
        }while (!listaIDs.contains(id));
        System.out.println();
        return id;
    }

    public Utente cercaUtente(int id) {
        Utente user = dbInterface.estraiRecord(id);
        user.setId(id);
        return user;
    }

    public Prodotto acquistaProdotto(){
        Prodotto prodotto = null;
        System.out.println("Cosa vuoi acquistare: \n1)Libro\n2)Prodotto elettronico\n");
        scelta  = scanner.nextInt();
        switch (scelta) {
            case Costanti.LIBRO:
                archivioProdotti.listaLibri();
                System.out.println("Che libro vuoi acquistare?");
                scelta = scanner.nextInt();
                prodotto = archivioProdotti.getLibri().get(scelta);
                break;
            case Costanti.PRODOTTO_ELETTRONICO:
                archivioProdotti.listaProdottiElettronici();
                System.out.println("Che prodotto vuoi acquistare?");
                scelta = scanner.nextInt();
                prodotto = archivioProdotti.getProdottiElettronici().get(scelta);
                break;
            default:
                System.out.println("Scelta non valida");
                scelta = 0;
        }
        return prodotto;
    }
}
