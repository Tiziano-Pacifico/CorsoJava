package builder.menuComponents.bevande;

import products.menuComponents.bevande.BevandaSole;

public class BevandeSoleBuilder implements BevandeBuilder{

    private String liquido, aggiunta;


    @Override
    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }

    @Override
    public void setAggiunta(String aggiunta) {
        this.aggiunta = aggiunta;
    }

    public BevandaSole getResult() {
        return new BevandaSole(liquido, aggiunta);
    }
}
