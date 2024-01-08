package builder.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menu.MenuStella;
import products.menuComponents.panini.Panino;

public class MenuStellaBuilder implements MenuBuilder{
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

    public MenuStella getResult() {
        return new MenuStella(
                panino, bevanda, contorno
        );
    }
}
