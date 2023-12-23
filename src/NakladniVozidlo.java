public class NakladniVozidlo extends Vozidlo {
    private int rychlost;
    private double vaha;
    private String barva;

    public NakladniVozidlo(String zadavatel, String datum, int rychlost, double vaha, String barva) {
        super(zadavatel, datum, "Nákladní vozidlo"); // Call the superclass constructor
        this.rychlost = rychlost;
        this.vaha = vaha;
        this.barva = barva;
    }

    public int getRychlost() {
        return rychlost;
    }

    public void setRychlost(int rychlost) {
        this.rychlost = rychlost;
    }

    public double getVaha() {
        return vaha;
    }

    public void setVaha(double vaha) {
        this.vaha = vaha;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    @Override
    public String toString() {
        return zadavatel + "," + datum + "," + typVozidla + "," + rychlost + "," + vaha + "," + barva;
    }


}
