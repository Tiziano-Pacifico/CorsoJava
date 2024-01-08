package builder.menuComponents.contorni;

import products.menuComponents.contorni.ContornoSole;

public class ContorniSoleBuilder implements ContorniBuilder{

    private String dressing, verdura;
    @Override
    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }

    public ContornoSole getResult() {
        return new ContornoSole(verdura, dressing);
    }
}
