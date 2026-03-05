import java.util.ArrayList;

public class User {

    // Atributen
    private int id;
    private String name;
    private ArrayList<Integer> lentItemIds;

    // Methoden
    public boolean addItem(int itemId) {
        if (lentItemIds.contains(itemId)) {
            return false;
        }
        lentItemIds.add(itemId);
        return true;
    }

    public boolean removeItem(int itemId) {
        if (!lentItemIds.contains(itemId)) {
            return false;
        }
        lentItemIds.remove(Integer.valueOf(itemId));
        return true;
    }

    public boolean hasItem(int itemId) {
        return lentItemIds.contains(itemId);
    }

    // Konstruktor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.lentItemIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLentItemCount() {
        return lentItemIds.size();
    }

    public ArrayList<Integer> getLentItemIds() {
        return lentItemIds;
    }
}
