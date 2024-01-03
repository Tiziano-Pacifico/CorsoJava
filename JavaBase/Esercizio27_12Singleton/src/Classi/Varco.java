package Classi;

public class Varco {

    private Parcheggio park;
    private int autoEntrate = 0;
    private int autoUscite = 0;

    public Varco() {
        this.park = Parcheggio.creaIstanza();
    }

    public int contaAuto() {
        return park.getNumeroAuto();
    }

    public void entra() {
        if (park.getNumeroAuto() >= 10) {
            System.out.println("Il parcheggio è già pieno");
        }
        else {
            park.setNumeroAuto(park.getNumeroAuto() + 1);
            this.setEntrateNelVarco(this.getEntrateNelVarco() + 1);
        }
    }

    public void esci() {
        if(park.getNumeroAuto() < 1) {
            System.out.println("Il parcheggio è vuoto");
        }
        else {
            park.setNumeroAuto(park.getNumeroAuto() - 1);
            this.setAutoUscite(this.getAutoUscite() + 1);
        }
    }

    public int getEntrateNelVarco() {
        return autoEntrate;
    }

    private void setEntrateNelVarco(int entrateNelVarco) {
        this.autoEntrate = entrateNelVarco;
    }

    public int getAutoUscite() {
        return autoUscite;
    }

    private void setAutoUscite(int autoUscite) {
        this.autoUscite = autoUscite;
    }
}
