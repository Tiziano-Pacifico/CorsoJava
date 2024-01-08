package builder.menuComponents.bevande;

import products.menuComponents.bevande.BevandaStella;

public class BevandeStellaBuilder implements BevandeBuilder{

    private String liquido, aggiunta;


    @Override
    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }

    @Override
    public void setAggiunta(String aggiunta) {
        this.aggiunta = aggiunta;
    }

    public BevandaStella getResult() {
        return new BevandaStella(liquido, aggiunta);
    }
}
