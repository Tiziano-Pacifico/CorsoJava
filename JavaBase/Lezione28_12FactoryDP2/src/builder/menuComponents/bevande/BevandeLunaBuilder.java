package builder.menuComponents.bevande;

import products.menuComponents.bevande.BevandaLuna;

public class BevandeLunaBuilder implements BevandeBuilder{

    private String liquido, aggiunta;


    @Override
    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }

    @Override
    public void setAggiunta(String aggiunta) {
        this.aggiunta = aggiunta;
    }

    public BevandaLuna getResult() {
        return new BevandaLuna(liquido, aggiunta);
    }
}
