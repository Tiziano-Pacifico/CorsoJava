//Singleton Design Pattern
public class Main {
    public static void main(String[] args) {

        Singleton s = Singleton.createClass();
        s.setValue("Sono la prima istanza della classe");

        Singleton s1 = Singleton.createClass();
        s1.setValue("Sono la seconda istanza della classe");
        System.out.println(s.getValue());
        System.out.println(s1.getValue());
    }
}