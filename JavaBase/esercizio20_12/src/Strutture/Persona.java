package Strutture;

public class Persona {

    private String nome;
    private String cognome;
    private String id;
    private String account;
    private String ruolo;

    public Persona(String cognome, String nome, String id, String account, String ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.account = account;
        this.ruolo = ruolo;
    }

    public Persona() {
        this.nome = "";
        this.cognome = "";
        this.account = "";
        this.id = "";
        this.ruolo = "";
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", ruolo='" + ruolo + '\'' +
                '}';
    }
}
