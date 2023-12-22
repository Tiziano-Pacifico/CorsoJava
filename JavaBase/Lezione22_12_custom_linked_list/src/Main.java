//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//Strutture dati: LinkedList

import Utils.Lista;

import Enum.Mode;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Lista l1 = new Lista();
        System.out.println(l1.lunghezzaLista());

        l1.aggiungiNodo(3);
        l1.aggiungiNodo(1);
        l1.aggiungiNodo(2);
        l1.aggiungiNodo(3);
        l1.stampaLista();

        l1.stampaNodoPosizione(2);
        l1.stampaNodoValore(2);
        System.out.println(l1.lunghezzaLista());

        l1.eliminaNodo(3, Mode.LAST);
        l1.stampaLista();
        System.out.println(l1.lunghezzaLista());
        /*
        l1.eliminaNodo(3, Mode.FIRST);
        l1.stampaLista();
        l1.eliminaNodo(1, Mode.FIRST);
        l1.stampaLista();
        l1.eliminaNodo(2, Mode.FIRST);
        l1.stampaLista();

         */
    }
}