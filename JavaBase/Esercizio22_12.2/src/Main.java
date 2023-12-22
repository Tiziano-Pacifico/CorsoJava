import utils.GestoreCodici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> listacodici;

        GestoreCodici gc = new GestoreCodici();

        gc.generaFileCodici(10);
        listacodici = gc.caricaFileCodici();

        for(String codice: listacodici) {
            System.out.println(codice);
        }
        System.out.println();
        Collections.sort(listacodici, Comparator.reverseOrder());

        for(String codice: listacodici) {
            System.out.println(codice);
        }
    }
}