import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Management {
  private ArrayList<Vozidlo> inzeraty;

    public Management() {
        inzeraty = new ArrayList<>();
    }

    public ArrayList<Vozidlo> getInzeraty() {
        return inzeraty;
    }

    // Metoda pro přidání inzerátu
    public void pridatInzerat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vyberte typ vozidla:");
        System.out.println("1. Nákladní vozidlo");
        System.out.println("2. Osobní vozidlo");
        System.out.println("3. Sportovní vozidlo");
        System.out.println("4. Motocykl");

        int volba = scanner.nextInt();

        Vozidlo novyInzerat = null;

        switch (volba) {
            case 1:
                novyInzerat = vytvorNakladniVozidlo();
                break;
            case 2:
                novyInzerat = vytvorOsobniVozidlo();
                break;
            case 3:
                //novyInzerat = vytvorSportovniVozidlo();
                break;
            case 4:
                //novyInzerat = vytvorMotocykl();
                break;
            default:
                System.out.println("Neplatná volba");
        }

        if (novyInzerat != null) {
            inzeraty.add(novyInzerat);
            System.out.println("Inzerát byl úspěšně přidán.");
        }
    }

    private OsobniVozidlo vytvorOsobniVozidlo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte informace o osobním vozidle:");

        System.out.print("Zadavatel: ");
        String zadavatel = scanner.nextLine();

        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Rychlost: ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha: ");
        double vaha = scanner.nextDouble();

        scanner.nextLine(); // Očištění bufferu

        System.out.print("Barva: ");
        String barva = scanner.nextLine();

        // Vytvoření instance osobního vozidla
        OsobniVozidlo osobniVozidlo = new OsobniVozidlo(zadavatel, datum, rychlost, vaha, barva);
        osobniVozidlo.setZadavatel(zadavatel);
        osobniVozidlo.setDatum(datum);
        osobniVozidlo.setRychlost(rychlost);
        osobniVozidlo.setVaha(vaha);
        osobniVozidlo.setBarva(barva);

        return osobniVozidlo;
    }

    // Metody pro vytvoření konkrétních typů vozidel
    private NakladniVozidlo vytvorNakladniVozidlo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte informace o nákladním vozidle:");

        System.out.print("Zadavatel: ");
        String zadavatel = scanner.nextLine();

        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Rychlost: ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha: ");
        double vaha = scanner.nextDouble();

        scanner.nextLine(); // Očištění bufferu

        System.out.print("Barva: ");
        String barva = scanner.nextLine();

        // Vytvoření instance osobního vozidla
        NakladniVozidlo nakladniVozidlo = new NakladniVozidlo(zadavatel, datum, rychlost, vaha, barva);
        nakladniVozidlo.setZadavatel(zadavatel);
        nakladniVozidlo.setDatum(datum);
        nakladniVozidlo.setRychlost(rychlost);
        nakladniVozidlo.setVaha(vaha);
        nakladniVozidlo.setBarva(barva);

        return nakladniVozidlo;
    }

 public static void printInzeraty(List<Vozidlo> inzerat) {
        for (Vozidlo vozidlo : inzerat) {
            System.out.println("Zadavatel: " + vozidlo.getZadavatel());
            System.out.println("Datum: " + vozidlo.getDatum());
            System.out.println("Typ vozidla: " + vozidlo.getTypVozidla());

            if (vozidlo instanceof OsobniVozidlo) {
                OsobniVozidlo osobniVozidlo = (OsobniVozidlo) vozidlo;
                System.out.println("Rychlost: " + osobniVozidlo.getRychlost());
                System.out.println("Váha: " + osobniVozidlo.getVaha());
                System.out.println("Barva: " + osobniVozidlo.getBarva());
            } else if (vozidlo instanceof NakladniVozidlo) {
                NakladniVozidlo nakladniVozidlo = (NakladniVozidlo) vozidlo;
                System.out.println("Rychlost: " + nakladniVozidlo.getRychlost());
                System.out.println("Váha: " + nakladniVozidlo.getVaha());
                System.out.println("Barva: " + nakladniVozidlo.getBarva());
            }
            
            // Add conditions for other subclasses if needed

            System.out.println("-------------------------");
        }
    }
}
