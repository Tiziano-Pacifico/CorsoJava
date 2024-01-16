package algoritmi.decorator;

import Classi.NumeroIterazioni;
import algoritmi.superclassi.BaseDecorator;
import algoritmi.superclassi.Ordinamento;

import java.util.Arrays;

public class InsertionDecorator extends BaseDecorator {
    public InsertionDecorator(Ordinamento source) {
        super(source);
    }

    @Override
    public int[] ordina(int[] array, NumeroIterazioni numeroIterazioni) {
        numeroIterazioni.setNumeroIterazioni(0);
        mioArray = Arrays.copyOf(array, array.length);
        lunghezzaArray = mioArray.length;

        int key,j;

        for (int i = 1; i < lunghezzaArray; i++) {
            key = mioArray[i];
            j = i - 1;

            while(j >=0 && mioArray[j] > key) {
                mioArray[j+1] = mioArray[j];
                j = j -1;
                numeroIterazioni.setNumeroIterazioni(numeroIterazioni.getNumeroIterazioni() + 1);
            }

            mioArray[j+1] = key;
        }

        return mioArray;
    }
}
