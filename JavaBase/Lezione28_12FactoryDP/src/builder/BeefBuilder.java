package builder;

import products.PaninoCarne;
import products.PaninoVeggie;

public class BeefBuilder implements Builder{

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

    public PaninoCarne getResult() {
        return new PaninoCarne(proteina,verdura,salsa);
    }
}
