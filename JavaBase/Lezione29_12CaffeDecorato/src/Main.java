import oggetti.Bevanda;
import utils.Costanti;
import utils.Director;

import java.util.Collection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Vogliamo costruire un programma che si occupa della gestione di una macchina del caffè.
        Il programma dovrà gestire la composizione del caffè o del te in base all'ordine
        E dovrà gestire il prezzo finale da chiedere al cliente.
        Il programma userà il PAttern Decorator. Avremo un'interfaccia Bevanda e una classe BevandaDecorata che implementa Bevanda.
        Avremo un oggetto Caffe e un oggetto The che implementano Bevanda che eriditano i due metodi dall'interfaccia: prepara() e calcolaCosto().
        Useremo una classe Director che si occuperà della gestione dei ConcreteDecorator, utilizzando un approccio visto nel Builder Decorator.
        Il Director in particolare si occuperà della corretta sequenza dei Decorator da applicare.
         */

        int scelta_bevanda, scelta_zucchero, quantità_zucchero;
        boolean isZucchero;


        Scanner scanner = new Scanner(System.in);

        Bevanda bevanda;
        Director director = new Director();

        System.out.println("Scegli il tuo caffè: ");
        System.out.println("1) Caffe\n2) Caffè lungo\n3) Caffellatte\n4) Cappuccino\n5) Marocchino\n6) The\n7) The con latte\n8) The speziato");
        scelta_bevanda = scanner.nextInt();
        System.out.println();
        //Il caffè marocchino è sempre zuccherato
        if (scelta_bevanda != Costanti.CAFFE_MAROCCHINO) {
            System.out.println("Vuoi zucchero?:\n1) Si\n2) No");
            scelta_zucchero = scanner.nextInt();
        }
        else scelta_zucchero = 2;

        isZucchero = (scelta_zucchero == 1) ? true : false;

        if(isZucchero | scelta_bevanda == Costanti.CAFFE_MAROCCHINO) {
            System.out.println("Quanto zucchero da 1 a 5?");
            quantità_zucchero = scanner.nextInt();
        }
        else quantità_zucchero = 0;

        bevanda = director.preparaBevanda(scelta_bevanda, isZucchero, quantità_zucchero);
        System.out.println(bevanda.prepara());
        System.out.printf("Inserire %.1f euro", bevanda.calcolaCosto());
    }
}