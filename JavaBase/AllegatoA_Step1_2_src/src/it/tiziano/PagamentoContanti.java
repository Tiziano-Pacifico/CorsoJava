package it.tiziano;

public class PagamentoContanti extends Pagamento{

    public PagamentoContanti(double importo) {
        super(importo);
    }

    public PagamentoContanti() {
        this.importo = 0.0;
    }

    @Override
    public void dettagliPagamento() {
        System.out.println("Il pagamento è in contanti per l'importo di : " + this.getImporto());
    }
}
