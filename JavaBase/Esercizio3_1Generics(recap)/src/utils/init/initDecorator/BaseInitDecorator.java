package utils.init.initDecorator;

import utils.init.Init;

/**
 * Abstract Decorator per i wrapper di inizializzazione
 */
public abstract class BaseInitDecorator implements Init {

    private final Init inizializer;

    protected BaseInitDecorator(Init inizializer) {
        this.inizializer = inizializer;
    }

    @Override
    public void init() {
        this.inizializer.init();
    }

    @Override
    public <T > T close(T obj, String message) {
        return this.inizializer.close(obj,message);
    }
}
