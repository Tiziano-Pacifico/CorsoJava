package classi.prodotti;

import java.util.ArrayList;

public class ArchivioProdotti {

    private ArrayList<Libro> libri = new ArrayList<>();
    private ArrayList<ProdottoElettronico> prodottiElettronici = new ArrayList<>();

    public ArchivioProdotti() {
        libri.add(new Libro("a",10.4f, "a"));
        libri.add(new Libro("b",12.4f, "b"));
        libri.add(new Libro("c",15.4f, "c"));
        prodottiElettronici.add(new ProdottoElettronico("aa", 102.3f,"aa"));
        prodottiElettronici.add(new ProdottoElettronico("bb", 23.5f,"bb"));
        prodottiElettronici.add(new ProdottoElettronico("cc", 300.5f,"cc"));

    }

    public void listaLibri() {
        for (int i = 0; i < libri.size(); i++) {
            System.out.println(i + " - " + libri.get(i).toString());
        }
    }

    public void listaProdottiElettronici() {
        for (int i = 0; i < prodottiElettronici.size(); i++) {
            System.out.println(i + " - " + prodottiElettronici.get(i).toString());
        }
    }

    public ArrayList<Libro> getLibri() {
        return libri;
    }

    public ArrayList<ProdottoElettronico> getProdottiElettronici() {
        return prodottiElettronici;
    }
}
