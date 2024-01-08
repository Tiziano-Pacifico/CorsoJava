package factories.menuComponents.contorni;

import builder.menuComponents.contorni.ContorniDirector;
import builder.menuComponents.contorni.ContorniLunaBuilder;
import products.menuComponents.contorni.Contorno;

public class ContornoLunaFactory extends ContorniFactory{

    private ContorniDirector cd = new ContorniDirector();
    private ContorniLunaBuilder clb = new ContorniLunaBuilder();


    @Override
    public Contorno creaContorno() {
        System.out.println("Creato contorno luna");
        cd.creaContornoLuna(clb);
        return clb.getResult();
    }

}
