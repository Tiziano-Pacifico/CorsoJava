package products.menuComponents.contorni;

public class ContornoLuna implements Contorno{

    private String verdura,dressing;

    public ContornoLuna(){}

    public ContornoLuna(String verdura, String dressing) {
        this.verdura = verdura;
        this.dressing = dressing;
    }

    @Override
    public void prepara() {

    }

    @Override
    public String getVerdura() {
        return this.verdura;
    }

    @Override
    public String getDressing() {
        return this.dressing;
    }
}
