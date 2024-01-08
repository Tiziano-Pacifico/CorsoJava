package factories.menuComponents.bevande;

import builder.menuComponents.bevande.BevandeDirector;
import builder.menuComponents.bevande.BevandeLunaBuilder;
import builder.menuComponents.bevande.BevandeSoleBuilder;
import products.menuComponents.bevande.Bevanda;

public class BevandaSoleFactory extends BevandaFactory{

    private BevandeDirector bd = new BevandeDirector();
    private BevandeSoleBuilder bsb = new BevandeSoleBuilder();

    @Override
    public Bevanda creaBevanda() {
        System.out.println("Creata bevanda sole");
        bd.creaBevandaSole(bsb);
        return bsb.getResult();
    }

}
