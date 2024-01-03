package utils;

import Classi.Car;
//Classe che implementa l'interfaccia
public class CarBuilderImpl implements CarBuilder{

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
        return new Car(
                marca,
                modello,
                colore,
                alimentazione,
                nrPorte,
                peso,
                lunghezza,
                navigatore
        );
    }
}
