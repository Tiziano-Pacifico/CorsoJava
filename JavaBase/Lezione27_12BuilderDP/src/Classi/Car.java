package Classi;

public class Car {
    private String marca;
    private String modello;
    private String colore;
    private char alimentazione;
    private int nrPorte;
    private int peso;
    private float lunghezza;
    private boolean navigatore;

    //metodi getter e setter

    //toString


    public Car(String marca, String modello, String colore, char alimentazione, int nrPorte, int peso, float lunghezza, boolean navigatore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.alimentazione = alimentazione;
        this.nrPorte = nrPorte;
        this.peso = peso;
        this.lunghezza = lunghezza;
        this.navigatore = navigatore;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", colore='" + colore + '\'' +
                ", alimentazione=" + alimentazione +
                ", nrPorte=" + nrPorte +
                ", peso=" + peso +
                ", lunghezza=" + lunghezza +
                ", navigatore=" + navigatore +
                '}';
    }
}
