package utils;

import Strutture.OutputFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Classe che gestisce la scrittura del file
 * Contiene due metodi:
 * scriviBuffered per scrivere una linea nel file di output con il metodo BufferedWriter
 * isFile per controllare se il file esiste già e nel caso cancellarlo per non scrivere su un file già esistente
 */
public class ScriviFile {


    /**
     * Scrive una struttura dati di tipo OutputFormat su un file come singola riga e inserisce un carattere di fine riga al termine
     * @param line la struttura dati contenente le informazioni da salvare su file
     * @param path il path del file dove vogliamo salvare la riga di testo
     */
    public void scriviBuffered(OutputFormat line, String path) {
        //Crea un oggetto di tipo BufferedWriter
        try {

            BufferedWriter bfw = null;
            bfw = new BufferedWriter(new FileWriter(path, true), 100); //Posso aggiungere la dimensione del buffer nel ostruttore

            bfw.write(line.getNome() + " " + line.getCognome() + " " + line.getMail() + "\n");
            bfw.flush();
            //bfw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Controlla se il file esiste e nel caso lo cancella
     * @param path: il path del file che si vuole controllare
     */
    public void isFile(String path) {

        File file = new File(path);
        try {
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Il file è stato cancellato con successo.");
                } else {
                    System.out.println("Impossibile cancellare il file.");
                }
            } else {
                System.out.println("Il file non esiste.");
            }
        } catch (SecurityException e) {
            System.err.println("Errore di permessi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore durante la cancellazione del file: " + e.getMessage());
        }
    }
}
