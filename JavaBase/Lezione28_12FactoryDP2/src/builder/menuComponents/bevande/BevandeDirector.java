package builder.menuComponents.bevande;

public class BevandeDirector {

    public void creaBevandaSole(BevandeBuilder bevandaBuilder) {
        System.out.println("Creo bevanda con limine e cola");
        bevandaBuilder.setAggiunta("Limone");
        bevandaBuilder.setLiquido("Cola");
    }

    public void creaBevandaLuna(BevandeBuilder bevandaBuilder) {
        System.out.println("Creo bevanda con aranciata e arancia");
        bevandaBuilder.setLiquido("Aranciata");
        bevandaBuilder.setAggiunta("Arancia");
    }

    public void creaBevandaStella(BevandeBuilder bevandaBuilder) {
        System.out.println("creo bevanda con tonica e lime");
        bevandaBuilder.setLiquido("Acqua tonica");
        bevandaBuilder.setAggiunta("Lime");
    }
}
