package factories;

import builder.BeefBuilder;
import builder.Restaurant;
import builder.VeggieBuilder;
import products.Panino;
import products.PaninoCarne;

public class BeefFactory extends PaninoFactory{
    private Restaurant r = new Restaurant();
    private BeefBuilder bb = new BeefBuilder();

    @Override
    public Panino creaPanino() {
        r.creaPaninoCarne(bb);
        return bb.getResult();
    }
}
