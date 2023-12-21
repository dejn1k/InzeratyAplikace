import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        
        int volba;

        do {
            // managment.nacistDataZeSouboru(...);
            vytisknoutMenu();
            try {
                System.out.print("Vyberte možnost: ");
                volba = scanner.nextInt();

                    switch (volba) {
                    case 1:
                        // Přidání inzerátu
                        management.pridatInzerat();
                        break;
                    case 2:
                        // Odebrání inzerátu
                        management.odebratInzerat();;
                        break;
                    case 3:
                        // Výpis inzerátu
                        management.printInzeraty(management.getInzeraty());
                        break;
                    case 4:
                        // Detailní výpis inzerátu
                        break;
                    case 5:
                        // Vyhledání inzerátů
                        management.performSearch();
                        break;
                    case 0:
                        System.out.println("Konec programu.");
                        // Ukončení a uložení dat do souboru
                        // managment.ulozitDataDoSouboru(...);
                        break;
                    default:
                        System.out.println("Neplatná volba. Zkuste znovu.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Neplatná volba. Zadejte číslo mezi 1 a 4.");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                    volba = -1; // Set choice to an invalid value to loop again
                }

        } while (volba != 0);

        scanner.close();
    }

    private static void vytisknoutMenu() {
            System.out.println("-------------");
            System.out.println("1. Přidat inzerát");
            System.out.println("2. Odebrat inzerát");
            System.out.println("3. Vypsat inzeráty");
            System.out.println("4. Vypsat detail inzerátu");
            System.out.println("5. Vyhledat inzeráty");
            System.out.println("0. Ukončit a uložit data do souboru");
    }
}

