public class Contatore {

    int valore;

    public Contatore() {
        this.valore = 0;
    }

    public synchronized void incrementa() {
        valore++;
    }

    public int getValore() {
        return valore;
    }
}
