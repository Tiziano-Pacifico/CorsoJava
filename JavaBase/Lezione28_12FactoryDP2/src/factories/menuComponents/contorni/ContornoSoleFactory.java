package factories.menuComponents.contorni;

import builder.menuComponents.contorni.ContorniDirector;
import builder.menuComponents.contorni.ContorniLunaBuilder;
import builder.menuComponents.contorni.ContorniSoleBuilder;
import products.menuComponents.contorni.Contorno;

public class ContornoSoleFactory extends ContorniFactory{

    private ContorniDirector cd = new ContorniDirector();
    private ContorniSoleBuilder csb = new ContorniSoleBuilder();


    @Override
    public Contorno creaContorno() {
        System.out.println("Creato contorno sole");
        cd.creaContornoSole(csb);
        return csb.getResult();
    }

}
