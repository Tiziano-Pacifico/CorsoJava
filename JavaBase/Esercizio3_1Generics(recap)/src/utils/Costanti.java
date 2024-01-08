package utils;

public class Costanti {

    //Costanti usate per richiamare i dati caricati dal file config.properties.
    //I dati sono stati inseriti in un array. Utilizziamo le costanti per evitare di dover richiamare i dati con i numeri e fare confusione tra di essi
    public static final int DB_NAME = 0;
    public static final int USERNAME = 1;
    public static final int PASSWORD = 2;
    public static final int PATH = 3;
    public static final int LOG_IN = 1;
    public static final int SIGN_UP = 2;
    public static final int CANCELLA_UTENTE = 3;
    public static final int ESCI = 4;
    public static final int ACQUISTA_PRODOTTO = 1;
    public static final int STAMPA_CARRELLO = 2;
    public static final int STAMPA_STORICO = 3;
    public static final int CHECK_OUT = 4;
    public static final int SIGN_OUT = 5;
    public static final int LIBRO = 1;
    public static final int PRODOTTO_ELETTRONICO = 2;

    public static final String NOME_DB = "utenti";
    public static final String NOME_TABELLA = "utenti";
    public static final String BASE_FILE_PATH = "src/files";
}
