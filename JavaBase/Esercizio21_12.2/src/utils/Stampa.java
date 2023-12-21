package utils;

import Classi.Venditore;
import enumerazioni.TipoStampa;

public class Stampa {

    public void stampaVenditore(Venditore venditore, TipoStampa tipoStampa) {
        switch (tipoStampa) {
            case TipoStampa.ASSOLUTO:
                System.out.println("Il miglior venditore in assoluto è : " + venditore.toString());
                break;
            case TipoStampa.ZONA:
                System.out.println("Il miglior venditore della zona : " + venditore.getZona_lavoro().name() + " è : " + venditore);
                break;
        }
    }
}
