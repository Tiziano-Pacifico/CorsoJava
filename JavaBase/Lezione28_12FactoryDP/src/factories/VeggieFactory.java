package factories;

import builder.Restaurant;
import builder.VeggieBuilder;
import products.Panino;
import products.PaninoVeggie;

public class VeggieFactory extends PaninoFactory{

    private Restaurant r = new Restaurant();
    private VeggieBuilder vb = new VeggieBuilder();

    @Override
    public Panino creaPanino() {
        r.creaPaninoVeggie(vb);
        return vb.getResult();
    }
}
