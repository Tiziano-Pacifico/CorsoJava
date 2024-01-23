public class ThreadContatore extends Thread{

    private Contatore contatore;

    public ThreadContatore(Contatore contatore) {
        System.out.println("Ciao sono il thread " + this.threadId());
        this.contatore = contatore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("sono: " + this.threadId());
            System.out.println(contatore.getValore());
            contatore.incrementa();
        }
    }
}
