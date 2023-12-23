import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Management {
  private ArrayList<Vozidlo> inzeraty;
  private Map<Integer, Vozidlo> idToAdvertisementMap;

    public Management() {
        inzeraty = new ArrayList<>();
        idToAdvertisementMap = new HashMap<>();
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
                novyInzerat = vytvorSportovniVozidlo();
                break;
            case 4:
                novyInzerat = vytvorMotocykl();
                break;
            default:
                System.out.println("Neplatná volba");
        }

        if (novyInzerat != null) {
            inzeraty.add(novyInzerat);
            idToAdvertisementMap.put(novyInzerat.getId(), novyInzerat);
            System.out.println("Inzerát byl úspěšně přidán.");
        }
        
    }

    private OsobniVozidlo vytvorOsobniVozidlo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte informace o osobním vozidle:");

        System.out.print("Zadavatel: ");
        String zadavatel = scanner.nextLine();

        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Rychlost (km/h):  ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha (kg):   ");
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

        System.out.print("Rychlost (km/h):  ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha (kg):   ");
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

        private SportovniVozidlo vytvorSportovniVozidlo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte informace o sportovním vozidle:");

        System.out.print("Zadavatel: ");
        String zadavatel = scanner.nextLine();

        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Rychlost (km/h):  ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha (kg):   ");
        double vaha = scanner.nextDouble();

        scanner.nextLine(); // Očištění bufferu

        System.out.print("Barva: ");
        String barva = scanner.nextLine();

        // Vytvoření instance osobního vozidla
        SportovniVozidlo sportovniVozidlo = new SportovniVozidlo(zadavatel, datum, rychlost, vaha, barva);
        sportovniVozidlo.setZadavatel(zadavatel);
        sportovniVozidlo.setDatum(datum);
        sportovniVozidlo.setRychlost(rychlost);
        sportovniVozidlo.setVaha(vaha);
        sportovniVozidlo.setBarva(barva);

        return sportovniVozidlo;
    }

        private Motocykl vytvorMotocykl() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte informace o motocyklu:");

        System.out.print("Zadavatel: ");
        String zadavatel = scanner.nextLine();

        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Rychlost (km/h):  ");
        int rychlost = scanner.nextInt();

        System.out.print("Váha (kg):   ");
        double vaha = scanner.nextDouble();

        scanner.nextLine(); // Očištění bufferu

        System.out.print("Barva: ");
        String barva = scanner.nextLine();

        // Vytvoření instance osobního vozidla
        Motocykl motocykl = new Motocykl(zadavatel, datum, rychlost, vaha, barva);
        motocykl.setZadavatel(zadavatel);
        motocykl.setDatum(datum);
        motocykl.setRychlost(rychlost);
        motocykl.setVaha(vaha);
        motocykl.setBarva(barva);

        return motocykl;
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

        System.out.println("Jaký typ vozidla chcete vyhledat?");
        System.out.println("1. Nákladní vozidlo");
        System.out.println("2. Osobní vozidlo");
        System.out.println("3. Sportovní vozidlo");
        System.out.println("4. Motocykl");

        int volba = scanner.nextInt();
        String typToSearch = null;

        switch (volba) {
            case 1:
                typToSearch = "Nákladní Vozidlo";
                break;
            case 2:
                typToSearch = "Osobní vozidlo";
                break;
            case 3:
                typToSearch = "Sportovní vozidlo";
                break;
            case 4:
                typToSearch = "Motocykl";
                break;
            default:
                break;
        }

        

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
                    case "Osobní vozidlo":
                        printOsobniVozidloDetails(vozidlo);
                        break;
                    case "Nákladní vozidlo":
                        printNakladniVozidloDetails(vozidlo);
                        break;
                    case "Sportovní vozidlo":
                        printSportovniVozidloDetails(vozidlo);
                        break;
                    case "Motocykl":
                        printMotocyklDetails(vozidlo);
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

    public void odebratInzerat(int id) {
        Vozidlo vozidlo = idToAdvertisementMap.get(id);
        if (vozidlo != null) {
            inzeraty.remove(vozidlo);
            idToAdvertisementMap.remove(id);
            System.out.println("Inzerát s ID " + id + " byl úspěšně odstraněn.");
        } else {
            System.out.println("Inzerát s ID " + id + " nebyl nalezen.");
        }
    }

    public static void printInzeraty(List<Vozidlo> inzerat) {
        for (Vozidlo vozidlo : inzerat) {
            System.out.println("ID: " + vozidlo.getId());
            System.out.println("Zadavatel: " + vozidlo.getZadavatel());
            System.out.println("Datum: " + vozidlo.getDatum());
            System.out.println("Typ vozidla: " + vozidlo.getTypVozidla());

            switch (vozidlo.getTypVozidla()) {
                case "Osobní vozidlo":
                    printOsobniVozidloDetails(vozidlo);
                    break;
                case "Nákladní vozidlo":
                    printNakladniVozidloDetails(vozidlo);
                    break;
                case "Sportovní vozidlo":
                    printSportovniVozidloDetails(vozidlo);
                    break;
                case "Motocykl":
                    printMotocyklDetails(vozidlo);
                    break;
            }

            System.out.println("-------------------------");
        }
    }
    private static void printOsobniVozidloDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof OsobniVozidlo) {
            OsobniVozidlo osobniVozidlo = (OsobniVozidlo) vozidlo;
            System.out.println("Rychlost (km/h):  " + osobniVozidlo.getRychlost());
            System.out.println("Váha (kg):   " + osobniVozidlo.getVaha());
            System.out.println("Barva: " + osobniVozidlo.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }

    private static void printNakladniVozidloDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof NakladniVozidlo) {
            NakladniVozidlo nakladniVozidlo = (NakladniVozidlo) vozidlo;
            System.out.println("Rychlost (km/h):  " + nakladniVozidlo.getRychlost());
            System.out.println("Váha (kg):   " + nakladniVozidlo.getVaha());
            System.out.println("Barva: " + nakladniVozidlo.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }

       private static void printSportovniVozidloDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof SportovniVozidlo) {
            SportovniVozidlo sportovniVozidlo = (SportovniVozidlo) vozidlo;
            System.out.println("Rychlost (km/h):  " + sportovniVozidlo.getRychlost());
            System.out.println("Váha (kg):   " + sportovniVozidlo.getVaha());
            System.out.println("Barva: " + sportovniVozidlo.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }

       private static void printMotocyklDetails(Vozidlo vozidlo) {
        if (vozidlo instanceof Motocykl) {
            Motocykl motocykl = (Motocykl) vozidlo;
            System.out.println("Rychlost (km/h):  " + motocykl.getRychlost());
            System.out.println("Váha (kg):   " + motocykl.getVaha());
            System.out.println("Barva: " + motocykl.getBarva());
        } else {
            System.out.println("Chyba v typu vozidla");
        }
    }

    public void ulozitDoSouboru(String nazevSouboru) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazevSouboru))) {
            for (Vozidlo vozidlo : inzeraty) {
                writer.write(vozidlo.toString()); // Předpokládáme, že máte metodu toString() ve vaší třídě Vozidlo
                writer.newLine();
            }
            System.out.println("Inzeráty byly úspěšně uloženy do souboru.");
        } catch (IOException e) {
            System.err.println("Chyba při ukládání inzerátů do souboru: " + e.getMessage());
        }
    }

        public void nacistZeSouboru(String nazevSouboru) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nazevSouboru))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Předpokládáme, že máte metodu pro vytvoření instance z řetězce
                Vozidlo novyInzerat = Vozidlo.vytvorZRetezce(line);
                if (novyInzerat != null) {
                    inzeraty.add(novyInzerat);
                    idToAdvertisementMap.put(novyInzerat.getId(), novyInzerat);
                }
            }
            System.out.println("Inzeráty byly úspěšně načteny ze souboru.");
        } catch (IOException e) {
            System.err.println("Chyba při načítání inzerátů ze souboru: " + e.getMessage());
        }
    }
}
