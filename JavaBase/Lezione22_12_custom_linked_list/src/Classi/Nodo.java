package Classi;

public class Nodo {

    private int object;
    private Nodo next;

    public Nodo(int object, Nodo next) {
        this.object =object;
        this.next = null;
    }


    public int getObject() {
        return object;
    }

    public void setObject(int object) {
        this.object = object;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
