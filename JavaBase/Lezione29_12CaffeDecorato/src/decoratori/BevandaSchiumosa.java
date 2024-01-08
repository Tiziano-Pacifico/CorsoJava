package decoratori;

import oggetti.Bevanda;

public class BevandaSchiumosa extends BevandaDecorata {
    public BevandaSchiumosa(Bevanda wrappee) {
        super(wrappee);
    }

    @Override
    public String prepara() {
        return faiSchiuma(super.prepara());
    }

    @Override
    public float calcolaCosto() {
        return super.calcolaCosto() + 0.5f;
    }

    private String faiSchiuma(String passiPrecedenti) {
        return passiPrecedenti + "- Faccio la schiuma \n";
    }
}
