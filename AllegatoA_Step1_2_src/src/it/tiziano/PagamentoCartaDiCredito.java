package it.tiziano;

public class PagamentoCartaDiCredito extends Pagamento{

    String nomeCarta;
    String dataScadenza;
    String numeroCarta;

    public PagamentoCartaDiCredito(double importo, String nomeCarta, String dataScadenza, String numeroCarta) {
        super(importo);
        this.nomeCarta = nomeCarta;
        this.dataScadenza = dataScadenza;
        this.numeroCarta = numeroCarta;
    }

    @Override
    public void dettagliPagamento() {
        System.out.println("Carta n: " + this.getNumeroCarta() + "Nome sulla carta " + this.getNomeCarta() + "Data scadenzza: " + this.getDataScadenza() + "Importo: " + this.getImporto());
    }


    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }
}
