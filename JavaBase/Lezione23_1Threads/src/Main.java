
public class Main {
    public static void main(String[] args) {

        Contatore contatore = new Contatore();

        ThreadContatore[] threadPool = new ThreadContatore[3];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new ThreadContatore(contatore);
            threadPool[i].start();

        }

        System.out.println("Sono main");
        for (int i = 0; i < threadPool.length; i++) {
            try {
                threadPool[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Valore del contatore: " + contatore.getValore());
    }

}