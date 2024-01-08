package decoratori;

import oggetti.Bevanda;

public class BevandaLatte extends BevandaDecorata {
    public BevandaLatte(Bevanda wrappee) {
        super(wrappee);
    }

    @Override
    public String prepara() {
        return aggiungiLatte(super.prepara());
    }

    @Override
    public float calcolaCosto() {
        return super.calcolaCosto() + 0.2f;
    }

    private String aggiungiLatte(String passiPrecedenti) {
        return passiPrecedenti + "- Aggiungo Latte \n";
    }
}
