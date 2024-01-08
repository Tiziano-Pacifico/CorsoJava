package utils;

import classi.Pizza;
import enumerazioni.Farciture;
import enumerazioni.Formaggi;
import enumerazioni.Pizze;
import enumerazioni.Pomodoro;
import interfacce.PizzaBuilder;

import java.util.ArrayList;
import java.util.Random;

public class RandomPizza {

    Random random = new Random();

    Farciture[] farciture = Farciture.values();
    Farciture farcitura;
    Formaggi[] formaggi = Formaggi.values();
    Pizze[] pizze = Pizze.values();
    Pomodoro[] pomodori = Pomodoro.values();

    ArrayList<Farciture> listaFarciture;
    Formaggi formaggio;
    Pizze pizza;
    Pomodoro pomodoro;

    Pizza.Builder builder = new Pizza.Builder();
    public Pizza createRandomPizza() {

        pizza = pizze[random.nextInt(pizze.length)];

        if(random.nextDouble() > 0.5) {
            int nrFarciture = random.nextInt(5) + 1;
            int farcitureInserite = 0;


            listaFarciture = new ArrayList<>();
            while(farcitureInserite <= nrFarciture) {
                farcitura = farciture[random.nextInt(farciture.length)];

                if(!listaFarciture.contains(farcitura)) {
                    listaFarciture.add(farcitura);
                    farcitureInserite++;
                }
            }
            builder.setFarcitura(listaFarciture);
        }
        if(random.nextDouble() > 0.5) {
            ;
            builder.setFormaggio(formaggi[random.nextInt(formaggi.length)]);
        }
        if(random.nextDouble( ) > 0.5) {
            pomodoro =   pomodori[random.nextInt(pomodori.length)];
            builder.setPomodoro(pomodoro);
        }

        Pizza nuovaPizza = builder.
                setBase(pizza).
                build();

        return nuovaPizza;

    }
}
