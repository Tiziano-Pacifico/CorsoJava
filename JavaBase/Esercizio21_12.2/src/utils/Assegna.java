package utils;

import Classi.Vendite;
import Classi.Venditore;

import java.util.ArrayList;

public class Assegna {

    public ArrayList<Venditore> assegnaVendite(ArrayList<Venditore> listaVenditori, ArrayList<Vendite> listaVendite) {

        for(Venditore venditore: listaVenditori) {
            for(Vendite vendita: listaVendite) {
                if (vendita.getCodiceVenditore().equalsIgnoreCase(venditore.getCodice())) {
                    venditore.setVenduto(vendita.getImporto());
                }
            }
        }

        return listaVenditori;
    }

}
