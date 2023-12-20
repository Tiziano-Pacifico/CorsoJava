package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ScriviOutputStream {

    public void scriviSuFile(String path, String testo) {
        //Creare il file
        File file = new File(path);

        //Utilizzo la classe FileOutputStream per la scrittura
        //Il parametro append ci consente di concatenare i nuovi dati al termine del file invece di riscrivere il file dall'inizio cancellando i dati precedenti
        try(FileOutputStream outputStream = new FileOutputStream(file, true)) {
            //Se faccialo la dichiarazione nel try, evitiamo il close della risorsa, altrimenti dovremmo usare outputStream.close() nel finally per la chiusura della connessione

            //byte dati[] = testo.getBytes(); e dati al posto di testo.getBytes()
            outputStream.write(testo.getBytes("ISO_8859_1")); //Devo convertire la stringa in un array di caratteri, posso definire il charset se diverso da unicode
            //outputStream.write(testo.getBytes(StandardCharsets.ISO_8859_1)); //Devo convertire la stringa in un array di caratteri, posso definire il charset se diverso da unicode
            outputStream.write("-".getBytes());
            //Il metodo write si occupa di converire i byte in caratteri secondo la codifica del sistema. Di default java utilizza unicode
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
