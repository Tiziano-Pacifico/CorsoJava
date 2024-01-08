package classi;

import enumerazioni.Farciture;
import enumerazioni.Formaggi;
import enumerazioni.Pizze;
import enumerazioni.Pomodoro;

import java.util.HashMap;
import java.util.Random;

public class Prezzi {


    private Random random = new Random();
    private HashMap<Farciture, Integer> prezziFarciture = new HashMap<>();
    private HashMap<Formaggi, Integer> prezziFormaggi = new HashMap<>();
    private HashMap<Pizze, Integer> prezziPizze = new HashMap<>();
    private HashMap<Pomodoro, Integer> prezziPomodoro = new HashMap<>();

    public Prezzi() {
        for(Farciture farcitura: Farciture.values()) {
            prezziFarciture.put(farcitura, random.nextInt(5) + 1);
        }
        for(Formaggi formaggio: Formaggi.values()) {
            prezziFormaggi.put(formaggio, random.nextInt(4)+1);
        }
        for(Pizze pizza: Pizze.values()) {
            prezziPizze.put(pizza, random.nextInt(11)+5);
        }
        for (Pomodoro pomodoro : Pomodoro.values()) {
            prezziPomodoro.put(pomodoro, 1);
        }
    }
    public HashMap<Farciture, Integer> getPrezziFarciture() {
        return prezziFarciture;
    }

    public void setPrezziFarciture(HashMap<Farciture, Integer> prezziFarciture) {
        this.prezziFarciture = prezziFarciture;
    }

    public HashMap<Formaggi, Integer> getPrezziFormaggi() {
        return prezziFormaggi;
    }

    public void setPrezziFormaggi(HashMap<Formaggi, Integer> prezziFormaggi) {
        this.prezziFormaggi = prezziFormaggi;
    }

    public HashMap<Pizze, Integer> getPrezziPizze() {
        return prezziPizze;
    }

    public void setPrezziPizze(HashMap<Pizze, Integer> prezziPizze) {
        this.prezziPizze = prezziPizze;
    }

    public HashMap<Pomodoro, Integer> getPrezziPomodoro() {
        return prezziPomodoro;
    }

    public void setPrezziPomodoro(HashMap<Pomodoro, Integer> prezziPomodoro) {
        this.prezziPomodoro = prezziPomodoro;
    }
}
