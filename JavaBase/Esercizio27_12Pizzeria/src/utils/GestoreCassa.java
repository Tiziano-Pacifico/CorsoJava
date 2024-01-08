package utils;

import classi.Pizza;
import classi.Prezzi;
import classi.Tavoli;
import classi.Tavolo;
import enumerazioni.Farciture;

public class GestoreCassa {

    private Tavoli listaTavoli;
    private Prezzi listino;

    public GestoreCassa(Tavoli listaTavoli, Prezzi listino) {
        this.listaTavoli = listaTavoli;
        this.listino = listino;
    }

    public Tavoli getListaTavoli() {
        return listaTavoli;
    }

    public void setListaTavoli(Tavoli listaTavoli) {
        this.listaTavoli = listaTavoli;
    }

    public Prezzi getListino() {
        return listino;
    }

    public void setListino(Prezzi listino) {
        this.listino = listino;
    }

    public int calcolaTotaleTavolo(int nrTavolo) {

        Tavolo tavolo = listaTavoli.getListaTavoli().get(nrTavolo);
        int totale = 0;
        for(Pizza pizza: tavolo.getListaPizzeOrdinate()) {

            if(pizza.getFarcitura()!=null) {
                for(int i = 0; i < pizza.getFarcitura().size(); i++) {
                    System.out.println("farc " + pizza.getFarcitura().get(i) + " " + listino.getPrezziFarciture().get(pizza.getFarcitura().get(i)));
                    totale += listino.getPrezziFarciture().get(pizza.getFarcitura().get(i));
                }
            }

            if(pizza.getFormaggio()!=null) {
                System.out.println("form " + pizza.getFormaggio() + " " + listino.getPrezziFormaggi().get(pizza.getFormaggio()));
                totale += listino.getPrezziFormaggi().get(pizza.getFormaggio());
            }

            if(pizza.getPomodoro()!=null) {
                System.out.println("pom " +pizza.getPomodoro() + " " + listino.getPrezziPomodoro().get( pizza.getPomodoro()));
                totale += listino.getPrezziPomodoro().get(pizza.getPomodoro());
            }
            System.out.println("pizza " + pizza.getBase() + " " + listino.getPrezziPizze().get(pizza.getBase()));
            totale += listino.getPrezziPizze().get(pizza.getBase());
        }

        return totale;
    }
}
