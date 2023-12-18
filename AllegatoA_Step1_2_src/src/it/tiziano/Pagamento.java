package it.tiziano;

public class Pagamento {

    Double importo;

    public Pagamento(Double  importo) {
        this.importo = importo;
    }

    public Pagamento() {
        this.importo = 0.0;
    }

    public void dettagliPagamento() {
        System.out.println("Il pagamento è di :" + this.getImporto());
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }
}
