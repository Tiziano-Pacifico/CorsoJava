package builder.menuComponents.contorni;

import products.menuComponents.contorni.ContornoLuna;

public class ContorniLunaBuilder implements ContorniBuilder{

    private String dressing, verdura;
    @Override
    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    @Override
    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }

    public ContornoLuna getResult() {
        return new ContornoLuna(verdura, dressing);
    }
}
