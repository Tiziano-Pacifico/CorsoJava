package it.tiziano;

public class DatiPAgamento {

    Fattura fattura;
    Pagamento pagamento;

    public DatiPAgamento(){
        fattura = new Fattura();
        pagamento = new Pagamento();
    }

    public DatiPAgamento(Fattura fattura, Pagamento pagamento) {
        this.pagamento = pagamento;
        this.fattura = fattura;
    }

    public Fattura getFattura() {
        return fattura;
    }

    public void setFattura(Fattura fattura) {
        this.fattura = fattura;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
