package algoritmi.decorator;

import Classi.NumeroIterazioni;
import algoritmi.superclassi.BaseDecorator;
import algoritmi.superclassi.Ordinamento;

import java.util.Arrays;

public class SelectionDecorator extends BaseDecorator {
    public SelectionDecorator(Ordinamento source) {
        super(source);
    }

    @Override
    public int[] ordina(int[] array, NumeroIterazioni numeroIterazioni) {
        numeroIterazioni.setNumeroIterazioni(0);
        mioArray = Arrays.copyOf(array, array.length);
        lunghezzaArray = mioArray.length;

        int minIndex,temp;
        for (int i = 0; i < lunghezzaArray-1; i++) {
            minIndex = i;
            for(int j = i+1; j < lunghezzaArray; j++) {
                if (mioArray[j] < mioArray[minIndex]) {
                    numeroIterazioni.setNumeroIterazioni(numeroIterazioni.getNumeroIterazioni() + 1);
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                temp = mioArray[minIndex];
                mioArray[minIndex] = mioArray[i];
                mioArray[i] = temp;
            }

        }

        return mioArray;
    }
}
