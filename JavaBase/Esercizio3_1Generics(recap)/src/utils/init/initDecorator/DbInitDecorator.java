package utils.init.initDecorator;

import utils.dbutils.DBManager;
import utils.dbutils.DbInterface;
import utils.init.Init;

import java.sql.SQLException;

/**
 * Decoratore che si occupa di inizializzare o chiudere il database
 */
public class DbInitDecorator extends BaseInitDecorator{

    private DbInterface dbInterface;

    public DbInitDecorator(Init inizializer) {
        super(inizializer);
        dbInterface = new DbInterface();
    }

    @Override
    public void init() {
        super.init();
        System.out.println("Componente DataBase\n");
        dbInterface.inizializeDB();

    }
    @Override
    public <T> T close(T obj, String message) {
        dbInterface.closeConnection();
        return super.close(obj, message);
    }
}
