package it.tiziano;

public class Fattura {

    Dottore doc;
    Paziente paz;

    public Fattura(Dottore doc, Paziente  paz) {
        this.doc = doc;
        this.paz = paz;
    }

    public Fattura() {
        this.doc = new Dottore();
        this.paz = new Paziente();
    }

    public Dottore getDoc() {
        return doc;
    }

    public void setDoc(Dottore doc) {
        this.doc = doc;
    }

    public Paziente getPaz() {
        return paz;
    }

    public void setPaz(Paziente paz) {
        this.paz = paz;
    }
}
