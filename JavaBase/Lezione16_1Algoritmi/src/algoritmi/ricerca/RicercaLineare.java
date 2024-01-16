package algoritmi.ricerca;

import java.util.Arrays;

public class RicercaLineare {

    public int lunghezzaArray;

    public int ricercaLineare(int[] array, int valoreDaCercare) {

        lunghezzaArray = array.length;
        int i = 0;


        while(i < lunghezzaArray && array[i] != valoreDaCercare) i++;

        return (i >= lunghezzaArray) ? -1 : i;
    }

    public int[] recercaLineareCompleta(int[] array, int valoreDaCercare) {
        lunghezzaArray = array.length;
        int[] indiciArray = new int[lunghezzaArray];

        for (int i = 0; i < lunghezzaArray; i++) {
            if (array[i] == valoreDaCercare) {
                indiciArray[i] = 1;
            }
        }
        return indiciArray;
    }
}
