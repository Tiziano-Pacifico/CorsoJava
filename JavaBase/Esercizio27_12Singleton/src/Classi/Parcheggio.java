package Classi;

public class Parcheggio {

    public static int numeroAuto;
    private static Parcheggio istance = null;

    private Parcheggio() {
        this.numeroAuto = 0;
    }

    public static Parcheggio creaIstanza() {
        if (Parcheggio.istance == null) {
            Parcheggio.istance = new Parcheggio();
        }
        return Parcheggio.istance;
    }

    public static int getNumeroAuto() {
        return numeroAuto;
    }

    public void setNumeroAuto(int numeroAuto) {
        this.numeroAuto = numeroAuto;
    }

}
