package classi;

import enumerazioni.Farciture;
import enumerazioni.Formaggi;
import enumerazioni.Pizze;
import enumerazioni.Pomodoro;
import interfacce.PizzaBuilder;

import java.util.ArrayList;

public class Pizza {

    private Pizze base;
    private Formaggi formaggio;
    private Pomodoro pomodoro;
    private ArrayList<Farciture> farcitura;

    public Pizza() {}

    @Override
    public String toString() {
        return "Pizza{" +
                "base=" + base +
                ", formaggio=" + formaggio +
                ", pomodoro=" + pomodoro +
                ", farcitura=" + farcitura +
                '}';
    }

    public Pizze getBase() {
        return base;
    }

    public void setBase(Pizze base) {
        this.base = base;
    }

    public Formaggi getFormaggio() {
        return formaggio;
    }

    public void setFormaggio(Formaggi formaggio) {
        this.formaggio = formaggio;
    }

    public Pomodoro getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public ArrayList<Farciture> getFarcitura() {
        return farcitura;
    }

    public void setFarcitura(Farciture farcitura) {
        this.farcitura.add(farcitura);
    }

    public static class Builder implements PizzaBuilder {
        private Pizze base;
        private Formaggi formaggio;
        private Pomodoro pomodoro;
        private ArrayList<Farciture> farcitura;

        @Override
        public PizzaBuilder setBase(Pizze base) {
            this.base = base;
            return this;
        }

        @Override
        public PizzaBuilder setFormaggio(Formaggi formaggio) {
            this.formaggio = formaggio;
            return this;
        }

        @Override
        public PizzaBuilder setPomodoro(Pomodoro pomodoro) {
            this.pomodoro = pomodoro;
            return this;
        }

        @Override
        public PizzaBuilder setFarcitura(ArrayList<Farciture> farcitura) {
            this.farcitura = farcitura;
            return this;
        }

        @Override
        public Pizza build() {

            Pizza pizza = new Pizza();
            pizza.base = base;
            pizza.farcitura = farcitura;
            pizza.formaggio = formaggio;
            pizza.pomodoro = pomodoro;

            return pizza;
        }
    }
}
