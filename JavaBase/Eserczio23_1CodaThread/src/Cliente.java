import java.util.function.DoubleToIntFunction;

public class Cliente extends Thread{

    private Coda coda;
    private String nome;

    public Cliente(Coda coda, String nome) {
        this.nome = nome;
        this.coda = coda;
    }

    @Override
    public void run() {
        // Simula l'arrivo casuale del cliente
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        coda.aggiungiCliente(this);
    }

    public String getNome() {
        return nome;
    }
}
