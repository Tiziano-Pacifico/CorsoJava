package classi;

public class Email extends Documento{

    private String mittente, destinatario, titolo;

    public Email(){
        this.setTesto("Vuoto");
        this.destinatario = "Nessuno";
        this.mittente = "Nessuno";
        this.titolo = "Nessuno";

    }

    public Email(String testo, String mittente, String destinatario, String titolo) {
        super(testo);
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.titolo= titolo;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String
    toString() {
        return "Email{" +
                "mittente='" + mittente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", titolo='" + titolo + '\'' +
                '}';
    }

    public String toTotalString() {
        return "Email{" +
                "mittente='" + mittente + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", titolo='" + titolo + '\'' +
                ", testo ='" + this.getTesto() + '\'' +
                '}';
    }
}
