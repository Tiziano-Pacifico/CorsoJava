package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe implementa il medoto leggiDaBuffer per leggere con il metodo BufferedReader un testo su più righe da un file
 * richiede di fornire il path del file da passare al metodo
 */
public class LeggiFile {

    private String path;

    public LeggiFile(String path) {
        this.path = path;
    }

    /**
     * Il metodo prende un file di testo e legge una riga alla volta restituendo un ArrayList di stringhe, in cui ogni entry corrisponde ad una riga del file
     * @return L'ArrayList di Stringhe
     */
    public ArrayList<String> leggiDaBuffer() {
        ArrayList<String> lines = new ArrayList<String>();
        FileReader fr = null;
        BufferedReader bfr = null;

        try {
            fr = new FileReader(path);
            bfr = new BufferedReader(fr);

            String testo = null;
            while((testo = bfr.readLine()) != null) {

                //System.out.println(testo);
                lines.add(testo);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                fr.close();
                bfr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lines;
    }

}
