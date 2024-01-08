package oggetti;

public class CaffeAmaro implements Bevanda {
    @Override
    public String prepara() {
        return "Preparo caffè amaro\n";
    }

    @Override
    public float calcolaCosto() {
        return 1.20f;
    }

}
