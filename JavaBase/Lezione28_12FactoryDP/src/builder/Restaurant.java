package builder;

public class Restaurant {

    public void creaPaninoVeggie(Builder builder){
        builder.setProteina("Tofu");
        builder.setVerdura("Alga nori");
        builder.setSalsa("Wasabi");
    }
    public void creaPaninoCarne(Builder builder){
        builder.setProteina("Hamburger");
        builder.setVerdura("Pomodoro");
        builder.setSalsa("Maionese");
    }
}
