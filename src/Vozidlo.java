public class Vozidlo {
    protected String zadavatel;
    protected String datum;
    protected String typVozidla;

    // Default constructor
    public Vozidlo() {
        // Default constructor, you can leave it empty or provide some default values
    }

    // Parameterized constructor
    public Vozidlo(String zadavatel, String datum, String typVozidla) {
        this.zadavatel = zadavatel;
        this.datum = datum;
        this.typVozidla = typVozidla;
    }

    // Getter and setter methods
    public String getZadavatel() {
        return zadavatel;
    }

    public void setZadavatel(String zadavatel) {
        this.zadavatel = zadavatel;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTypVozidla() {
        return typVozidla;
    }

    public void setTypVozidla(String typVozidla) {
        this.typVozidla = typVozidla;
    }

    // Additional methods...
}
