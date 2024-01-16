package Classi;

import utils.Ordinamento;
import utils.Ricerca;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> elencoLibri;

    private Ricerca ricerca = new Ricerca();
    private Ordinamento ordinamento = new Ordinamento();

    public Biblioteca() {}

    public void stampaElencoLibri() {
        System.out.println("Libri presenti nella biblioteca");
        for(Libro libro: elencoLibri) {
            System.out.println(libro.toString());
        }
    }

    public Libro cercaLibroPerTitolo(String titolo) {
        Libro[] libriArray = fromArrayListToArray();
        int indice = ricerca.ricercaPerTitolo(libriArray, titolo);
        if(indice != -1) return libriArray[indice];
        return null;
    }

    public Libro[] ordinaLibriPerAnnoPubblicazione() {
        Libro[] libriArray = fromArrayListToArray();
        Libro[] listaOrdinata = new Libro[libriArray.length];
        listaOrdinata = ordinamento.ordina(libriArray);
        return listaOrdinata;
    }

    public void trovaPerPattern(String pattern) {
        String titolo;
        for(Libro libro : elencoLibri) {
            //titolo = ricerca.trovaSottostringaTitolo(libro.getTitolo(), pattern);
            titolo = ricerca.trovaTitoloPatterPerChar(libro.getTitolo(), pattern);
            if(titolo != null) {
                System.out.println(cercaLibroPerTitolo(titolo).toString());
            }
        }
    }




    private Libro[] fromArrayListToArray() {
        Libro[] arrayLibri = elencoLibri.toArray(new Libro[0]);
        return arrayLibri;
    }



    public ArrayList<Libro> getElencoLibri() {
        return elencoLibri;
    }

    public void setElencoLibri(ArrayList<Libro> elencoLibri) {
        this.elencoLibri = elencoLibri;
    }
}
