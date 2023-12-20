package Utils;

import java.io.FileInputStream;
import java.io.IOException;

public class LeggiInputPulito {

    public int[] leggiInputStream(String nomeFile) {
        int[] valori = new int[10];
        int count = 0;

        try(FileInputStream fileInputStream = new FileInputStream(nomeFile)) {
            StringBuilder currentNumber = new StringBuilder();
            int byteRead;
            while((byteRead = fileInputStream.read()) != -1) {
                char currentChar = (char) byteRead;

                if (Character.isDigit(currentChar)) {
                    currentNumber.append(currentChar);
                } else {
                    if (currentNumber.length() > 0) {
                        try {
                            valori[count++] = Integer.parseInt(currentNumber.toString());
                        } catch (NumberFormatException e) {

                        }
                        currentNumber.setLength(0);
                    }
                }
                if (count >= valori.length) {
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Eccezione tipo " + e.getMessage());
        }
        return null;
    }

}
