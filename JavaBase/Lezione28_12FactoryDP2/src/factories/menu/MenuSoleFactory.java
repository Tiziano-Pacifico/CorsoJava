package factories.menu;

import builder.menu.MenuDirector;
import builder.menu.MenuSoleBuilder;
import products.menu.Menu;

public class MenuSoleFactory extends MenuFactory{

    private MenuDirector md = new MenuDirector();
    private MenuSoleBuilder msb = new MenuSoleBuilder();

    @Override
    public Menu creaMenu() {
        System.out.println("Creato menu sole");
        md.creaMenuSole(msb);
        return msb.getResult();
    }

}
