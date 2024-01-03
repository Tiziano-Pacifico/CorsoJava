package utils;

import Classi.Varco;

import java.util.ArrayList;

public class Init {

    ArrayList<Varco> varchi = new ArrayList<>();

    public Init() {
        for (int i = 0; i < 5; i++) {
            varchi.add(new Varco());
        }
    }

    public ArrayList<Varco> getVarchi() {
        return varchi;
    }
}
