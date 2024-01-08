package builder.menu;

import builder.menuComponents.panini.PaniniBuilder;
import factories.menuComponents.bevande.BevandaFactory;
import factories.menuComponents.bevande.BevandaLunaFactory;
import factories.menuComponents.bevande.BevandaSoleFactory;
import factories.menuComponents.bevande.BevandaStellaFactory;
import factories.menuComponents.contorni.ContorniFactory;
import factories.menuComponents.contorni.ContornoLunaFactory;
import factories.menuComponents.contorni.ContornoSoleFactory;
import factories.menuComponents.contorni.ContornoStellaFactory;
import factories.menuComponents.panini.PaninoFactory;
import factories.menuComponents.panini.PaninoLunaFactory;
import factories.menuComponents.panini.PaninoSoleFactory;
import factories.menuComponents.panini.PaninoStellaFactory;

public class MenuDirector {
    PaninoFactory paninoFactory;
    BevandaFactory bevandaFactory;
    ContorniFactory contornoFactory;
    public void creaMenuSole(MenuBuilder menuBuilder) {
        paninoFactory = new PaninoSoleFactory();
        bevandaFactory = new BevandaSoleFactory();
        contornoFactory = new ContornoSoleFactory();
        System.out.println("Aggiunto panino, bevanda, contorno sole");
        menuBuilder.setPanino(paninoFactory.creaPanino());
        menuBuilder.setBevanda(bevandaFactory.creaBevanda());
        menuBuilder.setContorno(contornoFactory.creaContorno());
    }

    public void creaMenuLuna(MenuBuilder menuBuilder) {
        paninoFactory = new PaninoLunaFactory();
        bevandaFactory = new BevandaLunaFactory();
        contornoFactory = new ContornoLunaFactory();
        System.out.println("Aggiunto panino, bevanda, contorno luna");
        menuBuilder.setPanino(paninoFactory.creaPanino());
        menuBuilder.setBevanda(bevandaFactory.creaBevanda());
        menuBuilder.setContorno(contornoFactory.creaContorno());
    }

    public void creaMenuStella(MenuBuilder menuBuilder) {
        paninoFactory = new PaninoStellaFactory();
        bevandaFactory = new BevandaStellaFactory();
        contornoFactory = new ContornoStellaFactory();
        System.out.println("Aggiunto panino, bevanda, contorno stella");
        menuBuilder.setPanino(paninoFactory.creaPanino());
        menuBuilder.setBevanda(bevandaFactory.creaBevanda());
        menuBuilder.setContorno(contornoFactory.creaContorno());
    }
}
