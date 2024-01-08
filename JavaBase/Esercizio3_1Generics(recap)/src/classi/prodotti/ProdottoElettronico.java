package classi.prodotti;

import java.io.Serializable;

public class ProdottoElettronico extends Prodotto implements Serializable {

    private String marca;

    public ProdottoElettronico(String nome, float prezzo, String marca) {
        super(nome, prezzo);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ProdottoElettronico{" +
                "nome='" + getNome() + '\'' +
                "prezzo='" + getPrezzo() + '\'' +
                "marca='" + marca + '\'' +
                '}';
    }
}
