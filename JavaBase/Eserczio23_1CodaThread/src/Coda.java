import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Coda {

    private Queue<Cliente> coda;
    private int clientsToServe;
    private int servedClients;
    private boolean tuttiClientiServiti = false;

    public Coda(int clientsToServe) {
        this.clientsToServe = clientsToServe;
        coda = new LinkedList<>();
        servedClients = 0;
    }

    public synchronized void aggiungiCliente(Cliente cliente) {
        coda.offer(cliente);
        System.out.printf("Aggiunto cliente %s alla coda\n", cliente.getNome());
        notify(); // Notifica gli sportelli che un nuovo cliente è disponibile

    }

    public synchronized Cliente serviCliente() {
        while (coda.isEmpty()) {
            try {
                wait(); // Aspetta finché non ci sono clienti in coda
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        servedClients += 1;
        if(servedClients >= clientsToServe) {
            tuttiClientiServiti = true;

        }
        return coda.poll();
    }

    public Queue<Cliente> getCoda() {
        return coda;
    }

    public int getClientsToServe() {
        return clientsToServe;
    }

    public int getServedClients() {
        return servedClients;
    }

    public boolean isTuttiClientiServiti() {
        return tuttiClientiServiti;
    }
}
