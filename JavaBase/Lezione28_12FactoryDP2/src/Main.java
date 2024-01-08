import factories.menu.MenuFactory;
import factories.menu.MenuLunaFactory;
import factories.menu.MenuSoleFactory;
import factories.menu.MenuStellaFactory;
import products.menu.Menu;

import java.util.Scanner;

/*
Creiamo una applicazione che gestisce la vendita di diversi tipi di panini, bibite e contorni
Usare il pattern Abstract Factory
 */
public class Main {

    public static MenuFactory factory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;
        Menu menu;

        System.out.println("Che menù vuoi?: 1-Sole; 2-Luna; 3-Stella");
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                factory = new MenuSoleFactory();
                break;
            case 2:
                factory = new MenuLunaFactory();
                break;
            case 3:
                factory= new MenuStellaFactory();
                break;
        }
        menu = factory.creaMenu();

    }
}