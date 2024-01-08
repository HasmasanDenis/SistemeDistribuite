import java.util.Scanner;

public class NewsSystemCLI {

    public static void main(String[] args) {
        // Inițializare și lansare noduri P2P
        P2PNode node = new P2PNode();
        node.start();
        Scanner scanner = new Scanner(System.in);
        NewsDistributedSystem newsSystem = new NewsDistributedSystem();

        while (true) {
            System.out.println("1. Publică știre");
            System.out.println("2. Recuperează știri");
            System.out.println("3. Sterge stire");
            System.out.println("4. Ieșire");

            System.out.print("Alegeți o opțiune: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline

            switch (choice) {
                case 1:
                    System.out.print("Introduceți știrea (format: titlu|conținut): ");
                    String newsInput = scanner.nextLine();
                    String[] newsData = newsInput.split("\\|");
                    if (newsData.length == 2) {
                        newsSystem.publishNews(newsData[0], newsData[1]);
                        System.out.println("Știre publicată cu succes!");
                    } else {
                        System.out.println("Format de știre nevalid!");
                    }
                    break;
                case 2:
                    System.out.print("Introduceți cuvânt-cheie pentru căutare: ");
                    String keyword = scanner.nextLine();
                    newsSystem.retrieveNews(keyword);
                    break;
                case 3:
                    System.out.print("Introduceți titlul știrii de șters: ");
                    String titleToDelete = scanner.nextLine();
                    newsSystem.deleteNews(titleToDelete);
                    break;
                case 4:
                    System.out.println("La revedere!");
                    System.exit(0);
                default:
                    System.out.println("Opțiune nevalidă. Alegeți din nou.");
            }
        }
    }
}
