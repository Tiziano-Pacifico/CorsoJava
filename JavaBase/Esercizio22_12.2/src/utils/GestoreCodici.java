package utils;

import classi.Costanti;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestoreCodici {

    private ArrayList<String> listaCodici = new ArrayList<>();


    private String creaCodice() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            char lettera = (char) (rand.nextInt(26) + 'A');
            sb.append(lettera);
        }

        for (int i = 0; i < 4; i++) {
            int cifra = rand.nextInt(10);
            sb.append(cifra);
        }

        return sb.toString();
    }

    private void creaCodiceUnico() {
        String codice;
        do {
            codice = creaCodice();
        } while (listaCodici.contains(codice));
        listaCodici.add(codice);
    }

    private void salvaCodici() {

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(Costanti.path))){

            for(String riga: listaCodici){
                bfw.write(riga);
                bfw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception ee){
            System.out.println("Qualcosa è andato storto");
        }
        System.out.println("File creato con successo");
    }

    public void generaFileCodici(int numeroCodici) {
        for (int i = 0; i < numeroCodici; i++) {
            creaCodiceUnico();
        }
        salvaCodici();
    }

    public ArrayList<String> caricaFileCodici() {

        ArrayList<String> codici = new ArrayList<>();

        try(BufferedReader bfr = new BufferedReader(new FileReader(Costanti.path))) {
            String riga;
            while((riga = bfr.readLine()) !=  null) {
                codici.add(riga);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return codici;
    }
}
