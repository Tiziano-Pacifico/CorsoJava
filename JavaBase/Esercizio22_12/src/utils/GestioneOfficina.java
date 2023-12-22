package utils;

import Classi.Automobile;
import enumerazioni.Colore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * La classe si occupa di gestire la lista delle auto presenti in officina e le relative modifiche.
 * Metodi implementati:
 * - public void removeAutoTarga(String targa)
 * - public int contaAuto()
 * - public void verniciaAuto(String targa, Colore color)
 * - public float returnIncasso()
 * - public void stampaAuto()
 * Costruttori:
 *  - default
 */
public class GestioneOfficina {

    private LinkedList<Automobile> listaAuto = new LinkedList<>();
    private float incasso = 0.0f;
    private Random random = new Random();
    private float minPrice = 100.0f;
    private float maxPrice = 500.0f;

    /**
     * Aggiunge un'auto alla lista delle auto
     * @param auto
     */
    public void addAuto(Automobile auto) {
        listaAuto.add(auto);
    }

    /**
     * Rimuove un'auto dalla lista delle auto basandosi sulla targa
     * @param targa
     */
    public void removeAutoTarga(String targa) {
        incasso = minPrice + random.nextFloat() *(maxPrice - minPrice);
        Iterator<Automobile> iterator = listaAuto.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getTarga().equalsIgnoreCase(targa)) {
                iterator.remove();
            }
        }
    }

    /**
     * restituisce il numero di auto presenti in officina
     * @return int
     *  Il numero di auto presenti in officina
     */
    public int contaAuto() {
        return listaAuto.size();
    }

    /**
     * Cambia il colore di un'auto presente in officina indentificandola con il numero di targa
     * @param targa
     *  La targa dell'auto da riverniciare
     * @param color
     *  Il nuovo colore della macchina, nella lista dei colori presenti nell'enumerazione Colore
     */
    public void verniciaAuto(String targa, Colore color) {
        int indice = 0;
        Automobile auto;
        Iterator<Automobile> iterator = listaAuto.iterator();
        while(iterator.hasNext()) {
            auto = iterator.next();
            if(auto.getTarga().equalsIgnoreCase(targa)) {
                auto.setColore(color);

                listaAuto.set(indice, auto);
                break;
            }
            indice++;
        }
    }

    public float returnIncasso() {
        return incasso;
    }

    public void stampaAuto() {
        for (Automobile auto: listaAuto) {
            System.out.println(auto.toString());
        }
    }

}
