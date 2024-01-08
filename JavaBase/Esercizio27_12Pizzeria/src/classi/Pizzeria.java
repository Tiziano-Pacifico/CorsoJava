package classi;

public class Pizzeria {

    private Tavoli tavoli;

    public Pizzeria() {
        tavoli = Tavoli.createTavoli();
    }

    public Tavoli getTavoli() {
        return tavoli;
    }

    public void setTavoli(Tavoli tavoli) {
        this.tavoli = tavoli;
    }
}
