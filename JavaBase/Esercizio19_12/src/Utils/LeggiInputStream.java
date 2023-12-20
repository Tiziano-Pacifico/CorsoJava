package Utils;

import java.io.FileInputStream;
import java.io.IOException;

public class LeggiInputStream {

    public int[] leggiInputStream(String nomeFile) {

        int[] valori = new int[10];
        int count = 0;

        try(FileInputStream fileInputStream = new FileInputStream(nomeFile)) {
            //Vedere se il file contiene dei dati
            // -1 OPPURE eccezione che scaturisce dalla lettura di un file vuoto
            //Scorrendo il file fileInputStream.read() ritornerà -1 se non ci sono altri caratteri

            int i = fileInputStream.read();
            //valori[count] = Integer.parseInt(String.valueOf((char) i));
            int value;
            boolean isNumber = true;
            String number = String.valueOf((char) i);

            while(i!=-1){
                    i = fileInputStream.read();

                        try {
                            value = Integer.parseInt(String.valueOf(((char) i)));
                            if (isNumber) {
                                number += String.valueOf((char)i);
                            }
                            else {
                                number = String.valueOf(value);
                            }
                            isNumber = true;
                        }
                        catch (Exception e) {
                            value = -1;
                            isNumber = false;
                        }
                        if (value == -  1) {
                        System.out.println(count + " " + (char)i + " " + value + " " + number + " " + i);
                        try {
                                valori[count] = Integer.parseInt(number);
                        }
                        catch (NumberFormatException ex) {

                        }

                            count++;
                            number = "";
                        }
            }
        }
        catch (IOException ex) {
            System.out.println("Eccezione tipo "+ ex.getMessage());
        }

        return valori;
    }
}
