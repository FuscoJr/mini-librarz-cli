import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Mini-Bibliothek ===");
            System.out.println("[1] Mitarbeiter");
            System.out.println("[2] Kunde");
            System.out.println("[0] Exit");
            System.out.print("Auswahl: ");

            int auswahl = input.nextInt();
            input.nextLine(); // clear \n

            switch (auswahl) {
                case 1 -> mitarbeiterMenu(input, library);
                case 2 -> kundenMenu(input, library);
                case 0 -> running = false;
                default -> System.out.println("Ungültig.");
            }
        }

        input.close();
    }

    private static void mitarbeiterMenu(Scanner input, Library library) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\n=== Mitarbeiter Menu ===");
            System.out.println("[1] Artikel hinzufügen");
            System.out.println("[2] Artikel entfernen");
            System.out.println("[3] Verfügbare Artikel");
            System.out.println("[4] Verliehene Artikel");
            System.out.println("[5] Bibliothek Inventar");
            System.out.println("[0] Auslogen");
            System.out.print("Auswahl: ");

            int auswahl = input.nextInt();
            input.nextLine();

            switch (auswahl) {
                case 1 -> {
                    System.out.print("Titel: ");
                    String title = input.nextLine();

                    System.out.print("Kategorie (BOOK, MUSIC_ALBUM, FILM, VIDEO_GAME): ");
                    ItemType type = ItemType.valueOf(input.nextLine().toUpperCase());

                    library.addItem(title, type);
                }
                case 2 -> {
                    System.out.print("Artikel ID: ");
                    int itemId = input.nextInt();
                    input.nextLine();

                    library.removeItem(itemId);
                }
                case 3 -> library.showAvailableItems();
                case 4 -> library.showLentItems();
                case 5 -> library.showStats();
                case 0 -> inMenu = false;
            }
        }
    }

    private static void kundenMenu(Scanner input, Library library) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\n=== Kunden Menu ===");
            System.out.println("[1] Verfügbare Artikel");
            System.out.println("[2] Meine ausgeliehene Artikel");
            System.out.println("[3] Artikel Zurückgeben");
            System.out.println("[4] Artikel Leihen");
            System.out.println("[0] Auslogen");
            System.out.print("Auswahl: ");

            int auswahl = input.nextInt();
            input.nextLine();

            switch (auswahl) {
                case 1 -> library.showAvailableItems();
                case 2 -> {
                    System.out.print("Dein Name: ");
                    String name = input.nextLine();

                    library.showUserItems(name);
                }
                case 3 -> {
                    System.out.print("Artikel ID: ");
                    int itemId = input.nextInt();
                    input.nextLine();

                    library.returnItem(itemId);
                }
                case 4 -> {
                    library.showAvailableItems();

                    System.out.print("Artikel ID: ");
                    int itemId = input.nextInt();
                    input.nextLine();

                    System.out.print("Dein Name: ");
                    String name = input.nextLine();

                    library.lendItem(itemId, name);
                }
                case 0 -> inMenu = false;
            }
        }
    }
}
