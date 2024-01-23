import java.util.ArrayList;
import java.util.List;

public class Sportello extends  Thread{

    private Coda coda;
    private String nome;
    private List<Cliente> clientiServiti;
    private long totalServiceTime;
    private long waitingTime;

    public Sportello(Coda coda, String nome) {
        this.nome = nome;
        this.coda = coda;
        totalServiceTime = 0;
        waitingTime = 0;
        clientiServiti = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!coda.isTuttiClientiServiti()) {
            //System.out.printf("\n----%d---%d---\n", Main.clientsToServe, Main.servedClients);
            //System.out.printf("\n----%s----%s----\n\n", interrupted(), (coda.getClientsToServe() > coda.getServedClients()));
            Cliente cliente = coda.serviCliente();
            if (cliente != null) {
                clientiServiti.add(cliente);
                // Simula il servizio
                try {
                    waitingTime = (long) (Math.random() * 1000);
                    Thread.sleep(waitingTime);
                    totalServiceTime += waitingTime;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // Cliente servito
                System.out.printf("Servito cliente %s\n", cliente.getNome());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getClientiServiti() {
        return clientiServiti;
    }

    public long getTotalServiceTime() {
        return totalServiceTime;
    }

    public long getWaitingTime() {
        return waitingTime;
    }
}
