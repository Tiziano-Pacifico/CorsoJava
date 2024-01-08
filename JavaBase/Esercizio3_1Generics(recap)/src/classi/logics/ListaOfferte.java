package classi.logics;

import classi.prodotti.Libro;
import classi.prodotti.ProdottoElettronico;

public class ListaOfferte {

    public static OffertaSpeciale<Libro> offertaLibri = (libro) -> libro.getPrezzo()/2;
    public static OffertaSpeciale<ProdottoElettronico> offertaElettronica = (prodottoElettronico) -> prodottoElettronico.getPrezzo() * 0.1f;
}
