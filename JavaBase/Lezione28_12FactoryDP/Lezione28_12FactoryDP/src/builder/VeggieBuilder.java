package builder;

import products.PaninoVeggie;

public class VeggieBuilder implements Builder{
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

    public PaninoVeggie getResult() {
        return new PaninoVeggie(proteina,verdura,salsa);
    }
}
