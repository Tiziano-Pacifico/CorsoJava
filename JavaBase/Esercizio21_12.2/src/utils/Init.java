package utils;

import Classi.Vendite;
import Classi.Venditore;
import enumerazioni.ZoneLavoro;

import java.util.ArrayList;
import java.util.Random;

public class Init {

    private ArrayList<Venditore> listaVenditori = new ArrayList<>();
    private ZoneLavoro zl;
    private ArrayList<Vendite> listaVendite = new ArrayList<>();

    Random random = new Random();
    String[] nomi = {"Mario", "Luigi", "Giovanni", "Laura", "Paola", "Andrea", "Roberta", "Marco", "Francesca", "Antonio"};
    String[] cognomi = {"Bianchi", "Verdi", "Russo", "Ferrari", "Romano", "Marini", "Rossi", "Conti", "Gallo", "Mancini"};
    String[] citta = {"Roma", "Milano", "Napoli", "Torino", "Firenze", "Bologna", "Genova", "Palermo", "Catania", "Venezia"};
    String[] dateAssunzione = {"15/01/2022", "10/03/2021", "05/07/2020", "20/11/2019", "03/09/2022", "28/02/2021", "12/06/2020", "19/04/2019", "22/08/2022", "07/12/2021"};
    ZoneLavoro[] zoneLavoro = {ZoneLavoro.A, ZoneLavoro.B, ZoneLavoro.C};
    String[] codici = {"Cod001", "Cod002", "Cod003", "Cod004", "Cod005", "Cod006", "Cod007", "Cod008", "Cod009", "Cod010", "Cod011", "Cod012", "Cod013", "Cod014", "Cod015", "Cod016", "Cod017", "Cod018", "Cod019", "Cod020"};
    float minVenduto = 100.0f;
    float maxVenduto = 500.0f;

    public Init() {

        for (int i = 0; i < 20; i++) {
            String nome = nomi[random.nextInt(nomi.length)];
            String cognome = cognomi[random.nextInt(cognomi.length)];
            String cittaResidenza = citta[random.nextInt(citta.length)];
            String dataAssunzione = dateAssunzione[random.nextInt(dateAssunzione.length)];
            ZoneLavoro zonaLavoroScelta = zoneLavoro[random.nextInt(zoneLavoro.length)];
            String codice = codici[i % codici.length];
            float venduto = 0.0f;
            Venditore venditore = new Venditore(nome, cognome, cittaResidenza, dataAssunzione, zonaLavoroScelta, codice, venduto);
            listaVenditori.add(venditore);

            listaVendite.add(new Vendite(codice, minVenduto + random.nextFloat() * (maxVenduto - minVenduto)));
        }
    }

    public ArrayList<Venditore> getListaVenditori() {
        return listaVenditori;
    }

    public ArrayList<Vendite> getVendite() {
        return listaVendite;
    }
}
