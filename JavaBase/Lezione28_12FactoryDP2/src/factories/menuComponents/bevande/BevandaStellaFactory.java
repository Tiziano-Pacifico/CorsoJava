package factories.menuComponents.bevande;

import builder.menuComponents.bevande.BevandeDirector;
import builder.menuComponents.bevande.BevandeLunaBuilder;
import builder.menuComponents.bevande.BevandeStellaBuilder;
import products.menuComponents.bevande.Bevanda;

public class BevandaStellaFactory extends  BevandaFactory{

    private BevandeDirector bd = new BevandeDirector();
    private BevandeStellaBuilder bstb = new BevandeStellaBuilder();

    @Override
    public Bevanda creaBevanda() {
        System.out.println("Creata bevanda stella");
        bd.creaBevandaStella(bstb);
        return bstb.getResult();
    }

}
