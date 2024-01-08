package classi;

import java.util.ArrayList;

public class Tavolo {

    private int nrPosti;
    private boolean occupato, haOrdinato = false;
    private ArrayList<Pizza> listaPizzeOrdinate = new ArrayList<>();

    public Tavolo(int nrPosti) {
        this.nrPosti = nrPosti;
        this.occupato = false;
    }

    public void resetTavolo() {
        occupato = false;
        haOrdinato = false;
        listaPizzeOrdinate.clear();
    }

    public int getNrPosti() {
        return nrPosti;
    }


    public void setNrPosti(int nrPosti) {
        this.nrPosti = nrPosti;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public ArrayList<Pizza> getListaPizzeOrdinate() {
        return listaPizzeOrdinate;
    }

    public void setListaPizzeOrdinate(ArrayList<Pizza> listaPizzeOrdinate) {
        this.listaPizzeOrdinate = listaPizzeOrdinate;
        haOrdinato = true;
    }

    public boolean haOrdinato() {
        return haOrdinato;
    }

    public void setHaOrdinato(boolean haOrdinato) {
        this.haOrdinato = haOrdinato;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "nrPosti=" + nrPosti +
                ", occupato=" + occupato +
                '}';
    }


    public String toString(int nrTavolo) {
        return "Tavolo_" + nrTavolo+"{" +
                "nrPosti=" + nrPosti +
                ", occupato=" + occupato +
                ", haOrdinato=" + haOrdinato +
                '}';
    }
}
