import factories.BeefFactory;
import factories.PaninoFactory;
import factories.VeggieFactory;
import products.Panino;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static PaninoFactory factory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int scelta;
        Panino panino;

        System.out.println("Vuoi un panino: 1-carne ; 2-vegetariano?");
        scelta = scanner.nextInt();
        if(scelta==1) {
            factory = new BeefFactory();
        }
        else {
            factory = new VeggieFactory();
        }

        panino = factory.creaPanino();
        System.out.println("Lista ingredienti del panino");
        System.out.printf("PAnino con: %s, %s, %s", panino.getProteina(), panino.getVerdura(), panino.getSalsa());
    }
}