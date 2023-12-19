public class OsobniVozidlo extends Vozidlo {
    private int rychlost;
    private double vaha;
    private String barva;

    public OsobniVozidlo(String zadavatel, String datum, int rychlost, double vaha, String barva) {
        setTypVozidla("Osobní vozidlo");
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
    
    // Additional methods or constructors if needed
}
