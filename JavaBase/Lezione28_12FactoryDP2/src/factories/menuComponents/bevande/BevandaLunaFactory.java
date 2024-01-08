package factories.menuComponents.bevande;

import builder.menuComponents.bevande.BevandeDirector;
import builder.menuComponents.bevande.BevandeLunaBuilder;
import products.menuComponents.bevande.Bevanda;

public class BevandaLunaFactory extends BevandaFactory{

    private BevandeDirector bd = new BevandeDirector();
    private BevandeLunaBuilder blb = new BevandeLunaBuilder();

    @Override
    public Bevanda creaBevanda() {
        System.out.println("Creata bevanda luna");
        bd.creaBevandaLuna(blb);
        return blb.getResult();
    }

}
