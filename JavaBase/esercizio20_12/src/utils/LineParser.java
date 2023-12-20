package utils;

import Strutture.OutputFormat;
import Strutture.Persona;

/**
 * Classe che si occupa del parsing della riga di testo per consentire la futura formattazione
 * contiene il metodo parseLine
 */
public class LineParser {

    /**
     * Il metodo prende in input una stringa. La stringa contiene diversi campi ognuno separata da ;
     * Ogni campo verrà estrsatto e inserito nel relativo attributo della classe persona.
     * @param line: La stringa di testo di cui effettuare il parsing
     * @return: un oggetto persona i cui attributi saranno estratti dalla stringa in input
     */
    public Persona parseLine(String line) {

        String[] splittedLine = line.split(":");

        String nome = "", cognome = "", id = "", account = "", ruolo = "";

        for(int i = 0; i < splittedLine.length; i++){
            switch (i){
                case Costanti.NOME:
                    nome = splittedLine[i];
                    break;
                case Costanti.COGNOME:
                    cognome = splittedLine[i];
                    break;
                case Costanti.ID:
                    id  = splittedLine[i];
                    break;
                case Costanti.ACCOUNT:
                    account = splittedLine[i];
                    break;
                case Costanti.RUOLO:
                    ruolo = splittedLine[i];
                    break;
            }
        }
        return new Persona(nome,cognome,id,account,ruolo);
    }


}
