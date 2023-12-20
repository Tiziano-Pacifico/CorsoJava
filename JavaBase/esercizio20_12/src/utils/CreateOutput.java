package utils;

import Strutture.OutputFormat;
import Strutture.Persona;

/**
 * Partendo dal parsing dei dati effettuato nella struttura dati Persona, estraggo e rielaboro gli attriburi per restituire una struttura dati
 * OutputFormat con i dati rielaborati per essere salvati
 */
public class CreateOutput {
    final private String dominio = "@acer.it";

    /**
     * Il metodo prende in input una persona e rielabora i suoi attributi per formare un oggetto OutputFormat che contiene la formattazione richiesta dall'esercizio
     * @param p: l'oggetto persona che si vuole rielaborare
     * @return un oggetto OutputFormat
     */
    public OutputFormat createOutLine(Persona p) {
        return new OutputFormat(p.getNome(), p.getCognome(), p.getNome() + dominio);
    }
}
