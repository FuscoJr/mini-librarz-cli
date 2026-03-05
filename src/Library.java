

import java.util.ArrayList;

public class Library {

    // Atributen
    private ArrayList<Item> items;
    private ArrayList<User> users;
    private int maxLoansPerUser;

    // Methoden

    // Suchen
    public Item findItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Erstelllen
    public User createUser(String name) {
        int id = users.size() + 1;
        User user = new User(id, name);
        users.add(user);

        return user;
    }

    // Optionen
    public boolean addItem(String title, ItemType type) {
        int id = items.size() + 1;
        Item item = new Item(id, title, type);
        items.add(item);

        return true;
    }

    public boolean removeItem(int itemId) {
        return false;
    }

    public boolean lendItem(int itemId, String userName) {
        Item item = findItemById(itemId);
        if (item == null) return false;

        if (!item.isAvailable()) return false;

        User user = findUserByName(userName);
        if (user == null) user = createUser(userName);

        if (user.getLentItemCount() >= maxLoansPerUser) {
            return false;
        }

        if (!item.lendTo(user.getId())) return false;

        user.addItem(itemId);

        return true;
    }

    public boolean returnItem(int itemId) {
        Item item = findItemById(itemId);

        if (item == null) return false;
        if (item.isAvailable()) return false;

        int userId = item.getLentToUserId();

        User user = findUserById(userId);

        if (user != null) {
            user.removeItem(itemId);
        }

        item.returnItem();

        return true;
    }

    // Listen
    public void showAvailableItems() {

        System.out.println("\n=== VERFÜGBARE ARTIKEL ===");

        for (Item item : items) {
            if (item.isAvailable()) {

                System.out.println(
                        item.getId() + " | " +
                                item.getTitel() + " | " +
                                item.getType() + " | VERFÜGBAR"
                );

            }
        }
    }

    public void showLentItems() {

        System.out.println("\n=== AUSAGELIEHENE ARTIKEL ===");

        for (Item item : items) {
            if (!item.isAvailable()) {

                int userId = item.getLentToUserId();
                User user = findUserById(userId);

                String userName = (user != null) ? user.getName() : "UNBEKANNT";

                System.out.println(
                        item.getId() + " | " +
                                item.getTitel() + " | " +
                                item.getType() + " | ausgeliehen an: " +
                                userName + " | Seit: " +
                                item.getLentDate()
                );
            }
        }
    }

    public void showStats() {

        int lent = 0;

        for (Item item : items) {
            if (!item.isAvailable()) {
                lent++;
            }
        }

        System.out.println("\n=== BIBLIOTHEK INVENTAR ===");
        System.out.println("Gesamtze Artikel: " + items.size());
        System.out.println("Geliehene Artikel: " + lent);
        System.out.println("Verfügbare Artikel: " + (items.size() - lent));
        System.out.println("Kunden: " + users.size());
    }

    public void showUserItems(String name) {

        User user = findUserByName(name);

        if (user == null) {
            System.out.println("Kunde nicht gefunden.");
            return;
        }

        System.out.println("\n=== DEINE AUSGELIEHENEN ARTIKEL ===");

        for (Integer itemId : user.getLentItemIds()) {
            Item item = findItemById(itemId);

            if (item != null) {
                System.out.println(
                        item.getId() + " | " +
                                item.getTitel() + " | " +
                                item.getType() + " | " +
                                item.getLentDate()
                );
            }
        }
    }

    // Konstruktor
    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
        maxLoansPerUser = 3;
    }
}
