package builder.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menu.MenuLuna;
import products.menuComponents.panini.Panino;

public class MenuLunaBuilder implements MenuBuilder{

    private Panino panino;
    private Bevanda bevanda;
    private Contorno contorno;


    @Override
    public void setPanino(Panino panino) {
        this.panino = panino;
    }

    @Override
    public void setBevanda(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

    @Override
    public void setContorno(Contorno contorno) {
        this.contorno = contorno;
    }

    public MenuLuna getResult() {
        return new MenuLuna(
                panino,bevanda,contorno
        );
    }
}
