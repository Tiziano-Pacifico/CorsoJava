package Classi;

import enumerazioni.ZoneLavoro;

public class Venditore extends Persona {

    private String data_assunzione, codice;
    private float venduto;
    private ZoneLavoro zona_lavoro;

    public Venditore(String nome, String cognome, String citta, String data_assunzione, ZoneLavoro zona_lavoro, String codice, float venduto) {
        super(nome, cognome, citta);
        this.data_assunzione = data_assunzione;
        this.zona_lavoro = zona_lavoro;
        this.codice = codice;
        this.venduto = venduto;
    }

    public Venditore() {
        super();
        this.data_assunzione = "";
        this.zona_lavoro = null;
        this.codice = "";
        this.venduto = (float) 0.0;
    }

    public String getData_assunzione() {
        return data_assunzione;
    }

    public void setData_assunzione(String data_assunzione) {
        this.data_assunzione = data_assunzione;
    }

    public ZoneLavoro getZona_lavoro() {
        return zona_lavoro;
    }

    public void setZona_lavoro(ZoneLavoro zona_lavoro) {
        this.zona_lavoro = zona_lavoro;
    }

    public String getCodice() {
        return codice;
    }

    public float getVenduto() {
        return venduto;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setVenduto(float venduto) {
        this.venduto = venduto;
    }

    @Override
    public String toString() {
        return "Venditori{" + super.toString() +
                "data_assunzione='" + data_assunzione + '\'' +
                ", zona_lavoro='" + zona_lavoro + '\'' +
                ", codice='" + codice + '\'' +
                ", venduto='" + venduto +'\'' +
                '}';
    }
}
