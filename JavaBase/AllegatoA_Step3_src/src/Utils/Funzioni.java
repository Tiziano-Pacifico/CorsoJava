package Utils;

import classi.Email;

import java.util.ArrayList;
import java.util.Scanner;

public class Funzioni {

    Scanner scanner = new Scanner(System.in);

    /**
     * Metodo che permette di inserire una mail.
     * @return Email
     */
    public Email inserisciMail() {

        String titolo = "";
        String testo = "";
        String mittente = "";
        String destinatario = "";

        System.out.println("Inserisci il titolo della mail: ");
        titolo = scanner.next();
        System.out.println("Inserisci il mittente: ");
        mittente = scanner.next();
        System.out.println("Inserisci il destinatario");
        destinatario = scanner.next();
        System.out.println("Inserisci il testo della mail: ");
        testo = scanner.next();

        Email mail = new Email(testo, mittente, destinatario, titolo);

        return mail;

    }

    /**
     * Metodo che cerca una parola nella lista di mail.
     * @param mails prende in input solo la lista delle mails.
     * La parola da cercare viene definita all'interno del metodo
     * Usa il metodo contieneParolaChiave
     */
    public  void cercaTesto(ArrayList<Email> mails) {
        String parolaChiave = "";
        System.out.println("Qual'è la parola da cercare?");
        parolaChiave = scanner.next();
        Boolean trovata = false;
        int index = 0;

        for (int i = 0; i < mails.size(); i++) {
            if (contieneParolaChiave(mails.get(i), parolaChiave)) {
                trovata = true;
                index = i;
                break;
            }
        }

        if (trovata) {
            System.out.println("Parola trovata nella mail :" + mails.get(index).toTotalString());
        }
        else {
            System.out.println("La parola non è stata trovata");
        }
    }

    /**
     * Metodo privato chiamato dal metodo cercaTesto
     * @param oggettoDoc L'oggetto mail in cui cercare il testo
     * @param parolaChiave La parola da cercare nel testo
     * @return True, se ha trovato la parola, False altrimenti
     */
    private Boolean contieneParolaChiave(Email oggettoDoc, String parolaChiave) {
        if (oggettoDoc.toTotalString().indexOf(parolaChiave, 0) >= 0)
            return true;
        return false;
    }

    /**
     * Stampa a video la lista delle mail inserite con tutti i relativi campi
     * @param mails
     */
    public void stampaMails(ArrayList<Email> mails) {

        for (Email mail : mails) {
            System.out.println(mail.toTotalString());
        }
    }

    /**
     * Stampa il menù introduttivo del main
     */
    public void stampaMenu() {
        System.out.println("Cosa vuoi fare?");
        System.out.println("1) Inserire una mail");
        System.out.println("2) Cercare il testo in una mail");
        System.out.println("3) Stampare la lista delle mail");
        System.out.println("100) uscire\n");
    }
}
