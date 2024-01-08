package products.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menuComponents.panini.Panino;

public interface Menu {

    public void assembla();

    public Panino getPanino();

    public Contorno getContorno();

    public Bevanda getBevanda();
}
