import Classi.Biblioteca;
import Classi.Libro;
import utils.Costanti;
import utils.Utils;

import java.util.Scanner;

//Gestione biblioteca mediante l'implementazione degli algoritmi di ordinamento e ricerca
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Utils<Libro> utils = new Utils();

        int scelta;
        String titolo, pattern;
        Libro libro;
        Libro[] elencoLibri;

        Scanner scanner = new Scanner(System.in);


        utils.initBiblioteca(biblioteca);
        do{
            System.out.println("Cosa vuoi fare?");
            System.out.println("1) Stampa Elenco Libri");
            System.out.println("2) Cerca libro per titolo");
            System.out.println("3) Elenca libri per anno di pubblicazione");
            System.out.println("4) Ricerca per pattern");
            System.out.println("100) Esci");
            scelta = scanner.nextInt();

            switch (scelta) {
                case Costanti.STAMPA_LIBRI:
                    biblioteca.stampaElencoLibri();
                    System.out.println();
                    break;
                case Costanti.CERCA_LIBRO_PER_TITOLO:
                    System.out.println("Inserisci il titolo del libro\n");
                    biblioteca.stampaElencoLibri();
                    titolo = scanner.next();
                    libro = biblioteca.cercaLibroPerTitolo(titolo);
                    if(libro != null) System.out.println("Il libro cercato è " + libro.toString());
                    else System.out.println("Non abbiamo un libro con il titolo richiesto");
                    System.out.println();
                    break;
                case Costanti.ELENCA_LIBRI_ANNO_PUBBLICAZIONE:
                    elencoLibri = biblioteca.ordinaLibriPerAnnoPubblicazione();
                    utils.stampaArray(elencoLibri);
                    break;
                case Costanti.RICERCA_PER_PATTERN:
                    System.out.println("Inserisci il pattern del titolo\n");
                    biblioteca.stampaElencoLibri();
                    System.out.println();
                    pattern = scanner.next();
                    biblioteca.trovaPerPattern(pattern);
                    break;
                case Costanti.ESCI:
                    scelta = -1;
                    System.out.println("Arrivederci e grazie");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }while(scelta != -1);
    }
}