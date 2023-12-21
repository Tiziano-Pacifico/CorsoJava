package Classi;

public class Vendite {

    private String codiceVenditore;
    private float importo;

    public Vendite(String codiceVenditore, float importo) {
        this.codiceVenditore = codiceVenditore;
        this.importo = importo;
    }

    public Vendite() {
        this.codiceVenditore = "";
        this.importo = 0.0f;
    }

    public String getCodiceVenditore() {
        return codiceVenditore;
    }

    public void setCodiceVenditore(String codiceVenditore) {
        this.codiceVenditore = codiceVenditore;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    @Override
    public String toString() {
        return "Vendite{" +
                "codiceVenditore='" + codiceVenditore + '\'' +
                ", importo=" + importo +
                '}';
    }
}
