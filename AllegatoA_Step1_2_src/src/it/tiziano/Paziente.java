package it.tiziano;



public class Paziente extends Persona{

    String id;
    public Paziente(String nome, String id) {
        super(nome);
        this.id = id;
    }

    public Paziente() {
        super();
        this.id = "xxx";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean haLoStessoIdNome(Paziente altroPaziente) {
        return this.getNome().equalsIgnoreCase(altroPaziente.getNome()) && this.getId().equalsIgnoreCase(altroPaziente.getId());
    }
}
