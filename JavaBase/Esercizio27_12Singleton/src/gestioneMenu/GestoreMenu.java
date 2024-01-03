package gestioneMenu;

import Classi.Costanti;
import Classi.Parcheggio;
import Classi.Varco;

import java.util.ArrayList;
import java.util.Scanner;

public class GestoreMenu {

    Scanner scanner = new Scanner(System.in);

    public void stampaMenu() {
        System.out.println("Cosa vuoi fare");
        System.out.println("1) Inserisci una macchina");
        System.out.println("2) Fai uscire una macchina");
        System.out.println("3) Conta macchine per parcheggio");
        System.out.println("4) Visualizza traffico per varco");
        System.out.println("100) Esci \n");
    }

    private void autoPerVarco(ArrayList<Varco> varchi) {
        for (int i = 0; i < varchi.size(); i++) {
            System.out.printf("Nel varco (%d) sono entrate (%d) auto e sono uscite (%d) auto\n", i, varchi.get(i).getEntrateNelVarco(), varchi.get(i).getAutoUscite());
        }
        System.out.println("\n");
    }




    public void gestisciMenu(int scelta, ArrayList<Varco> varchi) {
        switch (scelta) {

            case Costanti.ENTRA_AUTO -> {entraAuto(varchi);}

            case Costanti.ESCI_AUTO -> {esciAuto(varchi);}

            case Costanti.CONTA_AUTO -> {contaAuto();}
            case Costanti.AUTO_PER_VARCO -> {autoPerVarco(varchi);}

            case Costanti.ESCI_MENU -> {esciMenu();}
            default -> {defaultChoice();}

        }
    }

    private void entraAuto(ArrayList<Varco> varchi) {
        int sceltaVarco = -1;
        System.out.println("Da quale varco entra l'auto? (0-4)");
        sceltaVarco = scanner.nextInt();
        try {
            varchi.get(sceltaVarco).entra();
        }
        catch (Exception e) {
            System.out.println("Varco non presente\n");
        }
    }

    private void esciAuto(ArrayList<Varco> varchi) {
        int sceltaVarco;
        System.out.println("Da quale varco esce la macchina?");
        sceltaVarco = scanner.nextInt();
        try{
            varchi.get(sceltaVarco).esci();
        }
        catch (Exception e) {
            System.out.println("Varco non presente");
        }
    }

    private void contaAuto() {
        System.out.println("Nel parcheggio ci sono :" + Parcheggio.getNumeroAuto() + "\n");
    }

    public void esciMenu() {
        System.out.println("Arrivederci e grazie");
    }

    private void defaultChoice() {
        System.out.println("Scelta errata, riprova!!\n");
    }

}
