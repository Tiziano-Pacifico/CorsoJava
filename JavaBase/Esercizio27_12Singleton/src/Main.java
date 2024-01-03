import Classi.Costanti;
import Classi.Parcheggio;
import Classi.Varco;
import gestioneMenu.GestoreMenu;
import utils.Init;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        GestoreMenu gm = new GestoreMenu();
        Init init = new Init();

        ArrayList<Varco> varchi = init.getVarchi();
        int scelta = -1;

        Scanner scanner = new Scanner(System.in);

        while(scelta != Costanti.ESCI_MENU) {
            
                gm.stampaMenu();
                scelta = scanner.nextInt();
                gm.gestisciMenu(scelta, varchi);

        }
        scanner.close();
    }

}