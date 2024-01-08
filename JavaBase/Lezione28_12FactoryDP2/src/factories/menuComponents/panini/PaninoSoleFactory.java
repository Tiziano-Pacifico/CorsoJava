package factories.menuComponents.panini;

import builder.menuComponents.panini.PaniniDirector;
import builder.menuComponents.panini.PaniniLunaBuilder;
import builder.menuComponents.panini.PaniniSoleBuilder;
import products.menuComponents.panini.Panino;

public class PaninoSoleFactory extends PaninoFactory{

    private PaniniDirector pd = new PaniniDirector();
    private PaniniSoleBuilder psb = new PaniniSoleBuilder();


    @Override
    public Panino creaPanino() {
        System.out.println("Creato panino sole");
        pd.creaPaninoSole(psb);
        return psb.getResult();
    }
}
