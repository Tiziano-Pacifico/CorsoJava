package builder.menuComponents.contorni;

import products.menuComponents.contorni.ContornoStella;

public class ContorniStellaBuilder implements ContorniBuilder{

    private String dressing, verdura;
    @Override
    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }

    public ContornoStella getResult() {
        return new ContornoStella(verdura, dressing);
    }
}
