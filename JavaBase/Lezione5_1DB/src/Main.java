import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {

        String datiConnessione[] = DbUtility.loadDati();

        DbManager dbManager = new DbManager(datiConnessione[1], datiConnessione[2], datiConnessione[0]);

        try {

            if(dbManager.connetti()) {
                System.out.println("Database connesso");
                //int updatedRow = dbManager.creaTabella("patente");
                //System.out.println("numero elaborazioni : " + updatedRow);
                dbManager.insertIntoDocument(
                        "patente","PA32442","31/12/2025","01/01/2024");
                //  dbManager.estraiDatiTabella("patente");
                dbManager.estraiDocumento("patente","2");
                // disconnessione dal db
                dbManager.disconnetti();
            }

        }
        catch (SQLException e) {

            if (e.getMessage().contains("Unknown database")) {
                try {
                    dbManager.craDb("utenticorso2024");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                System.out.println("Eccezione SQL: " + e.getMessage());
            }
        }

    }

    //metodo statico per il recupero delle properties

}