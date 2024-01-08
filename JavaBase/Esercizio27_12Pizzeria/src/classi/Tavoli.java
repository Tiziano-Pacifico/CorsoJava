package classi;

import utils.Costanti;

import java.util.ArrayList;
import java.util.Random;

public class Tavoli {

    ArrayList<Tavolo> tavoli;

    Random r = new Random();

    private static Tavoli instance = null;
    private Tavoli() {
        tavoli = new ArrayList<>();
        for (int i = 0; i < Costanti.NUMERO_TAVOLI; i++) {
            tavoli.add(new Tavolo(r.nextInt(10) + 2));
        }
    }

    public static Tavoli createTavoli() {
        if(instance == null) {
            instance = new Tavoli();
        }
        return instance;
    }

    public ArrayList<Tavolo> getListaTavoli() {
        return tavoli;
    }

    public void setTavoli(ArrayList<Tavolo> tavoli) {
        this.tavoli = tavoli;
    }
}
