package utils;

import Classi.Libro;

public class Ricerca {

    int lunghezzaArray;

    public int ricercaPerTitolo(Libro[] array, String titoloDaCercare) {

        lunghezzaArray = array.length;
        int i = 0;


        while(i < lunghezzaArray && !array[i].getTitolo().equalsIgnoreCase(titoloDaCercare)) i++;

        return (i >= lunghezzaArray) ? -1 : i;
    }

    public String trovaSottostringaTitolo(String titolo, String pattern) {
        int textTitolo = titolo.length();
        int textPattern = pattern.length();

        if (textPattern <= textTitolo) {
            int lunghezzaIterazione = textTitolo-textPattern;
            for(int i = 0; i < lunghezzaIterazione; i++) {
                String sottoStringa = titolo.substring(i,i+textPattern);
                if(sottoStringa.equalsIgnoreCase(pattern)) {
                    return titolo;
                }
            }
        }
        return null;
    }

    public String trovaTitoloPatterPerChar(String titolo, String pattern) {
        int textTitolo = titolo.length();
        int textPattern = pattern.length();
        if (textPattern <= textTitolo) {
            int lunghezzaIterazione = textTitolo-textPattern;
            for(int i = 0; i < lunghezzaIterazione; i++) {
                boolean isMatch = true;

                for(int j = i; j < i + textPattern; j++) {
                    if(Character.toLowerCase(pattern.charAt(j - i)) != Character.toLowerCase(titolo.charAt(j))) {
                        isMatch = false;
                    }
                }

                if(isMatch) {
                    return titolo;
                }
            }
        }
        return null;
    }
}
