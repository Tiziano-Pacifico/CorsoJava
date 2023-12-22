
import Classi.Costanti;

import utils.Generic;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Generic genericMethods = new Generic();

        int scelta = -1;

        while(scelta != Costanti.ESCI) {

            genericMethods.stampaMenu();
            scelta = scanner.nextInt();
            genericMethods.gestisciScelta(scelta);
        }

    }

}