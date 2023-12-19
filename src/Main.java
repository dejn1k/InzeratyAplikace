import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        int volba;

        do {
            // managment.nacistDataZeSouboru(...);
            vytisknoutMenu();
            System.out.print("Vyberte možnost: ");
            volba = scanner.nextInt();

            switch (volba) {
                case 1:
                    // Přidání inzerátu
                   
                
                    // Předání instance do třídy Managment
                    management.pridatInzerat();
                
                    System.out.println("Inzerát byl přidán.");
                    // managment.pridatInzerat(...);
                    break;
                case 2:
                    // Odebrání inzerátu
                    // managment.odebratInzerat(...);
                    break;
                case 3:
                    // Výpis inzerátu
                    management.printInzeraty(management.getInzeraty());
                    break;
                case 4:
                    // Detailní výpis inzerátu
                    // managment.vypsatDetailInzeratu(...);
                    break;
                case 5:
                    // Vyhledání inzerátů
                    // managment.vyhledatPodleParametru(...);
                    break;
                case 0:
                    System.out.println("Konec programu.");
                    // Ukončení a uložení dat do souboru
                    // managment.ulozitDataDoSouboru(...);
                    break;
                default:
                    System.out.println("Neplatná volba. Zkuste znovu.");
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
