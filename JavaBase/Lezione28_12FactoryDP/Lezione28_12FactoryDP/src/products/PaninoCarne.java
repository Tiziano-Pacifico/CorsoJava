package products;

public class PaninoCarne implements Panino{

    private String proteina;
    private String verdura;
    private String salsa;

    public PaninoCarne(String proteina, String verdura, String salsa) {
        this.proteina = proteina;
        this.verdura = verdura;
        this.salsa = salsa;
    }

    public PaninoCarne() {}

    @Override
    public void prepara() {
        System.out.println("Panino carne pronto");
    }
    @Override
    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }
    @Override
    public String getVerdura() {
        return verdura;
    }

    public void setVerdura(String verdura) {
        this.verdura = verdura;
    }
    @Override
    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
