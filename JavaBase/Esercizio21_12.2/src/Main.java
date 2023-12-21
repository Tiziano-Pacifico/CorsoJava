import Classi.Vendite;
import Classi.Venditore;
import enumerazioni.TipoStampa;
import enumerazioni.ZoneLavoro;
import utils.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Init init = new Init();
        Compare comparatore = new Compare();
        ZoneLavoro[] zone = ZoneLavoro.values();
        Stampa stampa = new Stampa();
        Assegna assegna = new Assegna();

        ArrayList<Venditore> venditori;
        Venditore bestSeller;
        Venditore[] bestSellerPerZone = new Venditore[zone.length];


        venditori = assegna.assegnaVendite(init.getListaVenditori(),init.getVendite());

        if (Costanti.DEBUG) {
            for(Venditore venditore: venditori) {
                System.out.println(venditore.toString());
            }
        }

        bestSeller = comparatore.bestSeller(venditori);

        int i = 0;
        for(ZoneLavoro zona: zone) {
            bestSellerPerZone[i++] = comparatore.besteSellerPerZone(venditori, zona);
        }

        stampa.stampaVenditore(bestSeller, TipoStampa.ASSOLUTO);

        i = 0;
        for(ZoneLavoro zona: zone) {
            stampa.stampaVenditore(bestSellerPerZone[i++], TipoStampa.ZONA);

        }
    }
}