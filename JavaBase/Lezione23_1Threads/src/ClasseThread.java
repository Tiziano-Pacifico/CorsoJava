public class ClasseThread extends Thread{

    @Override
    public void run() {
        System.out.println("saluti dal thread: " + this.getName());
        System.out.println("Ho il numero: " + this.getId());
        System.out.println("Ho priorità: " +this.getPriority());
        System.out.println("Sono nello stato " + this.getState());
    }
}
