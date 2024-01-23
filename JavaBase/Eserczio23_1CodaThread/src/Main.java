import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        int numeroClienti = 10;
        int numeroSportelli = 3;

        Cliente[] clienti = new Cliente[numeroClienti];
        Sportello[] sportelli = new Sportello[numeroSportelli];
        Coda coda = new Coda(numeroClienti);

        String[] nomi = {"Luca", "Marco", "Giulia", "Francesca", "Matteo", "Sofia", "Alessandro", "Maria", "Giovanni", "Anna"};


        for (int i = 0; i < numeroSportelli; i++) {
            sportelli[i] = new Sportello(coda, "sportello_" + i);
            sportelli[i].start();
        }

        for (int i = 0; i < 10; i++) {
            clienti[i] = new Cliente(coda, nomi[i]);
            clienti[i].start();
        }

        for(Cliente threadCliente: clienti) {
            try {
                threadCliente.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Tutti i clienti sono stati aggiunti alla coda");

        for (Sportello threadSportello: sportelli) {
            try {
                threadSportello.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("tutti gli sportelli sono stati chiusi");
        System.out.println("\n------------------\n\n");
        for (Sportello threadSportello: sportelli) {
            System.out.printf("Lo sportello %s ha servito i seguenti clienti: \n",threadSportello.getNome());
            for(Cliente clienteServito: threadSportello.getClientiServiti()) {
                System.out.println(clienteServito.getNome());
            }
            System.out.println("Tempo totale impiegatoper servire i clienti: ");
            System.out.println(threadSportello.getTotalServiceTime());
            System.out.println("----------------------------");

        }
    }
}