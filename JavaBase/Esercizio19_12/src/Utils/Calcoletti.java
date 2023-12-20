package Utils;

public class Calcoletti {

    public double calcolaMedia(int[] valori) {
        int total = 0;

        for(int i=0; i < valori.length; i++) {
            total += valori[i];
        }

        return total/valori.length;
    }

    public int trovaMassimo(int[] valori) {
        int massimo = valori[0];
        for (int i = 1; i < valori.length; i++) {
            if (valori[i] > massimo) {
                massimo = valori[i];
            }
        }

        return massimo;
    }

    public int trovaMininmo(int[] valori) {
        int minimo = valori[0];
        for (int i = 1; i < valori.length; i++) {
            if (valori[i] < minimo) {
                minimo = valori[i];
            }
        }

        return minimo;
    }
}
