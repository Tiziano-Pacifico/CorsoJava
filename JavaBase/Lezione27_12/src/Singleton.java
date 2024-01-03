public class Singleton {

    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton createClass() {
        if (Singleton.instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private  String value;

    public static Singleton getInstance() {

        return instance;
    }

    public static void setInstance(Singleton instance) {
        Singleton.instance = instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
