package classi;

public class Loan {

    private int id_person;
    private int id_book;

    public Loan() {
        this.id_person = -1;
        this.id_book = -1;
    }

    public Loan(int id_person, int id_book) {
        this.id_person = id_person;
        this.id_book = id_book;
    }

    public int getId_person() {
        return id_person;
    }

    public void setIs_person(int id_person) {
        this.id_person = id_person;
    }

    public int getid_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "is_person=" + id_person +
                ", id_book=" + id_book +
                '}';
    }
}
