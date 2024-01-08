package factories.menu;

import builder.menu.MenuDirector;
import builder.menu.MenuLunaBuilder;
import builder.menu.MenuSoleBuilder;
import products.menu.Menu;

public class MenuLunaFactory extends MenuFactory{

    private MenuDirector md = new MenuDirector();
    private MenuLunaBuilder mlb = new MenuLunaBuilder();

    @Override
    public Menu creaMenu() {
        System.out.println("Creato menu luna");
        md.creaMenuLuna(mlb);
        return mlb.getResult();
    }

}
