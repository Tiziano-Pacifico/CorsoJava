package Classi;

public class Motore {

    private int cilindata;
    private int cavalli;

    public Motore(int cilindata, int cavalli) {
        this.cilindata = cilindata;
        this.cavalli = cavalli;
    }

    public Motore() {
        this.cavalli = 0;
        this.cilindata = 0;
    }

    public int getCilindata() {
        return cilindata;
    }

    public void setCilindata(int cilindata) {
        this.cilindata = cilindata;
    }

    public int getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) {
        this.cavalli = cavalli;
    }

    @Override
    public String toString() {
        return "Motore{" +
                "cilindata=" + cilindata +
                ", cavalli=" + cavalli +
                '}';
    }
}
