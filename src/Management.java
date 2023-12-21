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

    //veci na vyhledavani
    public void performSearch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vyberte typ vyhledávání:");
        System.out.println("1. Zadavatel");
        System.out.println("2. Typ vozidla");
        System.out.println("3. Datum");
        int volba = scanner.nextInt();

        switch (volba) {
            case 1:
                searchByZadavatel();
                break;
            case 2:
                searchByTyp();
                break;
            case 3:
                searchByDatum();
                break;
            default:
                System.out.println("Neplatná volba pro vyhledávání.");
        }
    }

    public void searchByZadavatel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte zadavatele k vyhledání:");

        String zadavatelToSearch = scanner.nextLine();

        List<Vozidlo> foundAdvertisements = new ArrayList<>();

        for (Vozidlo vozidlo : inzeraty) {
            if (vozidlo.getZadavatel().equalsIgnoreCase(zadavatelToSearch)) {
                foundAdvertisements.add(vozidlo);
            }
        }

        printSearchResults(foundAdvertisements);
    }

    public void searchByTyp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte typ vozidla k vyhledání:");

        String typToSearch = scanner.nextLine();

        List<Vozidlo> foundAdvertisements = new ArrayList<>();

        for (Vozidlo vozidlo : inzeraty) {
            if (vozidlo.getTypVozidla().equalsIgnoreCase(typToSearch)) {
                foundAdvertisements.add(vozidlo);
            }
        }

        printSearchResults(foundAdvertisements);
    }

    public void searchByDatum() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte datum k vyhledání (ve formátu dd.MM.yyyy):");

        String datumToSearch = scanner.nextLine();

        List<Vozidlo> foundAdvertisements = new ArrayList<>();

        for (Vozidlo vozidlo : inzeraty) {
            if (vozidlo.getDatum().equals(datumToSearch)) {
                foundAdvertisements.add(vozidlo);
            }
        }

        printSearchResults(foundAdvertisements);
    }

    private void printSearchResults(List<Vozidlo> foundAdvertisements) {
        if (!foundAdvertisements.isEmpty()) {
            System.out.println("Výsledky vyhledávání:");

            for (Vozidlo vozidlo : foundAdvertisements) {
                System.out.println("Zadavatel: " + vozidlo.getZadavatel());
                System.out.println("Datum: " + vozidlo.getDatum());
                System.out.println("Typ vozidla: " + vozidlo.getTypVozidla());

                // Print details based on the type of vozidlo
                switch (vozidlo.getTypVozidla()) {
                    case "Osobní Vozidlo":
                        printOsobniVozidloDetails(vozidlo);
                        break;
                    case "Nákladní vozidlo":
                        printNakladniVozidloDetails(vozidlo);
                        break;
                    default:
                        System.out.println("Nepodporovaný typ vozidla");
                }

                System.out.println("-------------------------");
            }
        } else {
            System.out.println("Nenalezeny žádné inzeráty odpovídající hledání.");
        }
    }

    public void odebratInzerat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte index inzerátu k smazání:");

        int indexToDelete = scanner.nextInt();

        if (indexToDelete >= 0 && indexToDelete < inzeraty.size()) {
            inzeraty.remove(indexToDelete);
            System.out.println("Inzerát byl úspěšně smazán.");
        } else {
            System.out.println("Neplatný index inzerátu.");
        }
    }

    public static void printInzeraty(List<Vozidlo> inzerat) {
        for (Vozidlo vozidlo : inzerat) {
            System.out.println("Zadavatel: " + vozidlo.getZadavatel());
            System.out.println("Datum: " + vozidlo.getDatum());
            System.out.println("Typ vozidla: " + vozidlo.getTypVozidla());

            switch (vozidlo.getTypVozidla()) {
                case "Osobní Vozidlo":
                    printOsobniVozidloDetails(vozidlo);
                    break;
                case "Nákladní vozidlo":
                    printNakladniVozidloDetails(vozidlo);
                    break;
                default:
                    System.out.println("Nepodporovaný typ vozidla");
            }

            System.out.println("-------------------------");
        }
    }
    private static void printOsobniVozidloDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof OsobniVozidlo) {
            OsobniVozidlo osobniVozidlo = (OsobniVozidlo) vozidlo;
            System.out.println("Rychlost: " + osobniVozidlo.getRychlost());
            System.out.println("Váha: " + osobniVozidlo.getVaha());
            System.out.println("Barva: " + osobniVozidlo.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }

    private static void printNakladniVozidloDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof NakladniVozidlo) {
            NakladniVozidlo nakladniVozidlo = (NakladniVozidlo) vozidlo;
            System.out.println("Rychlost: " + nakladniVozidlo.getRychlost());
            System.out.println("Váha: " + nakladniVozidlo.getVaha());
            System.out.println("Barva: " + nakladniVozidlo.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }
}

