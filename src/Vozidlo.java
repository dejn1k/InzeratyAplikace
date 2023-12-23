abstract class Vozidlo {
    protected String zadavatel;
    protected String datum;
    protected String typVozidla;
    private static int nextId = 1;
    private int id;

    // Default constructor
    public Vozidlo(int id, String zadavatel, String datum, String typVozidla) {
        this.id = id; // Assign the provided ID directly
        this.zadavatel = zadavatel;
        this.datum = datum;
        this.typVozidla = typVozidla;
    }

    // Parameterized constructor
    public Vozidlo(String zadavatel, String datum, String typVozidla) {
        // You can leave this constructor if you want to generate IDs externally
        this.zadavatel = zadavatel;
        this.datum = datum;
        this.typVozidla = typVozidla;
        this.id = generateUniqueId(); // Generate a unique ID when using this constructor
    }

    // Other methods...

    private static synchronized int generateUniqueId() {
        return nextId++;
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

    public int getId() {
        return id;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    
        sb.append(getId()).append(","); // Use the existing ID
        sb.append(getZadavatel()).append(",");
        sb.append(getDatum()).append(",");
        sb.append(getTypVozidla()).append(",");
    
        // Další informace závislé na typu vozidla
        if (this instanceof OsobniVozidlo) {
            OsobniVozidlo osobniVozidlo = (OsobniVozidlo) this;
            sb.append(osobniVozidlo.getRychlost()).append(",");
            sb.append(osobniVozidlo.getVaha()).append(",");
            sb.append(osobniVozidlo.getBarva());
        } else if (this instanceof NakladniVozidlo) {
            NakladniVozidlo nakladniVozidlo = (NakladniVozidlo) this;
            sb.append(nakladniVozidlo.getRychlost()).append(",");
            sb.append(nakladniVozidlo.getVaha()).append(",");
            sb.append(nakladniVozidlo.getBarva());
        } else if (this instanceof SportovniVozidlo) {
            SportovniVozidlo sportovniVozidlo = (SportovniVozidlo) this;
            sb.append(sportovniVozidlo.getRychlost()).append(",");
            sb.append(sportovniVozidlo.getVaha()).append(",");
            sb.append(sportovniVozidlo.getBarva());
        } else if (this instanceof Motocykl) {
            Motocykl motocykl = (Motocykl) this;
            sb.append(motocykl.getRychlost()).append(",");
            sb.append(motocykl.getVaha()).append(",");
            sb.append(motocykl.getBarva());
        }
    
        return sb.toString();
    }

    public static Vozidlo vytvorZRetezce(String line) {
        String[] parts = line.split(",");

    
        if (parts.length < 4) {
            return null;
        }
    
        int id;
        try {
            id = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing ID: " + e.getMessage());
            return null;
        }
    
        String zadavatel = parts[1];
        String datum = parts[2];
        String typVozidla = parts[3];
    
        Vozidlo novoVozidlo = null;
    
        switch (typVozidla) {
            case "Osobní vozidlo":
                if (parts.length == 7) {
                    try {
                        int rychlost = Integer.parseInt(parts[4]);
                        double vaha = Double.parseDouble(parts[5]);
                        String barva = parts[6];
                        novoVozidlo = new OsobniVozidlo(zadavatel, datum, rychlost, vaha, barva);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric values: " + e.getMessage());
                    }
                }
                break;
    
            case "Nákladní vozidlo":
                if (parts.length == 7) {
                    try {
                        int rychlost = Integer.parseInt(parts[4]);
                        double vaha = Double.parseDouble(parts[5]);
                        String barva = parts[6];
                        novoVozidlo = new NakladniVozidlo(zadavatel, datum, rychlost, vaha, barva);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric values: " + e.getMessage());
                    }
                }
                break;
    
            case "Sportovní vozidlo":
                if (parts.length == 7) {
                    try {
                        int rychlost = Integer.parseInt(parts[4]);
                        double vaha = Double.parseDouble(parts[5]);
                        String barva = parts[6];
                        novoVozidlo = new SportovniVozidlo(zadavatel, datum, rychlost, vaha, barva);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric values: " + e.getMessage());
                    }
                }
                break;
            case "Motocykl":
                if (parts.length == 7) {
                    try {
                        int rychlost = Integer.parseInt(parts[4]);
                        double vaha = Double.parseDouble(parts[5]);
                        String barva = parts[6];
                        novoVozidlo = new Motocykl(zadavatel, datum, rychlost, vaha, barva);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric values: " + e.getMessage());
                    }
                }
            
    
            default:
                // Unknown type or other handling
                break;
        }
    
        return novoVozidlo;
    }
    
}