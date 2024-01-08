package products.menuComponents.contorni;

public class ContornoStella implements Contorno{

    private String verdura,dressing;

    public ContornoStella(){}

    public ContornoStella(String verdura, String dressing) {
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
