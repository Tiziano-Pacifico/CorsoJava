package decoratori;

import oggetti.Bevanda;

public class BevandaSpeziata extends BevandaDecorata {
    public BevandaSpeziata(Bevanda wrappee) {
        super(wrappee);
    }

    @Override
    public String prepara() {

        return aggiungoSpezie(super.prepara());
    }

    @Override
    public float calcolaCosto() {
        return super.calcolaCosto() + 0.3f;
    }

    private String aggiungoSpezie(String passiPrecedenti) {
        return passiPrecedenti + "- Aggiungo Spezie \n";
    }
}
