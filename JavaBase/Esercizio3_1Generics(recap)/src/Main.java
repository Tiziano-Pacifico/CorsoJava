import classi.Utente;
import classi.logics.Carrello;
import classi.prodotti.Prodotto;
import utils.ArchivioDati;
import utils.Costanti;
import utils.creators.Creator;
import utils.init.BaseInit;
import utils.init.Init;
import utils.init.initDecorator.DbInitDecorator;
import utils.init.initDecorator.UserInitDecorator;
import utils.loggedFunctionalities.Store;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Funzionalità interfaccia da implementare:
        - Loggare utente (Log In, recupero informazioni utente)
        - Aggiungere utente (Sign up, salvato automaticamente)
        - Rimuovere utente
        - Log out utente(salvataggio carrello e storico acquisti)
        Se utente loggato:
        - aggiungere/rimuovere prodotto al /stampare carrello
        - checkout (applicare le offerte)
        - salvare carrello
         */

        //@Todo come connettere utenti e carrello, log out

        //Java Utils
        Scanner scanner = new Scanner(System.in);
        //Variabili
        int scelta = -1;
        //Oggetti
        Utente user = new Utente();
        //Local Utils
        Creator creator = new Creator();
        Store store = new Store();



        //Apro la connessione al DB
        Init dbInizializer = new DbInitDecorator(new BaseInit());
        dbInizializer.init();
        Init userInizializer;

        do {
            System.out.println("cosa vuoi fare: \n1) Log in\n2) Sign up\n3)Cancella utente\n4)Esci");
            scelta = scanner.nextInt();

            //Creare utenti e inserirli nel db

            switch (scelta) {
                case Costanti.LOG_IN:
                    user = new Utente();
                    userInizializer = new UserInitDecorator(new BaseInit(), user);
                    userInizializer.init();
                    System.out.println(user.toString() + "\n");
                    //Implementare logica acquisto(Sottomenu)
                        //CheckOut (Salva su file carrello e storico acquisti)
                    do{
                        System.out.println("Cosa vuoi fare: \n1) Acquista prodotto\n2) stampa carrello\n3) stampa storico acquisti\n4) Check Out\n5) Sign Out\n");
                        scelta = scanner.nextInt();
                        switch(scelta) {

                            case Costanti.ACQUISTA_PRODOTTO:
                                Prodotto prodottoAcquistato = store.acquistaProdotto();
                                System.out.println(prodottoAcquistato.toString());
                                user.aggiornaUtente(prodottoAcquistato);
                                break;
                            case Costanti.STAMPA_CARRELLO:
                                user.getCarrello().stampaCarrello();
                                break;
                            case Costanti.STAMPA_STORICO:
                                user.stampaStorico();
                                break;
                            case Costanti.CHECK_OUT:
                                System.out.println(user.getCarrello().calcolaTotale());
                                user.setCarrello(new Carrello());
                                break;
                            case Costanti.SIGN_OUT:
                                ArchivioDati.salvaDati(user.getCarrello(), String.format("%s/carrelli/%s.ser",Costanti.BASE_FILE_PATH, user.getId()));
                                ArchivioDati.salvaDati(user.getStoricoAcquisti(), String.format("%s/storicoacquisti/%s.ser",Costanti.BASE_FILE_PATH, user.getId()));
                                scelta = -2;
                                user = userInizializer.close(user, "utente");

                                System.out.println();
                                break;
                            default:
                                System.out.println("Scelta non valida!!");
                                scelta = 0;
                        }

                    }while(scelta != -2);

                    break;
                case Costanti.SIGN_UP:
                    user = creator.creaUtente();
                    break;
                case Costanti.CANCELLA_UTENTE:
                    creator.cancellaUtente();
                    break;
                case Costanti.ESCI:
                    scelta = -1;
                    break;
                default:
                    System.out.println("Scelta non valida\n");
                    scelta = 0;
            }
        } while(scelta != -1);
        dbInizializer.close(user, "Chiudo risorse db");
    }
}