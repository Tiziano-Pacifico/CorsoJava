package classi;

import classi.logics.Carrello;
import classi.prodotti.Prodotto;

import java.io.Serializable;
import java.util.ArrayList;

/*
La calsse utente implemet un utemte del servizio.
Ogni utente registrato verrà inserito in un database. Il database creerà automaticamente un id relativo all'utente che sarà il suo identificativo unico
Un utente può essere creato, e allora il suo storico acquisto sarà vuoto.
Se l'utente è già esistente, l'utente potrà loggarsi e allora verrà automaticamente caricato il suo storico acquisti
 */
//@todo Creare utente, Loggare Utente(caricare il suo storico acquisti)
public class Utente  implements Serializable {
    private int id;
    private String nome;
    private String indirizzo;
    private ArrayList<Prodotto> storicoAcquisti;
    private Carrello carrello;

    public Utente() {}

    public Utente(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.id = -1;
        storicoAcquisti = new ArrayList<>();
        carrello = new Carrello();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<Prodotto> getStoricoAcquisti() {
        return storicoAcquisti;
    }

    public void setStoricoAcquisti(ArrayList<Prodotto> storicoAcquisti) {
        this.storicoAcquisti = storicoAcquisti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    private void aggiungiProdottoCarrello(Prodotto prodotto) {

        carrello.aggiungiProdotto(prodotto);
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    private void aggiungiProdottoStorico(Prodotto prodotto) {
        this.storicoAcquisti.add(prodotto);
    }

    public void aggiornaUtente(Prodotto prodotto) {
        aggiungiProdottoCarrello(prodotto);
        aggiungiProdottoStorico(prodotto);
    }

    public void stampaStorico() {
        for (int i = 0; i < this.storicoAcquisti.size(); i++) {
            System.out.println(storicoAcquisti.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
