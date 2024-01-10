import classi.Autori;
import classi.Book;
import classi.Cliente;
import classi.Loan;
import utils.Costanti;
import utils.db.DbInterface;
import utils.db.LibrayDatabase;

import java.util.Scanner;

//Gestione di una biblioteca con DB implementato tramite Singleton
public class Main {
    public static LibrayDatabase ld = LibrayDatabase.getInstance();

    public static void main(String[] args) {

        DbInterface db = new DbInterface();

        int scelta = 0;
        int id, id1;
        String titoloLibro, annoPubblicazione;
        String nome, cognome;

        Scanner scanner = new Scanner(System.in);

        db.connetti();

        do{
            System.out.println("Cosa vuoi fare: ");
            System.out.println("1) Inserisci");
            System.out.println("2) Cancella");
            System.out.println("3) Stampa");
            System.out.println("4) Gestisci prestito");
            System.out.println("100) Esci");
            scelta = scanner.nextInt();
            switch (scelta) {
                case Costanti.INSERISCI:
                    do{
                        System.out.println("Cosa vuoi inserire?");
                        System.out.println("1) Libro");
                        System.out.println("2) Autore");
                        System.out.println("3) Cliente");
                        System.out.println("100) Torna al menù precedente");
                        scelta = scanner.nextInt();
                        switch(scelta) {
                            case Costanti.LIBRO:
                                System.out.println("Inserisci i dati del libro");
                                System.out.println("Titolo: ");
                                titoloLibro = scanner.next();
                                System.out.println("Anno pubblicazione");
                                annoPubblicazione = scanner.next();
                                System.out.println("Ecco una lista degli autori in archivio");
                                db.stampa(Costanti.AUTORE);
                                System.out.println("Inserisci l'autore");
                                System.out.println("Nome autore");
                                nome = scanner.next();
                                System.out.println("Cognome autore");
                                cognome = scanner.next();
                                id = db.aggiungi(new Autori(nome, cognome));
                                db.aggiungi(new Book(titoloLibro, id, annoPubblicazione));
                                break;
                            case Costanti.AUTORE:
                                System.out.println("Inserisci i dati dell'autore");
                                System.out.println("Nome autore");
                                nome = scanner.next();
                                System.out.println("Cognome autore");
                                cognome = scanner.next();
                                db.aggiungi(new Autori(nome, cognome));
                                break;
                            case Costanti.CLIENTE:
                                System.out.println("Inserisci i dati del cliente");
                                System.out.println("Nome");
                                nome = scanner.next();
                                System.out.println("Cognome");
                                cognome = scanner.next();
                                db.aggiungi(new Cliente(nome, cognome));
                                break;
                            case Costanti.ESCI:
                                scelta = -1;
                                break;
                            default:
                                System.out.println("Scelta non valida!");
                        }
                    }while(scelta != -1);
                    scelta = 0;
                    break;
                case Costanti.CANCELLA:
                    do{
                        System.out.println("Cosa vuoi cancellare?");
                        System.out.println("1) Libro");
                        System.out.println("2) Autore");
                        System.out.println("3) Cliente");
                        System.out.println("100) Torna al menù precedente");
                        scelta = scanner.nextInt();
                        switch(scelta) {
                            case Costanti.LIBRO:
                                System.out.println("Ecco la lista dei libri");
                                db.stampa(Costanti.LIBRO);
                                System.out.println("Quale libro vuoi cancellare(inserisci l'Id)");
                                id = scanner.nextInt();
                                db.cancellaPerId(id, Costanti.LIBRO);
                                break;
                            case Costanti.AUTORE:
                                System.out.println("Ecco la lista degli autori");
                                db.stampa(Costanti.AUTORE);
                                System.out.println("Quale autore vuoi cancellare(inserisci l'Id)");
                                id = scanner.nextInt();
                                db.cancellaPerId(id, Costanti.AUTORE);
                                break;
                            case Costanti.CLIENTE:
                                System.out.println("Ecco la lista dei clienti");
                                db.stampa(Costanti.CLIENTE);
                                System.out.println("Quale cliente vuoi cancellare(inserisci l'Id)");
                                id = scanner.nextInt();
                                db.cancellaPerId(id, Costanti.CLIENTE);
                                break;
                            case Costanti.ESCI:
                                scelta = -1;
                                break;
                            default:
                                System.out.println("Scelta non valida!");
                        }
                    }while(scelta != -1);
                    scelta = 0;
                    break;
                case Costanti.STAMPA:
                    do{
                        System.out.println("Cosa vuoi stampare?");
                        System.out.println("1) Libro");
                        System.out.println("2) Autore");
                        System.out.println("3) Cliente");
                        System.out.println("100) Torna al menù precedente");
                        scelta = scanner.nextInt();
                        switch(scelta) {
                            case Costanti.LIBRO:
                                System.out.println("Ecco la lista dei libri:");
                                db.stampa(Costanti.LIBRO);
                                System.out.println();
                                break;
                            case Costanti.AUTORE:
                                System.out.println("Ecco la lista degli autori:");
                                db.stampa(Costanti.AUTORE);
                                System.out.println();
                                break;
                            case Costanti.CLIENTE:
                                System.out.println("Ecco la lista dei clienti");
                                db.stampa(Costanti.CLIENTE);
                                System.out.println();
                                break;
                            case Costanti.ESCI:
                                scelta = -1;
                                break;
                            default:
                                System.out.println("Scelta non valida!");
                        }
                    }while(scelta != -1);
                    scelta = 0;
                    break;
                case Costanti.PRESTITO:
                    do{
                        System.out.println("Cosa vuoi fare: ");
                        System.out.println("1) Prendi in prestito un libro");
                        System.out.println("2) Restituisci un libro");
                        System.out.println("100) Torna al menù precedente");
                        scelta = scanner.nextInt();
                        switch(scelta) {
                            case Costanti.PRENDI_IN_PRESTITO:
                                System.out.println("Ecco la lista dei libri");
                                db.stampa(Costanti.LIBRO);
                                System.out.println("Inserisci l'id del libro");
                                id = scanner.nextInt();
                                System.out.println("Ecco la lista dei clienti");
                                db.stampa(Costanti.CLIENTE);
                                System.out.println("Inserisci l'id del cliente");
                                id1 = scanner.nextInt();
                                db.inserisciPrestito(new Loan(id1,id));
                                break;
                            case Costanti.RESTITUISCI:
                                System.out.println("Ecco la lista dei libri in prestito");
                                db.stampaListaPrestiti();
                                System.out.println("Inserisci l'id del libro che vuoi restituire");
                                id = scanner.nextInt();
                                db.annullaPrestito(id);
                                break;
                            case Costanti.ESCI:
                                scelta = -1;
                                break;
                            default:
                                System.out.println("Scelta non valida!");
                        }
                    }while(scelta != -1);
                    scelta = 0;
                    break;
                case Costanti.ESCI:
                    System.out.println("Arrivederci e grazie!");
                    scelta = -1;
                    System.out.println();
                    break;
                default:
                    System.out.println("Scelta errata");
            }

        }while(scelta != -1);


        db.disconnetti();

    }


}