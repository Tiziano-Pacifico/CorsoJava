package classi.logics;

import classi.prodotti.Libro;
import classi.prodotti.Prodotto;
import classi.prodotti.ProdottoElettronico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Carrello implements Serializable {

    private ArrayList<Prodotto> listaProdotti;



    public Carrello() {
        listaProdotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdotti.add(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        if (!listaProdotti.contains(prodotto)) {
            System.out.println("Il prodotto non è presente");
        }
        else {
            listaProdotti.remove(prodotto);
        }
    }

    public float calcolaTotale() {
        float totale = 0;

        for(Prodotto prodotto: listaProdotti) {
            totale += prodotto.getPrezzo();
        }
        System.out.println("totale senza sconto: " + totale);
        return totale - calcolaSconto();
    }

    private float calcolaSconto() {
        ArrayList<Libro> libriDaScontare = new ArrayList<>();
        ArrayList<Libro> listaLibri = new ArrayList<>();
        ArrayList<ProdottoElettronico> listaProdottiElettronici = new ArrayList<>();
        int contatoreLibri = 0;
        float totaleSconto = 0;

        for (int i = 0; i < listaProdotti.size(); i++) {
            //Ogni tre libri comprati applico lo sconto sul libro che costa di meno utilizzando sort e comparable
            if(listaProdotti.get(i) instanceof Libro) {
                contatoreLibri +=1;
                listaLibri.add((Libro) listaProdotti.get(i));
                if(contatoreLibri == 3) {
                    Collections.sort(listaLibri);
                    libriDaScontare.add(listaLibri.get(0));
                    listaLibri.clear();
                    contatoreLibri = 0;
                }
            }
            else {
                listaProdottiElettronici.add((ProdottoElettronico) listaProdotti.get(i));
            }


        }
        for (int i = 0; i < libriDaScontare.size(); i++) {
            System.out.println(libriDaScontare.get(i).toString());
            float scontoLibri = applicaOfferta(libriDaScontare.get(i), ListaOfferte.offertaLibri);
            System.out.println("Sconto sul libro: " + scontoLibri);
            totaleSconto += scontoLibri;
        }
        for (int i = 0; i < listaProdottiElettronici.size(); i++) {
            System.out.println(listaProdottiElettronici.get(i).toString());
            float scontoProdotto = applicaOfferta(listaProdottiElettronici.get(i), ListaOfferte.offertaElettronica);
            System.out.println("Sconto sul libro: " + scontoProdotto);
            totaleSconto += scontoProdotto;
        }
        System.out.println("Totale sconto applicato: " + totaleSconto);
        return totaleSconto;
    }

    private <T extends Prodotto> float  applicaOfferta(T prodotto, OffertaSpeciale<T> offerta) {
        return offerta.applicaOfferta(prodotto);
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }


    public void stampaCarrello() {
        for (int i = 0; i < listaProdotti.size(); i++) {
            System.out.println(listaProdotti.get(i).toString());

        }
    }
}
