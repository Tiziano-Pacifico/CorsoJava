package classi;

import java.util.ArrayList;

public class BeefBurger {

    private int id;
    private ArrayList<String> ingredienti;

    public void preparato() {
        System.out.println("Il panino di carne è stato preparato");
        ingredienti.add("Panino");
        ingredienti.add("Carne di manzo");
        ingredienti.add("Insalata");
    }
}
