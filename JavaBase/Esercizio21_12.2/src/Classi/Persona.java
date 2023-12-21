package Classi;

public class Persona {

    private String nome,cognome,citta;

    public Persona(String nome, String cognome, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
    }

    public Persona() {
        nome = "";
        cognome = "";
        citta = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", citta='" + citta + '\'' + ", ";
    }
}
