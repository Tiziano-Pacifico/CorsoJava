package Classi;

import utils.CarBuilder;

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

    public Car() {
        
    }
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

    //Utilizziamo il builder come inner class
    public static class Builder implements CarBuilder{
        private String marca;
        private String modello;
        private String colore;
        private char alimentazione;
        private int nrPorte;
        private int peso;
        private float lunghezza;
        private boolean navigatore;



        @Override
        public CarBuilder setMarca(String marca) {
            this.marca = marca;
            return this; //ritorna l'istanza dell'oggetto corrente sul quale il metodo è chiamato
        }

        @Override
        public CarBuilder setModello(String modello) {
            this.modello = modello;
            return this;
        }

        @Override
        public CarBuilder setColore(String colore) {
            this.colore = colore;
            return this;
        }

        @Override
        public CarBuilder setAlimentazione(char alimentazione) {
            this.alimentazione = alimentazione;
            return this;
        }

        @Override
        public CarBuilder setNrPorte(int nrPorte) {
            this.nrPorte = nrPorte;
            return this;
        }

        @Override
        public CarBuilder setPeso(int peso) {
            this.peso = peso;
            return this;
        }

        @Override
        public CarBuilder setLunghezza(float lunghezza) {
            this.lunghezza = lunghezza;
            return this;
        }

        @Override
        public CarBuilder setNavigatore(boolean hasNavigator) {
            this.navigatore = hasNavigator;
            return this;
        }

        @Override
        public Car build() {
            Car auto = new Car();
            auto.marca = marca;
            auto.modello = modello;
            auto.colore = colore;
            auto.alimentazione = alimentazione;
            auto.nrPorte = nrPorte;
            auto.peso = peso;
            auto.lunghezza = lunghezza;
            auto.navigatore = navigatore;
            return auto;
        }
    }
}
