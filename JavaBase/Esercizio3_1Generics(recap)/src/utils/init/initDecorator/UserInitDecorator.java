package utils.init.initDecorator;

import classi.Utente;
import classi.logics.Carrello;
import utils.ArchivioDati;
import utils.Costanti;
import utils.init.Init;
import utils.loggedFunctionalities.Store;

import java.util.ArrayList;

public class UserInitDecorator extends BaseInitDecorator{

    private Utente user;
    private Store store = new Store();

    public UserInitDecorator(Init inizializer, Utente user) {
        super(inizializer);
        this.user = user;
    }

    @Override
    public void init() {
        super.init();
        System.out.println("Inizializzo utente");
        Utente utenteEstratto = store.cercaUtente(store.logIn());
        user.setNome(utenteEstratto.getNome());
        user.setIndirizzo(utenteEstratto.getIndirizzo());
        user.setId(utenteEstratto.getId());
        System.out.println("Inizializzo carrello e storico acquisti utente");
        //COntrollo se sono presenti un carrello e uno storico acquisti per l'utente salvati come file
        //Se non sono presenti inizializzo nuovi oggetti per l'utente
        if(!ArchivioDati.isFile(String.format( "%s/carrelli/%s.ser",Costanti.BASE_FILE_PATH, user.getId()))) {
            System.out.println("Non è stato trovato un carrello salvato per l'utente, creo carrello vuoto");
            user.setCarrello(new Carrello());
        }
        else {
            user.setCarrello(ArchivioDati.caricadati(String.format( "%s/carrelli/%s.ser",Costanti.BASE_FILE_PATH, user.getId())));
        }
        if(!ArchivioDati.isFile(String.format("%s/storicoacquisti/%s.ser",Costanti.BASE_FILE_PATH, user.getId()))){
            System.out.println("Non è stato trovato uno storico acquisti per l'utente.");
            user.setStoricoAcquisti(new ArrayList<>());
        } else{
            user.setStoricoAcquisti(ArchivioDati.caricadati(String.format( "%s/storicoacquisti/%s.ser",Costanti.BASE_FILE_PATH, user.getId())));
        }
    }

    @Override
    public <T> T close(T obj, String message) {
        obj = null;
        return super.close(obj, message);
    }
}
