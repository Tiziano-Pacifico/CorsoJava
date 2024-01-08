package builder.menu;

import products.menuComponents.bevande.Bevanda;
import products.menuComponents.contorni.Contorno;
import products.menuComponents.panini.Panino;

public interface MenuBuilder {



    void setPanino(Panino panino);
    void setBevanda(Bevanda bevanda);
    void setContorno(Contorno contorno);
}
