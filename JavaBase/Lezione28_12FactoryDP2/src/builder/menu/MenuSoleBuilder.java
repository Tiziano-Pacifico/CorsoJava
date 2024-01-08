package builder.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menu.MenuSole;
import products.menuComponents.panini.Panino;

public class MenuSoleBuilder implements MenuBuilder{
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

    public MenuSole getResult() {
        return new MenuSole(
                panino, bevanda, contorno
        );
    }
}
