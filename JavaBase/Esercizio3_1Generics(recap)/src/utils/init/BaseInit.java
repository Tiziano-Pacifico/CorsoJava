package utils.init;

import utils.init.Init;

/**
 * Nella logica di utilizzare il pattern Decorator nella gesttione dei vair init
 * BaseInit è il ConcreteComponent che verrà wrappato dai decorator
 */
public class BaseInit implements Init {
    @Override
    public void init() {
        System.out.println("Inizializzo componente: ");
    }

    @Override
    public <T> T close(T obj, String message) {
        System.out.println("Chiudo componente: \n" + message);
        return obj;
    }


}
