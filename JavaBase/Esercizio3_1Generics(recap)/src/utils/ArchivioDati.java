package utils;

import classi.Utente;
import classi.logics.Carrello;

import java.io.*;

public class ArchivioDati {


    public static boolean isFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public static <T> void salvaDati (T dati, String filePath) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(filePath))){
            obj.writeObject(dati);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    public static <T> T caricadati(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            return (T) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
