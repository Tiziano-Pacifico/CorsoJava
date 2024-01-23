public class Player implements Runnable{
    private String nome;
    private PingPongTable table;

    // Costruttore
    public Player(String nome, PingPongTable table) {
        this.nome = nome;
        this.table = table;
    }

    @Override
    public void run() {
        // il giocatore gioca per 10 volte
        for(int i = 0; i < 10; i++){
            table.play(nome);
        }
    }
}
