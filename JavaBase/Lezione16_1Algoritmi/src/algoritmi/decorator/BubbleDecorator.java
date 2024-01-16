package algoritmi.decorator;

import Classi.NumeroIterazioni;
import algoritmi.superclassi.BaseDecorator;
import algoritmi.superclassi.Ordinamento;

import java.util.Arrays;

public class BubbleDecorator extends BaseDecorator {
    public BubbleDecorator(Ordinamento source) {
        super(source);
    }

    @Override
    public int[] ordina(int[] array, NumeroIterazioni numeroIterazioni) {
        numeroIterazioni.setNumeroIterazioni(0);
        mioArray = Arrays.copyOf(array, array.length);
        lunghezzaArray = mioArray.length;

        for (int i = 0; i < lunghezzaArray - 1; i++) {

            int temp;
            boolean swapped = false;

            for(int j = 0; j < lunghezzaArray-i-1; j++) {
                numeroIterazioni.setNumeroIterazioni(numeroIterazioni.getNumeroIterazioni() + 1);
                if (mioArray[j] > mioArray[j+1]) {
                    temp = mioArray[j];
                    mioArray[j] = mioArray[j+1];
                    mioArray[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }

        return mioArray;
    }
}
