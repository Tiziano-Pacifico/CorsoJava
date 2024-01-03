import Classi.Car;
import utils.CarBuilder;
import utils.CarBuilderImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CarBuilder builder = new CarBuilderImpl();
        builder.setMarca("Fiat");
        builder.setModello("Punto");
        builder.setColore("rosso").setNrPorte(4).setNavigatore(false);

        Car autoA = builder.build();
        System.out.println(autoA);
    }
}