package classi.prodotti;

import java.io.Serializable;

public class Prodotto implements Serializable {

    private String nome;
    private float prezzo;

    public Prodotto(String nome, float prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }


}
