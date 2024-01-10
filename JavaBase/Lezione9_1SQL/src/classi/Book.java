package classi;

public class Book {
    private int id, idAutore;
    private String titolo, annoPubblicazione;

    public Book(String titolo, int idAutore, String annoPubblicazione) {
        this.titolo = titolo;
        this.idAutore = idAutore;
        this.annoPubblicazione = annoPubblicazione;
    }

    public Book() {
        this.id = -1;
        this.titolo = null;
        this.idAutore = -1;
        this.annoPubblicazione = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public String getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(String annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + idAutore + '\'' +
                ", annoPubblicazione='" + annoPubblicazione + '\'' +
                '}';
    }
}
