package builder.menuComponents.panini;

import products.menuComponents.panini.PaninoStella;

public class PaniniStellaBuilder implements PaniniBuilder{

    private String proteina, verdura, salsa;
    @Override
    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    @Override
    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }

    @Override
    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public PaninoStella getResult() {
        return new PaninoStella(proteina, verdura, salsa);
    }
}
