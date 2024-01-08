package decoratori;

import oggetti.Bevanda;

public class BevandaAllungata extends BevandaDecorata {
    public BevandaAllungata(Bevanda wrappee) {
        super(wrappee);
    }

    @Override
    public String prepara() {
        return allunga(super.prepara());
    }

    @Override
    public float calcolaCosto() {
        return super.calcolaCosto() +0.10f;
    }

    private String allunga(String passiPrecedenti) {
        return passiPrecedenti + "- allungo il caffè" + "\n";
    }
}
