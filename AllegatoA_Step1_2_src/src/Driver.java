import it.tiziano.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Driver agent = new Driver();
        String scelta = "nessuna";

        ArrayList<Dottore> dottori = new ArrayList<Dottore>();
        ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
        ArrayList<Fattura> fatture = new ArrayList<Fattura>();
        ArrayList<Pagamento> pagamenti = new ArrayList<Pagamento>();

        Funzioni funzioni = new Funzioni();

        while (!scelta.equalsIgnoreCase("5"))  {
            scelta = "";
            agent.stampaMenu();

            scelta = scanner.next();

            switch (scelta) {
                case Costanti.INSERISCI_DOTTORE:
                    dottori.add(funzioni.inserisciDottore(dottori));
                    break;
                case Costanti.INSERISCI_PAZIENTE:
                    pazienti.add(funzioni.inserisciPaziente(pazienti));
                    break;
                case Costanti.INSERISCI_FATTURA:
                    DatiPAgamento dp = funzioni.inserisciPagamento(fatture, dottori, pazienti);
                    fatture.add(dp.getFattura());
                    pagamenti.add(dp.getPagamento());
                    break;
                case Costanti.CALCOLA_TOTALE_FATTURE:
                    System.out.println("Il totale delle fatture è :" + funzioni.calcolaTotaleFatture(fatture));
                    break;

                case Costanti.ESCI:
                    System.out.println("Arrivederici e grazie");
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }

    }
    public void stampaMenu() {
        System.out.println("Cosa vuoi fare?");
        System.out.println("1) Inserisci Dottore");
        System.out.println("2) Inserisci Paziente");
        System.out.println("3) Inserisci Fattura");
        System.out.println("4) Calcola totale fatture");
        System.out.println("5) Inserisci metodo di pagamento");
        System.out.println("6) Esci \n");
    }
}
