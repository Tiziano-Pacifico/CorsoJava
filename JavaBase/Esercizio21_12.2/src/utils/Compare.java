package utils;

import Classi.Venditore;
import enumerazioni.ZoneLavoro;

import java.util.ArrayList;
import java.util.Optional;

public class Compare {

    public Venditore bestSeller(ArrayList<Venditore> listaVenditori) {

        Venditore bestSeller = null;
        float massimaVendita = (float) 0.0;

        for(Venditore venditore : listaVenditori) {
            if (venditore.getVenduto() > massimaVendita) {
                massimaVendita = venditore.getVenduto();
                bestSeller = venditore;
            }
        }
        return bestSeller;
    }

    public Venditore besteSellerPerZone(ArrayList<Venditore> listaVenditori, ZoneLavoro zonaLavoro) {

        return bestSeller(selectSellerPerZone(listaVenditori, zonaLavoro, Costanti.DEBUG));

    }

    private ArrayList<Venditore> selectSellerPerZone(ArrayList<Venditore> listaVenditori, ZoneLavoro zonaLavoro, boolean debug) {



        ArrayList<Venditore> listaVenditoriFiltrata = new ArrayList<>();

        for(Venditore venditore: listaVenditori) {
                if(debug) {
                    System.out.println("Debug: " + venditore.getZona_lavoro() + " " + zonaLavoro + " " + (venditore.getZona_lavoro() == zonaLavoro));
                }
            if(venditore.getZona_lavoro() == zonaLavoro) {
                listaVenditoriFiltrata.add(venditore);
            }
        }

        return listaVenditoriFiltrata;
    }

}
