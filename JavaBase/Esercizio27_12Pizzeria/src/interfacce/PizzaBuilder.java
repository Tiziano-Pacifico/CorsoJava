package interfacce;

import classi.Pizza;
import enumerazioni.Farciture;
import enumerazioni.Formaggi;
import enumerazioni.Pizze;
import enumerazioni.Pomodoro;

import java.util.ArrayList;

public interface PizzaBuilder {

    PizzaBuilder setBase(Pizze base);

    PizzaBuilder setFormaggio(Formaggi formaggio);

    PizzaBuilder setPomodoro(Pomodoro pomodoro);

    PizzaBuilder setFarcitura(ArrayList<Farciture> farcitura);

    Pizza build();
    
}
