package classi.prodotti;

import java.io.Serializable;

public class Libro extends Prodotto implements Serializable, Comparable<Libro>{

    private String autore;

    public Libro(String nome, float prezzo, String autore) {
        super(nome, prezzo);
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }



    @Override
    public String toString() {
        return "Libro{" +
                "nome='" + getNome() + '\'' +
                "prezzo='" + getPrezzo() + '\'' +
                "autore='" + autore + '\'' +
                '}';
    }

    @Override
    public int compareTo(Libro o) {

        return Float.compare(this.getPrezzo(), o.getPrezzo());
    }
}
