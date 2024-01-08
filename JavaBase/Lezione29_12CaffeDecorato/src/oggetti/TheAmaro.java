package oggetti;

public class TheAmaro implements Bevanda{
    @Override
    public String prepara() {
        return "Preparo the amaro\n";
    }

    @Override
    public float calcolaCosto() {
        return 1f;
    }
}
