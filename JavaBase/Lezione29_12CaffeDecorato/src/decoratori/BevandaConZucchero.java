package decoratori;

import oggetti.Bevanda;

public class BevandaConZucchero extends BevandaDecorata {
    int quantita;
    public BevandaConZucchero(Bevanda wrappee, int quantita) {
        super(wrappee);
        this.quantita = quantita;
    }

    @Override
    public String prepara() {
        return aggiungiZucchero(super.prepara(), quantita);
    }

    @Override
    public float calcolaCosto() {
        return super.calcolaCosto() + 0.10f;
    }

    private String aggiungiZucchero(String passiPrecedenti, int quantita) {
        return passiPrecedenti + "- Aggiungo " + quantita + " di zucchero \n";
    }
}
