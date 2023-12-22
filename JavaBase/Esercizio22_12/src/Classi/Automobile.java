package Classi;

import enumerazioni.Alimentazione;
import enumerazioni.Colore;

public class Automobile {

    private String marca;
    private String modello;
    private String targa;
    private Alimentazione alimentazione;
    private Motore motore;
    private Colore colore;

    public Automobile(String marca, String modello, String targa, Alimentazione alimentazione, Motore motore, Colore colore) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.alimentazione = alimentazione;
        this.motore = motore;
        this.colore = colore;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(Alimentazione alimentazione) {
        this.alimentazione = alimentazione;
    }

    public Motore getMotore() {
        return motore;
    }

    public void setMotore(Motore motore) {
        this.motore = motore;
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", targa='" + targa + '\'' +
                ", alimentazione=" + alimentazione +
                ", motore=" + motore +
                ", colore=" + colore +
                '}';
    }
}
