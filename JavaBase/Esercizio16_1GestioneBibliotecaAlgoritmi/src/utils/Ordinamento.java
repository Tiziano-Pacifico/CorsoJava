package utils;

import Classi.Libro;

import java.util.Arrays;

public class Ordinamento {

    int lunghezzaArray;

    public Libro[] ordina(Libro[] listaLibri) {
        Libro[] mioArray = Arrays.copyOf(listaLibri, listaLibri.length);
        lunghezzaArray = mioArray.length;

        int j;
        Libro key;

        for(int i = 1; i < lunghezzaArray; i++) {
            key = mioArray[i];
            j = i - 1;

            while(j >= 0 && mioArray[j].getAnnoPubblicazione() > key.getAnnoPubblicazione()) {
               mioArray[j + 1] = mioArray[j];
               j = j - 1;
            }

            mioArray[j+1] = key;
        }

        return mioArray;
    }
}
