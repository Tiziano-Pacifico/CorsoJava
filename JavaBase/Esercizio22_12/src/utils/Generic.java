package utils;

import Classi.Costanti;
import enumerazioni.Colore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import Classi.Automobile;

/**
 * Classe che si occupa della gestione del menù iniziale e delle chiamate ai metodi in base alle scelte fatte nel menù
 * Metodi implementati:
 * - public Colore traduciColoreEnum(String colore)
 * - public void stampaMenu()
 * - public void gestisciScelta(int scelta)
 * - private String[] coloriEnumToString(Colore[] listaColori)
 * - private void creaAuto()
 * - private void autoNonTrovata()
 * - private void rimuoviAutoOperazioni()
 * - private void rimuoviAutoWrapper()
 * - private void contaAuto()
 * - private void checkAuto()
 * - private void coloreNonTrovato()
 * - private void checkColore()
 * - private void vernicia()
 * Costruttori:
 * - Default
 */
public class Generic {

    CreaAuto creaAuto = new CreaAuto();
    GestioneOfficina gestore = new GestioneOfficina();
    Scanner scanner = new Scanner(System.in);
    Automobile auto;
    String targa = "";
    String colore = "";
    boolean autoTrovata = false;
    boolean coloreTrovato = false;

    Colore[] coloriEnum = Colore.values();
    String[] coloriString = coloriEnumToString(coloriEnum);
    ArrayList<String> listaColoriDisponibili = new ArrayList<>(Arrays.asList(coloriString));

    /**
     * Prende una stringa di clore e restituisce la relativa enumerazione
     * @param colore
     *  Il colore che si vuole convertire
     * @return Colore
     *  Il relativo colore nella classe enum Colore
     * @ToDo: gestione del colore non presente nella lista enum Colori
     * Chiamato dai metodi:
     * - private void vernicia()
     */
    public Colore traduciColoreEnum(String colore){

        Colore c = Colore.GRIGIO;

        switch(colore) {
            case Costanti.GIALLO:
                c = Colore.GIALLO;
                break;
            case Costanti.GRIGIO:
                c = Colore.GRIGIO;
                break;
            case Costanti.ROSSO:
                c = Colore.ROSSO;
                break;
            case Costanti.NERO:
                c = Colore.NERO;
                break;
            case Costanti.VERDE:
                c = Colore.VERDE;
                break;

        }

        return c;
    }

    /**
     * Stampa il menù con tutte le opzioni possibili
     */
    public void stampaMenu() {
        System.out.println("1) Inserici un'auto");
        System.out.println("2) Ritira un'auto");
        System.out.println("3) Conta le auto in riparazione");
        System.out.println("4) Vernica un'auto");
        System.out.println("5) Stampa l'incasso totale");
        System.out.println("6) Stampa lista auto in officina");
        System.out.println("100) Esci \n\n");
    }


    /**
     * Chiama i metodi relativi alle scelte del menù principale
     * @param scelta
     *  La scelta della funzione da eseguire
     */
    public void gestisciScelta(int scelta) {

        switch (scelta) {
            case Costanti.INSERISCI:
                creaAuto();
                break;

            case Costanti.RIMUOVI:
                rimuoviAutoWrapper();
                break;

            case Costanti.CONTA:
                contaAuto();
                break;

            case Costanti.VERNICIA:
                vernicia();
                break;

            case Costanti.INCASSO:
                System.out.println("L'incasso complessivo è : " + gestore.returnIncasso());
                break;

            case Costanti.LISTA_AUTO:
                gestore.stampaAuto();
                break;

            case Costanti.ESCI:
                System.out.println("Arrivederci e grazie");
                break;

            default:
                System.out.println("Scelta non valida");
        }
    }

    /**
     * Traduce una lista di colori di tipo enum Colore in una lista omologa ma di tipo String
     * @param listaColori
     *  un array di colori di tipo enum Colore
     * @return String[]
     *  Un array di stringhe contente i colori della classe enum Colore
     *
     */
    private String[] coloriEnumToString(Colore[] listaColori) {
        String[] coloriString = new String[listaColori.length];
        for(int i = 0; i< listaColori.length; i++) {
            coloriString[i] = listaColori[i].name();
        }
        return coloriString;
    }

    /**
     * Un metodo wrapper che si occupa della gestione dell'inserimento di un'auto.
     * Nello specifico crea un'auto, la stampa e aggiunge l'auto alla lista delle auto
     */
    private void creaAuto() {

        auto = creaAuto.creaAuto();
        System.out.println(auto.toString() + "\n");
        gestore.addAuto(auto);
    }

    /**
     * Metodo che si occupa della gestione del messaggio di errore nel caso la targa inserira non sia presente nella lista delle targhe
     * Chiamato dai metodi:
     * - private void rimuoviAutoWrapper()
     * - private void checkAuto()
     */
    private void autoNonTrovata() {
        System.out.println("L'auto non è presente nell'officina");
        System.out.println("Ecco le targhe delle auto presenti in officina");
        Iterator<String> iterator = creaAuto.getTarghe().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    /**
     * Chiama i metodi che si occupano tecnicamente della rimozione di un'auto
     *
     * Chiamato dai metodi:
     * - private void rimuoviAutoWrapper()
     */
    private void rimuoviAutoOperazioni() {
        gestore.removeAutoTarga(targa);
        creaAuto.rimuoviTarga(targa);
        autoTrovata = true;
    }

    /**
     * Wrapper di tutto ciò che riguarda la rimozione di un'auto
     * Gestisce la scelta, eventuali errori la stamap dei messaggi
     * Chiama i metodi:
     * - private void autoNonTrovata()
     * - private void rimuoviAutoOperazioni()
     */
    private void rimuoviAutoWrapper() {
        while(!autoTrovata) {
            System.out.println("Inserisci la targa dell'auto: ");
            targa = scanner.next();
            if(!creaAuto.getTarghe().contains(targa)) {
                autoNonTrovata();
            }
            else{
                rimuoviAutoOperazioni();
            }
        }
        autoTrovata = false;
    }

    /**
     * Stampa il numero di auto presenti in officina
     */
    private void contaAuto() {
        System.out.println("L'officina contiene : " +  gestore.contaAuto() + " auto");
    }

    /**
     * Chiede di inserire la targa di un'auto fino a quando non si inserisce un dato valido
     *
     * Chiama i metodi:
     * - private void autoNonTrovata()
     */
    private void checkAuto() {
        while(!autoTrovata){
            System.out.println("Inserisci la targa dell'auto: ");
            targa = scanner.next();
            if(!creaAuto.getTarghe().contains(targa)) {
                autoNonTrovata();
            }
            else{
                autoTrovata = true;
            }
        }
        autoTrovata = false;
    }
    /**
     * Metodo che si occupa della gestione del messaggio di errore nel caso il colore inserito non sia presente nella lista dei colori disponibili
     * Chiamato dai metodi:
     * - private void checkColore()
     */
    private void coloreNonTrovato() {
        System.out.println("Il colore non è presente nella lista!");
        System.out.println("Ecco i colori disponibili: ");
        for(int i = 0; i < coloriString.length; i++){
            System.out.print(coloriString[i] + "; ");
        }
        System.out.println();
    }

    /**
     * Chiede di inserire il colore  fino a quando non si inserisce un dato valido
     *
     * Chiama i metodi:
     * - private void coloreNonTrovato()
     */
    private void checkColore() {
        while(!coloreTrovato){
            System.out.println("Inserisci un colore tra i seguenti (case sensitive): ");
            for(int i = 0; i < coloriString.length; i++){
                System.out.print(coloriString[i] + "; ");
            }
            System.out.println();
            colore = scanner.next();
            if(!listaColoriDisponibili.contains(colore)) {
                coloreNonTrovato();
            }
            else {
                coloreTrovato = true;
            }
        }
        coloreTrovato = false;
    }

    /**
     * Wrapper di tutto ciò che riguarda la verniciatura di un'auto
     * Gestisce il controllo degli errori di inserimento, la stampa di tutti i messaggi e la modifica del valore del colore dell'auto
     * Chiama i metodi:
     * - private void checkAuto()
     * - private void checkColore()
     */
    private void vernicia() {
        checkAuto();
        checkColore();
        gestore.verniciaAuto(targa, traduciColoreEnum(colore));
    }

}


