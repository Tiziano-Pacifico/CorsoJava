package factories.menuComponents.contorni;

import builder.menuComponents.contorni.ContorniDirector;
import builder.menuComponents.contorni.ContorniLunaBuilder;
import builder.menuComponents.contorni.ContorniStellaBuilder;
import products.menuComponents.contorni.Contorno;

public class ContornoStellaFactory extends ContorniFactory{

    private ContorniDirector cd = new ContorniDirector();
    private ContorniStellaBuilder cstb = new ContorniStellaBuilder();


    @Override
    public Contorno creaContorno() {
        System.out.println("Creato contorno stella");
        cd.creaContornoStella(cstb);
        return cstb.getResult();
    }

}
