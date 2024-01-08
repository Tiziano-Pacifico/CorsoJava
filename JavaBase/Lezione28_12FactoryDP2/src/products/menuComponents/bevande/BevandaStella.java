package products.menuComponents.bevande;

public class BevandaStella implements Bevanda{

    private String liquido, aggiunta;

    public BevandaStella(){}

    public BevandaStella(String liquido, String aggiunta) {
        this.liquido = liquido;
        this.aggiunta = aggiunta;
    }

    @Override
    public void prepara() {

    }

    @Override
    public String getLiquido() {
        return this.liquido;
    }

    @Override
    public String getAggiunte() {
        return this.aggiunta;
    }
}
