package utils.dbutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe che si occupa di caricare i valori delle properties del db
 */
public class DbUtility {

    public static String[] loadDati() {
        String[] dati = new String[4];
        Properties properties= new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("src/utils/config.properties"));
            properties.load(inputStream);
            dati[0] = properties.getProperty("dbName");
            dati[1] = properties.getProperty("username");
            dati[2]  =properties.getProperty("password");
            dati[3] = properties.getProperty("path");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dati;
    }
}
