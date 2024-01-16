package utils;

import Classi.StatisticheOrdinamento;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {
    private int[] mioArray;
    private int lunghezzaArray;

    Random random = new Random();

    public Utils(int lunghezzaArray) {
        this.lunghezzaArray = lunghezzaArray;

    }

    public int[] creaArray() {
        mioArray = new int[lunghezzaArray];
        for (int i = 0; i < lunghezzaArray; i++) {
            mioArray[i] = random.nextInt(101);
        }
        return mioArray;
    }

    public void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public void calcolaStatisticheOrdinamenti(HashMap<String, StatisticheOrdinamento> numeroPassiAlgoritmi) {
        int somma;
        for (Map.Entry<String, StatisticheOrdinamento> entry : numeroPassiAlgoritmi.entrySet()) {
            String chiave = entry.getKey();
            StatisticheOrdinamento valore = entry.getValue();
            System.out.println(chiave);
            System.out.println("----------------------------------");
            somma = 0;
            System.out.printf("Numero minimo di passi per %s : %d\n", chiave, Collections.min(valore.numeroPassi));
            System.out.printf("Numero massimo di passi per %s : %d\n", chiave, Collections.max(valore.numeroPassi));
            for(int j = 0; j < valore.numeroPassi.size(); j++) {
                somma += valore.numeroPassi.get(j);
            }
            System.out.printf("Numero di passi medi per %s : %d\n\n", chiave, (int) somma/valore.numeroPassi.size());
        }
    }

    public int getLunghezzaArray() {
        return lunghezzaArray;
    }

    public void setLunghezzaArray(int lunghezzaArray) {
        this.lunghezzaArray = lunghezzaArray;
    }
}
