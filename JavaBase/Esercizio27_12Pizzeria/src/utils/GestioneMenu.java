package utils;

import classi.Pizza;
import classi.Pizzeria;
import classi.Prezzi;
import eccezioni.NessunTavoloOccupatoException;
import eccezioni.TavoloGiaOrdinatoException;
import eccezioni.TavoloNonHaOrdinatoException;
import eccezioni.TuttiTavoliOccupatiException;
import enumerazioni.Farciture;
import enumerazioni.Formaggi;
import enumerazioni.Pizze;
import enumerazioni.Pomodoro;

import java.util.ArrayList;
import java.util.Scanner;

public class GestioneMenu {

    Pizzeria gestorePizzeria = new Pizzeria();
    int scelta = -1;
    Scanner scanner = new Scanner(System.in);
    Prezzi listino = new Prezzi();
    GestoreCassa gc = new GestoreCassa(gestorePizzeria.getTavoli(), listino);



    public void menu() {
        while(scelta != Costanti.ESCI) {

            stampaMenu();

            scelta = scanner.nextInt();
            switch (scelta) {
                case Costanti.PRENOTA -> {
                    try {
                        checkTavoliLiberi();
                        stampaListaTavoli();
                        prenotaTavoloLibero();
                    }
                    catch (TuttiTavoliOccupatiException e) {
                        System.out.println(e.getMessage() + "\n");
                    }
                    catch (Exception e) {
                        System.out.println("Il tavolo inserito non esiste\n");
                    }
                }


                case Costanti.ORDINA_PIZZE -> {
                    try{
                        checkTavoliOccupati();
                        stampaListaTavoli();
                        scegliTavolo(Costanti.ORDINA);
                        ordinaPizze();
                    }
                    catch (NessunTavoloOccupatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (TavoloGiaOrdinatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (Exception e) {
                        System.out.println("Il tavolo inserito non esiste\n");
                    }
                }

                case Costanti.PAGA -> {
                    try {
                        checkTavoliOccupati();
                        stampaListaTavoli();
                        scegliTavolo(Costanti.PAGAMENTO);
                        pagaConto();
                    } catch (NessunTavoloOccupatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (TavoloNonHaOrdinatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (Exception e) {
                        System.out.println("Il tavolo inserito non esiste\n");
                    }
                }

                case Costanti.STAMPA_LISTINO -> {stampaListino();}

                case Costanti.STAMPA_ORDINE_TAVOLO -> {
                    try {
                        checkTavoliOccupati();
                        scegliTavolo(Costanti.VISUALIZZA_ORINE);
                        stampaOrdineTavolo();
                    }
                    catch (NessunTavoloOccupatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (TavoloNonHaOrdinatoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (Exception e) {
                        System.out.println("Il tavolo inserito non esiste\n");
                    }

                }

                case Costanti.ESCI -> {System.out.println("Arrivederci e grazie");}

                default -> {System.out.println("Scelta non valida, ripeti!");}
            }

        }
    }

    private void stampaMenu() {
        scelta = -1;
        System.out.println("Fai la tua scelta: ");
        System.out.println("1) Prenota un tavolo");
        System.out.println("2) Ordina le pizze ad un tavolo");
        System.out.println("3) Paga il conto e lascia il tavolo");
        System.out.println("4) Stampa listino prezzi");
        System.out.println("5) Stampa ordine tavolo");
        System.out.println("100) Esci");
    }
    private void stampaOrdineTavolo() throws TavoloNonHaOrdinatoException{
        checkOrdine();
        for(int i = 0; i < gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).getListaPizzeOrdinate().size(); i++) {
            System.out.println(gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).getListaPizzeOrdinate().get(i).toString());
        }
    }
    private void checkOrdine() throws TavoloNonHaOrdinatoException{
        if(!gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).haOrdinato()) {
            throw new TavoloNonHaOrdinatoException("Il tavolo è occupato ma non ha ancora ordinato");
        }
    }
    private void pagaConto()  throws TavoloNonHaOrdinatoException{
            checkOrdine();
            int totaleTavolo = 0;
            totaleTavolo = gc.calcolaTotaleTavolo(scelta-1);
            System.out.printf("Il conto per il tavolo è di %d \n", totaleTavolo);
            gc.getListaTavoli().getListaTavoli().get(scelta-1).resetTavolo();

    }

    private void stampaListino() {
        System.out.println();
        System.out.println("------------------");
        for(Farciture farcitura: Farciture.values()) {
            System.out.println(farcitura + ": " + listino.getPrezziFarciture().get(farcitura));
        }
        System.out.println("------------------");
        for(Formaggi formaggio: Formaggi.values()) {
            System.out.println(formaggio + ": " + listino.getPrezziFormaggi().get(formaggio));
        }
        System.out.println("------------------");
        for (Pizze pizza: Pizze.values()) {
            System.out.println(pizza +": " + listino.getPrezziPizze().get(pizza));
        }
        System.out.println("------------------");
        for(Pomodoro pomoodoro: Pomodoro.values()) {
            System.out.println(pomoodoro + ": " + listino.getPrezziPomodoro().get(pomoodoro));
        }
        System.out.println("------------------");
        System.out.println();
    }


    public void checkTavoliLiberi() throws TuttiTavoliOccupatiException {
        boolean isTavoloLibero = false;

        for (int i = 0; i < Costanti.NUMERO_TAVOLI; i++) {
            if(!gestorePizzeria.getTavoli().getListaTavoli().get(i).isOccupato()) {
                isTavoloLibero = true;
            }
        }
        if(!isTavoloLibero) {
            throw new TuttiTavoliOccupatiException("Nessun tavolo libero, si prega di aspettare che si liberi un tavolo!!");
        }
    }

    public void checkTavoliOccupati() throws NessunTavoloOccupatoException {
        boolean tavoloOccupato = false;
        for (int i = 0; i < Costanti.NUMERO_TAVOLI; i++) {
            if(gestorePizzeria.getTavoli().getListaTavoli().get(i).isOccupato()) {
                tavoloOccupato = true;
            }
        }
        if(!tavoloOccupato) {
            throw new NessunTavoloOccupatoException("Nessun tavolo è occupato, chi ordina scusa???");
        }
    }

    public void stampaListaTavoli() {
        System.out.println("Ecco la lista dei tavoli: \n");
        for (int i = 0; i < Costanti.NUMERO_TAVOLI; i++) {
            System.out.println(gestorePizzeria.getTavoli().getListaTavoli().get(i).toString(i+1));
        }
        System.out.println();
    }

    public void prenotaTavoloLibero() {
        do{
            System.out.printf("Quale tavolo vuoi prenotare? (1-%d)", Costanti.NUMERO_TAVOLI);
            scelta = scanner.nextInt();
            if(gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).isOccupato()) {
                System.out.println("Tavolo occupato, si prega di scegliere un altro tavolo!! \n");
            }
        } while(gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).isOccupato());
        gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).setOccupato(true);
    }

    public void scegliTavolo(String tipoScelta) {
        do{
            System.out.printf("Su quale tavolo vuoi %s?\n", tipoScelta);
            scelta = scanner.nextInt();
            if(!gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).isOccupato()) {
                System.out.println("Il tavolo non è occupato. Scegli un altro tavolo. \n");
            }
        } while(!gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).isOccupato());
    }

    private void  ordinaPizze() throws TavoloGiaOrdinatoException {
        if(gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).haOrdinato()) {
            throw  new TavoloGiaOrdinatoException("Il tavolo ha già ordinato!");
        }
        else {
            System.out.printf("Ordine al tavolo %d \n", scelta);
            ArrayList<Pizza> listaPizzeAlTavolo =  new ArrayList<>();
            RandomPizza creaPizza = new RandomPizza();
            for (int i = 0; i < gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).getNrPosti(); i++) {
                listaPizzeAlTavolo.add(creaPizza.createRandomPizza());
                gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).setListaPizzeOrdinate(listaPizzeAlTavolo);
            }
            System.out.println("Ecco le pizze ordinate");
            for (int i = 0; i < listaPizzeAlTavolo.size(); i++) {
                System.out.println(listaPizzeAlTavolo.get(i).toString());
            }
        }
        gestorePizzeria.getTavoli().getListaTavoli().get(scelta-1).setHaOrdinato(true);
    }
}
