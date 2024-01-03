package utils;

import Classi.Car;

public interface CarBuilder {


    CarBuilder setMarca(String marca);
    CarBuilder setModello(String modello);

    CarBuilder setColore(String colore);

    CarBuilder setAlimentazione(char alimentazione);
    CarBuilder setNrPorte(int nrPorte);
    CarBuilder setPeso(int peso);
    CarBuilder setLunghezza(float lunghezza);
    CarBuilder setNavigatore(boolean hasNavigator);

    Car build();
    
}
