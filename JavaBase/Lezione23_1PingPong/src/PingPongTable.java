public class PingPongTable {

    // decidere di chi e' il turno per giocare
    // guado e' true gioca "ping"
    private boolean isPingTurno = true;
    // creo il metodo play (gestione gioco)
    public synchronized void play(String player){
        // se e' vera la condizione: gioca Ping

        try {
            while(player.equals("Ping") && !isPingTurno || player.equals("Pong") && isPingTurno) {
                // quando chiamo il giocatore verifico il suo turno.
                // Se non e' il suo turno viene messo in attesa (il thread)
                // e non puo' continuare
                wait();
            }
            System.out.println(player);
            isPingTurno = !isPingTurno;
            notify();
            // notifica ad altro thread che il giocatre ha terminato i giocare
        } catch (InterruptedException e) {
            System.out.println("Eccezione: " + e.getMessage());
        }

    }
}
