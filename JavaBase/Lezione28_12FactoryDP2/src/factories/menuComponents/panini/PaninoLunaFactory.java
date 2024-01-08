package factories.menuComponents.panini;

import builder.menuComponents.panini.PaniniDirector;
import builder.menuComponents.panini.PaniniLunaBuilder;
import products.menuComponents.panini.Panino;

public class PaninoLunaFactory extends PaninoFactory{

    private PaniniDirector pd = new PaniniDirector();
    private PaniniLunaBuilder plb = new PaniniLunaBuilder();


    @Override
    public Panino creaPanino() {
        System.out.println("Creato panino luna");
        pd.creaPaninoLuna(plb);
        return plb.getResult();
    }

}
