
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // creo i thread
        PingPongTable table = new PingPongTable();
        Thread ping = new Thread(new Player("Ping", table));
        Thread pong = new Thread(new Player("Pong", table));

        pong.start();
        ping.start();
    }
}