package utils.init;

/**
 * Per la gestione delle inizializzazioni utilizzo un pattern Decorator
 * L'interfaccia init funge da Component per tutte le successive istanze di inizializzazione
 */
public interface Init {
    void init();
    <T> T close(T obj, String message);
}
