import Utils.Funzioni;
import classi.Costanti;
import classi.Documento;
import  classi.Email;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String scelta = "";
        ArrayList<Email>  mails = new ArrayList<Email>();
        Scanner scanner = new Scanner(System.in);
        Funzioni fun = new Funzioni();

        while (!scelta.equalsIgnoreCase(Costanti.ESCI)){

            fun.stampaMenu();
            scelta = scanner.next();

            switch (scelta){
                case Costanti.INSERISCI_MAIL:
                    mails.add(fun.inserisciMail());
                    break;
                case Costanti.CERCA_TESTO:
                    fun.cercaTesto(mails);
                    break;
                case Costanti.STAMPA_LISTA_MAIL:
                    fun.stampaMails(mails);
                    break;
                case Costanti.ESCI:
                    System.out.println("Arrivederci e grazie!!");
                    break;
                default:
                    System.out.println("Scelta non valida\n");
            }

        }


    }



}