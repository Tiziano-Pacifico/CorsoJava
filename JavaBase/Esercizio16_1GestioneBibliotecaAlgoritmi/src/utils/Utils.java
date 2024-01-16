package utils;

import Classi.Biblioteca;
import Classi.Libro;

import java.util.ArrayList;

public class Utils <T>{

    String[] titoliLibri = {
            "Il Signore degli Anelli",
            "Cime tempestose",
            "1984",
            "Il Piccolo Principe",
            "Don Chisciotte",
            "Moby Dick",
            "Guerra e Pace",
            "Orgoglio e Pregiudizio",
            "Cronache di Narnia",
            "Harry Potter"
    };

    String[] autoriLibri = {
            "J.R.R. Tolkien",
            "Emily Brontë",
            "George Orwell",
            "Antoine de Saint-Exupéry",
            "Miguel de Cervantes",
            "Herman Melville",
            "Lev Tolstoj",
            "Jane Austen",
            "C.S. Lewis",
            "J.K. Rowling"
    };

    int[] anniPubblicazione = {
            1954,
            1847,
            1949,
            1943,
            1605,
            1851,
            1869,
            1813,
            1950,
            1997
    };

    public void initBiblioteca(Biblioteca biblioteca) {
        ArrayList<Libro> listaLibri = new ArrayList<>();

        for (int i = 0; i < titoliLibri.length; i++) {
            Libro libro = new Libro(titoliLibri[i],autoriLibri[i],anniPubblicazione[i] );
            listaLibri.add(libro);
        }

        biblioteca.setElencoLibri(listaLibri);
    }

    public void stampaArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }


}
