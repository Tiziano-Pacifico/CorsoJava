package decoratori;

import oggetti.Bevanda;

public abstract class BevandaDecorata implements Bevanda {

    private final Bevanda wrappee;

    protected BevandaDecorata(Bevanda wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String prepara() {
        return this.wrappee.prepara();
    }

    @Override
    public float calcolaCosto() {
        return this.wrappee.calcolaCosto();
    }
}
