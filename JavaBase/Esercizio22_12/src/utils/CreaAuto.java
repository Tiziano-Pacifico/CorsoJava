package utils;

import Classi.Automobile;
import Classi.Motore;
import enumerazioni.Alimentazione;
import enumerazioni.Colore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe che gestisce la creazione di un'auto e della relativa targa.
 * La calsse è utile per testare velocemente il codice in quanto permette di generare automaticamente un oggeto auto
 * casuale con una targa unica all'interno della collection di auto.
 * Le targhe uniche saranno conservate in una struttira dati dedicata. La classe si occupa di aggiornare la lista
 * delle targhe per ogni eliminazione di auto.
 * Metodi implementati:
 *  - public Automobile creaAuto()
 *  - public void rimuoviTarga(String targa)
 *  - public String generaTargaUnica(List<String> targheEsistenti)
 *  - private String generaTargaCasuale()
 *  - public ArrayList<String> getTarghe()
 *  Costruttori:
 *  - public Automobile creaAuto()
 */
public class CreaAuto {


    //Utilizziamo degli array la cui combinazione fornisce un modello di auto
    private String[] marche = {"Fiat", "Toyota", "Ford", "BMW", "Audi", "Tesla", "Renault", "Peugeot", "Volkswagen", "Honda"};
    private String[] modelli = {"500", "Corolla", "Focus", "X5", "A4", "Model S", "Clio", "208", "Golf", "Civic"};
    private ArrayList<String> targhe = new ArrayList<>();
    private Alimentazione[] alimentazioni = Alimentazione.values();
    private Colore[] colori = Colore.values();
    private Motore[] motori = {
            new Motore(1200, 75),
            new Motore(1400, 90),
            new Motore(1600, 105),
            new Motore(1800, 120),
            new Motore(2000, 140),
            new Motore(2200, 170),
            new Motore(2400, 200),
            new Motore(2600, 230),
            new Motore(2800, 260),
            new Motore(3000, 300)
    };

    Random random = new Random();

    /**Il metodo genera un'auto casualmente riempendo tutti i campi dell'oggetto auto.
     * Genera anche un atarga casuale e si occupa di inserirla nella llista delle targhe
     * Chiama i metodi:
     * - public String generaTargaUnica(List<String> targheEsistenti)
     *
     * @return Automobile
     *  Una nuova automobile con i valori generati casualmente
     */
    public Automobile creaAuto() {
        int value = random.nextInt(marche.length);
        String marca = marche[value];
        String modello = modelli[value];
        String targa = generaTargaUnica(targhe);
        targhe.add(targa);
        Alimentazione alimentazione = alimentazioni[random.nextInt(alimentazioni.length)];
        Motore motore = motori[random.nextInt(motori.length)];
        Colore colore = colori[random.nextInt(colori.length)];
        return new Automobile(marca, modello, targa, alimentazione, motore, colore);
    }

    /**
     * Rimuove la targa dalla lista delle targhe
     * @param targa
     *  La targa che vogliamo eliminare
     */
    public void rimuoviTarga(String targa) {
        targhe.remove(targa);
    }

    /**
     * Si occupa di chiamare il metodo private String generaTargaCasuale() fino a quando non viene generata in maniera casuale
     * una targa che non è presente nell'elenco delle targhe
     * @param targheEsistenti
     *  La lista delle targhe già generate
     * @return
     *
     * Chiama i metodi:
     * - private String generaTargaCasuale()
     */
    public String generaTargaUnica(List<String> targheEsistenti) {
        String targa;
        do {
            targa = generaTargaCasuale();
        } while (targheEsistenti.contains(targa));
        return targa;
    }

    /**
     * Metodo privato per generare una targa casuale
     * @return String
     *  Una targa generata casualmente
     *  Chiamato dal metodo:
     *  - public String generaTargaUnica(List<String> targheEsistenti)
     */
    private String generaTargaCasuale() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // Genera due lettere casuali
        for (int i = 0; i < 2; i++) {
            char lettera = (char) (rand.nextInt(26) + 'A');
            sb.append(lettera);
        }

        // Genera tre cifre casuali
        for (int i = 0; i < 3; i++) {
            int cifra = rand.nextInt(10);
            sb.append(cifra);
        }

        // Genera altre due lettere casuali
        for (int i = 0; i < 2; i++) {
            char lettera = (char) (rand.nextInt(26) + 'A');
            sb.append(lettera);
        }

        return sb.toString();
    }



    public ArrayList<String> getTarghe() {
        return targhe;
    }
}
