import Utils.Calcoletti;
import Utils.InserisciValori;
import Utils.LeggiInputStream;
import Utils.ScriviOutputStream;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        InserisciValori insert = new InserisciValori();
        ScriviOutputStream write = new ScriviOutputStream();
        LeggiInputStream read = new LeggiInputStream();
        Calcoletti calc = new Calcoletti();

        int[] valori = new int[10];
        int[] valoriLetti = new int[10];

        valori = insert.inserisciValori();

        for (int i = 0; i < valori.length; i++) {
            write.scriviSuFile("dati.txt", String.valueOf(valori[i]));
        }

        valoriLetti = read.leggiInputStream("dati.txt");


        System.out.println();
        System.out.println("La media dei valori inseriti è: " + calc.calcolaMedia(valoriLetti));
        System.out.println("Il massimo tra i valori inseriti è: " + calc.trovaMassimo(valoriLetti));
        System.out.println("Il minimo tra i valori inseriti è; " + calc.trovaMininmo(valoriLetti));

        File fileDaCancellare = new File("dati.txt");
        try {
            if (fileDaCancellare.exists()) {
                if (fileDaCancellare.delete()) {
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