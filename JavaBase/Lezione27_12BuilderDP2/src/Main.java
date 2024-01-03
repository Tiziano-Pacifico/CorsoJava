import Classi.Car;

//Implementiamo il builder all'interno della classe Car
public class Main {
    public static void main(String[] args) {

        Car.Builder builder = new Car.Builder();
        Car auto1 = builder.setAlimentazione('b').setColore("giallo").setMarca("Fiat").setModello("Punto").build();

        System.out.println(auto1.toString());
    }
}