package factories.menuComponents.panini;

import builder.menuComponents.panini.PaniniDirector;
import builder.menuComponents.panini.PaniniLunaBuilder;
import builder.menuComponents.panini.PaniniStellaBuilder;
import products.menuComponents.panini.Panino;

public class PaninoStellaFactory extends PaninoFactory{

    private PaniniDirector pd = new PaniniDirector();
    private PaniniStellaBuilder pstb = new PaniniStellaBuilder();


    @Override
    public Panino creaPanino() {
        System.out.println("Creato panino stella");
        pd.creaPaninoStella(pstb);
        return pstb.getResult();
    }
}
