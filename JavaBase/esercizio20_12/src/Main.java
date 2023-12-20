
import utils.CreateOutput;
import utils.LeggiFile;
import utils.LineParser;
import utils.ScriviFile;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Il file in input
        String path = "info.txt";
        //Il file in output con la nuova formattazione
        String outPath = "newInfo.txt";

        //Una struttura dati che contiene ogni riga estratta dal file in input
        ArrayList<String> lines;

        //Le classi che implementano i vari metodi di lavoro
        //Le descrizioni dei metodi sono esposte nelle relative classi
        LeggiFile reader = new LeggiFile(path);
        LineParser lp = new LineParser();
        CreateOutput co = new CreateOutput();
        ScriviFile sc = new ScriviFile();

        //Leggo il file di input e estraggo ogni linea all'interno di un record dell'array
        lines = reader.leggiDaBuffer();

        //Controllo se il file esiste già, nel caso lo cancello
        sc.isFile(outPath);
        //Una pipeline di metodi che ottiene il risultato dell'esrcizio
        //Estraggo una linea(lines.get(i)) -->
        //Faccio il prasing della linea estraendo i vari campi nella struttura dati Persona(lp.parse(...)) -->
        //Dalla struttura dati di persona dove ho fatto il parsing dei dati rielaboro le informazioni
            // secondo la formattazione richiesta nella struttura Outputformat(co.createOutLine(...)) -->
        //Scivo ogni riga nel file di output
        for (int i = 0; i< lines.size(); i++) {
           sc.scriviBuffered( co.createOutLine(lp.parseLine(lines.get(i))) , outPath);
        }

    }
}