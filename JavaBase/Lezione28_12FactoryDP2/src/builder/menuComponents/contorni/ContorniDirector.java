package builder.menuComponents.contorni;

public class ContorniDirector {

    public void creaContornoSole(ContorniBuilder contornoBuilder) {
        System.out.println("Creo patate fritte e ketchup");
        contornoBuilder.setVerdura("Patate fritte");
        contornoBuilder.setDressing("Ketchup");
    }

    public void creaContornoStella(ContorniBuilder contornoBuilder){
        System.out.println("Creo lattuga e dressing francese");
        contornoBuilder.setVerdura("Lattuga");
        contornoBuilder.setDressing("Francese");
    }

    public void creaContornoLuna(ContorniBuilder contornoBuilder) {
        System.out.println("Creo broccoli in salsa aioli");
        contornoBuilder.setVerdura("Broccoli");
        contornoBuilder.setDressing("Aioli");
    }
}
