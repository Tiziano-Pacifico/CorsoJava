package builder.menuComponents.panini;

public class PaniniDirector {

    public void creaPaninoSole(PaniniBuilder paninoBuilder) {
        System.out.println("Creo panino hamburger, salsa greca e insalata");
        paninoBuilder.setProteina("Hamburger");
        paninoBuilder.setSalsa("Greca");
        paninoBuilder.setVerdura("Insalata");
    }

    public void creaPaninoLuna(PaniniBuilder paninoBuilder) {
        System.out.println("Creo panino con formaggio, pomodoro e salsa rosa");
        paninoBuilder.setProteina("Formaggio");
        paninoBuilder.setVerdura("Pomodoro");
        paninoBuilder.setSalsa("Rosa");
    }

    public void creaPaninoStella(PaniniBuilder paninoBuilder) {
        System.out.println("Creo panino con salmone cetriolo e maionese");
        paninoBuilder.setProteina("salmone");
        paninoBuilder.setVerdura("Cetriolo");
        paninoBuilder.setSalsa("Maionese");
    }
}
