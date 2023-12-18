package it.tiziano;
/**
 * Classe madre per gestione pazienti
 * @author  Tiziano Pacifico
 * @version 1.0
 */
public class Persona {
    private String nome;
    public Persona(){
        nome = "Ancora nessun nome";
    }
    public Persona(String nomeIniziale) {
        nome = nomeIniziale;
    }

    /**
     *
     * @param nuovoNome stringa con nome di persona
     */
    public void setNome(String nuovoNome) {
        nome = nuovoNome;
    }

    public String getNome() {
        return nome;
    }
    public void scriviOutput() {
        System.out.println("Nome: " + nome);
    }
    public boolean haLoStessoNome(Persona altraPersona) {
        return this.nome.equalsIgnoreCase(altraPersona.nome);
    }
}
