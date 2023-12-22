package Utils;

import Classi.Nodo;
import Classi.Testa;

import Enum.Mode;

public class Lista {

    private Testa head;


    public Lista() {
        this.head = new Testa();
    }

    public void aggiungiNodo(int dato){
        Nodo current = head.getFirst();

        if (current == null){
            System.out.println("La lista è vuota aggiungo il primo nodo");
            current = new Nodo(dato, null);
            head.setFirst(current);;
        }
        else {
            System.out.println("La lista non è vuota, aggiungo un nodo in coda");


            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new Nodo(dato, null));

        }
    }

    public void stampaLista() {
        Nodo current = head.getFirst();

        if(current == null) {
            System.out.println("La lista è vuota");
        }
        else {
            int i = 0;
            while(current.getNext() != null) {
                System.out.println("Nodo n: " + ++i + " ha dato: " + current.getObject());
                current = current.getNext();
            }
            System.out.println("Nodo n: " + ++i + " ha dato: " + current.getObject());
        }
    }

    public void eliminaNodo(int valore, Mode mode) {

        Nodo current = head.getFirst();

        if(current == null) {
            System.out.println("La lista è vuota, non posso cancellare nulla");
        }
        else
            if(current.getNext() == null && (current.getObject() == valore) ) {
                System.out.println("La lista ha un solo elemento, dopo la cancellazione la lista è vuota");
                head = new Testa();
            }
            else {
                switch (mode) {
                    case Mode.FIRST:
                        System.out.println("Elimino il primo nodo con valore :" + valore);
                        boolean trovato = false;
                        Nodo prev = null;
                        while(current != null && !trovato) {

                            System.out.println("Current: " + current.getObject());
                            if (current.getObject() == valore) {
                                if(prev == null) {
                                    System.out.println("Valore trovato in testa alla lista");
                                    head.setFirst(current.getNext());
                                    trovato = true;
                                } else {
                                    System.out.println("Valore trovato internamente alla lista");
                                    prev.setNext(current.getNext());
                                    trovato = true;
                                }
                            }
                            prev = current;
                            current = current.getNext();

                        }
                        break;

                    case Mode.TOTAL:
                        System.out.println("Elimino tutti i nodi con valore :" + valore);

                        Nodo prevTotal = null;
                        while(current != null) {

                            System.out.println("Current: " + current.getObject());
                            if (current.getObject() == valore) {
                                if(prevTotal == null) {
                                    System.out.println("Valore trovato in testa alla lista");
                                    head.setFirst(current.getNext());
                                } else {
                                    System.out.println("Valore trovato internamente alla lista");
                                    prevTotal.setNext(current.getNext());
                                }
                            }
                            prevTotal = current;
                            current = current.getNext();

                        }
                        break;

                    case Mode.LAST:

                        System.out.println("Elimino l'ultimo elemento con valore: " + valore);

                        Nodo last = null;
                        Nodo prevLast = null;

                        while(current != null) {
                            System.out.println("Current: " + current.getObject());
                            if (current.getObject() == valore) {
                              if(prevLast != null) {

                                  last = prevLast;
                              }
                            }
                            prevLast = current;
                            current = current.getNext();
                        }

                        if (prevLast == null) {
                            head.setFirst(head.getFirst().getNext());
                        }
                        else {
                            last.setNext(last.getNext().getNext());
                        }
                        break;
                }


            }
    }

    public void stampaNodoPosizione(int posizione){
        int i = 0;
        Nodo current = head.getFirst();
        if (lunghezzaLista() == 0) {
            System.out.println("La lista è vuota");
        }
        else {
            while(i < posizione && current != null){
                i++;
                current = current.getNext();
            }
        }

        if (current == null) {
            System.out.println("La lista non contiene l'indice");
        }
        else {
            System.out.println("L'elemento in posizione " + posizione + " ha valore: " + current.getObject());
        }

    }


    public void  stampaNodoValore(int valore) {
        Nodo current = head.getFirst();
        boolean trovato = false;
        int i = 0;

        if (lunghezzaLista() == 0) {
            System.out.println("La lista è vuota");
        }
        else {
            while(current != null && !trovato) {
                if(current.getObject() == valore) {
                    trovato = true;
                }
                else {
                    i++;
                    current = current.getNext();
                }
            }
        }
        if(trovato) {
            System.out.println("Elemento " + valore + " trovato in posizione " + i);
        }
    }

    public int lunghezzaLista() {
        int i = 0;
        Nodo current = head.getFirst();;

        while (current != null) {
            current = current.getNext();
            i++;
        }

        return i;
    }
}
