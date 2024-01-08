package products.menuComponents.bevande;

public class BevandaLuna implements Bevanda{

    private String liquido, aggiunta;

    public BevandaLuna(){}

    public BevandaLuna(String liquido, String aggiunta) {
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
