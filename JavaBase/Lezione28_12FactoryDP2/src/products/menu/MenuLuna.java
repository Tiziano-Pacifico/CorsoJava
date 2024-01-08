package products.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menuComponents.panini.Panino;

public class MenuLuna implements Menu{

    private Panino panino;
    private Bevanda bevanda;
    private Contorno contorno;

    public MenuLuna(){}

    public MenuLuna(Panino panino, Bevanda bevanda, Contorno contorno) {
        this.panino = panino;
        this.bevanda = bevanda;
        this.contorno = contorno;
    }

    @Override
    public void assembla() {

    }

    @Override
    public Panino getPanino() {
        return this.panino;
    }

    @Override
    public Contorno getContorno() {
        return this.contorno;
    }

    @Override
    public Bevanda getBevanda() {
        return this.bevanda;
    }
}
