package products.menuComponents.panini;

public class PaninoSole implements Panino{

    String proteina, verdura, salsa;

    public PaninoSole(){}

    public PaninoSole(String proteina, String verdura, String salsa) {
        this.proteina = proteina;
        this.verdura = verdura;
        this.salsa = salsa;
    }

    @Override
    public void prepara() {

    }

    @Override
    public String getProteina() {
        return proteina;
    }

    @Override
    public String getVerdura() {
        return verdura;
    }

    @Override
    public String getSalsa() {
        return salsa;
    }
}
