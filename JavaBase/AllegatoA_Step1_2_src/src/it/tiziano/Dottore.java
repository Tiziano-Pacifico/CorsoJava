package it.tiziano;

public class Dottore extends Persona{

    private static final float TOLERANCE = 0.00001f;

    String specializzazione;
    Double parcella;

    public Dottore(String specializzazione, Double parcella, String nome) {
        super(nome);
        this.parcella = parcella;
        this.specializzazione = specializzazione;
    }

    public Dottore() {
        super();
        this.parcella = 0.0;
        this.specializzazione = "Generico";
    }

    public static boolean equals(Double a, Double b) {
        return Math.abs(a - b) < TOLERANCE;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public Double getParcella() {
        return parcella;
    }

    public void setParcella(Double parcella) {
        this.parcella = parcella;
    }

    public boolean haLoStessoNomeParcellaSpec(Dottore altroDottore) {
        return this.getNome().equalsIgnoreCase(altroDottore.getNome()) &&
                this.getSpecializzazione().equalsIgnoreCase(altroDottore.getSpecializzazione()) &&
                this.equals(this.getParcella(),altroDottore.getParcella());
    }
}
