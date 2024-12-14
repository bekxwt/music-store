import java.util.Scanner;

public class main {
    static String[] titles = new String[100];
    static String[] artists = new String[100];
    static double[] prices = new double[100];
    static int[] stocks = new int[100];
    static int count = 6;

    static {
        titles[0] = "Blinding Lights";
        artists[0] = "The Weeknd";
        prices[0] = 9.99;
        stocks[0] = 10;

        titles[1] = "Save Your Tears";
        artists[1] = "The Weeknd";
        prices[1] = 8.99;
        stocks[1] = 15;

        titles[2] = "Leave The Door Open";
        artists[2] = "Bruno Mars";
        prices[2] = 7.99;
        stocks[2] = 20;

        titles[3] = "Talking to the Moon";
        artists[3] = "Bruno Mars";
        prices[3] = 6.99;
        stocks[3] = 12;

        titles[4] = "Say You Won't Let Go";
        artists[4] = "James Arthur";
        prices[4] = 5.99;
        stocks[4] = 18;

        titles[5] = "Lose Yourself";
        artists[5] = "Eminem";
        prices[5] = 10.99;
        stocks[5] = 8;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Search");
            System.out.println("4. Update Stock");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                addAlbum(scanner);
            } else if (choice == 2) {
                displayAlbums();
            } else if (choice == 3) {
                searchAlbum(scanner);
            } else if (choice == 4) {
                updateStock(scanner);
            } else if (choice == 5) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    public static void addAlbum(Scanner scanner) {
        if (count >= 100) {
            System.out.println("No space left to add more albums.");
            return;
        }

        System.out.print("Enter album title: ");
        scanner.nextLine();
        titles[count] = scanner.nextLine();

        System.out.print("Enter artist name: ");
        artists[count] = scanner.nextLine();

        System.out.print("Enter album price: ");
        prices[count] = scanner.nextDouble();

        System.out.print("Enter stock quantity: ");
        stocks[count] = scanner.nextInt();

        count++;
        System.out.println("Album added.");
    }

    public static void displayAlbums() {
        if (count == 0) {
            System.out.println("No albums available.");
            return;
        }

        System.out.println("\nAlbums:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". Title: " + titles[i] + ", Artist: " + artists[i] + ", Price: " + prices[i] + ", Stock: " + stocks[i]);
        }
    }

    public static void searchAlbum(Scanner scanner) {
        if (count == 0) {
            System.out.println("No albums to search.");
            return;
        }

        System.out.print("Enter title to search: ");
        scanner.nextLine();
        String searchTitle = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (titles[i].equalsIgnoreCase(searchTitle)) {
                System.out.println("Found: Title: " + titles[i] + ", Artist: " + artists[i] + ", Price: " + prices[i] + ", Stock: " + stocks[i]);
                return;
            }
        }

        System.out.println("Album not found.");
    }

    public static void updateStock(Scanner scanner) {
        if (count == 0) {
            System.out.println("No albums to update.");
            return;
        }

        System.out.print("Enter title to update stock: ");
        scanner.nextLine();
        String updateTitle = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (titles[i].equalsIgnoreCase(updateTitle)) {
                System.out.println("Current stock for " + titles[i] + ": " + stocks[i]);
                System.out.print("Enter new stock: ");
                stocks[i] = scanner.nextInt();
                System.out.println("Stock updated.");
                return;
            }
        }

        System.out.println("Album not found.");
    }
}
