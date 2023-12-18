package classi;
import java.lang.String;

public class Documento {

    private String testo;

    public Documento() {
        this.testo = "";
    }

    public Documento(String testo) {
        this.testo = testo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Documento{" +
                "testo=" + testo +
                '}';
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}
