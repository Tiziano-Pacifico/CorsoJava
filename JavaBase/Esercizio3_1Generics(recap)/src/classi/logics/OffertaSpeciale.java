package classi.logics;

import classi.prodotti.Prodotto;

import java.io.Serializable;

public interface OffertaSpeciale <T extends Prodotto> extends Serializable {

    public float applicaOfferta(T prodotto);

}
