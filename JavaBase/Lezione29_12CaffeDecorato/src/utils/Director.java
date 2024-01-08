package utils;

import decoratori.*;
import oggetti.Bevanda;
import oggetti.CaffeAmaro;
import oggetti.TheAmaro;

public class Director {

    public Director() {

    }

    public Bevanda preparaBevanda(int scelta, boolean zuccherato, int livelloZucchero) {
        switch (scelta) {
            case Costanti.CAFFE -> {
                if (!zuccherato) return new CaffeAmaro();
                else return new BevandaConZucchero(new CaffeAmaro(), livelloZucchero);
            }
            case Costanti.CAFFE_LUNGO -> {
                if(!zuccherato) return new BevandaAllungata(new CaffeAmaro());
                else return new BevandaConZucchero(new BevandaAllungata(new CaffeAmaro()), livelloZucchero);
            }
            case Costanti.CAFFELATTE -> {
                if(!zuccherato) return new BevandaLatte(new CaffeAmaro());
                else return new BevandaConZucchero(new BevandaLatte(new CaffeAmaro()), livelloZucchero);
            }
            case Costanti.CAPPUCCINO -> {
                if (!zuccherato) return new BevandaSchiumosa(new BevandaLatte(new CaffeAmaro()));
                else return new BevandaConZucchero(new BevandaSchiumosa(new BevandaLatte(new CaffeAmaro())), livelloZucchero);
            }
            case Costanti.CAFFE_MAROCCHINO -> {
                return new BevandaConZucchero(new BevandaSpeziata(new BevandaAllungata(new CaffeAmaro())), livelloZucchero);
            }
            case Costanti.THE -> {
                if(!zuccherato) return new TheAmaro();
                else return new BevandaConZucchero(new TheAmaro(), livelloZucchero);
            }
            case Costanti.THE_CON_LATTE -> {
                if (!zuccherato) return new BevandaLatte(new TheAmaro());
                else return new BevandaConZucchero(new BevandaLatte(new TheAmaro()), livelloZucchero);
            }
            case Costanti.THE_CON_SPEZIE -> {
                if (!zuccherato) return new BevandaSpeziata(new TheAmaro());
                else return new BevandaConZucchero(new BevandaSpeziata(new TheAmaro()), livelloZucchero);
            }
            default -> {return null;}
        }
    }


}
