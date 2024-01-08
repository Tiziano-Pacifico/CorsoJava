package factories.menu;

import builder.menu.MenuDirector;
import builder.menu.MenuSoleBuilder;
import builder.menu.MenuStellaBuilder;
import products.menu.Menu;

public class MenuStellaFactory extends MenuFactory{

    private MenuDirector md = new MenuDirector();
    private MenuStellaBuilder mstb = new MenuStellaBuilder();

    @Override
    public Menu creaMenu() {
        System.out.println("Creato menu stella");
        md.creaMenuStella(mstb);
        return mstb.getResult();
    }

}
