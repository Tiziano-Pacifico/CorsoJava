package Utils;

import java.util.Scanner;

public class InserisciValori {

    public int[] inserisciValori() {
        int[] valori = new int[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < valori.length; i++) {
            System.out.println("Inserisci valore numero " + i);
            valori[i] = scanner.nextInt();
        }
        return valori;
    }
}
