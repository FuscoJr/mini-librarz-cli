import java.time.LocalDateTime;

public class Item {
    // Atributen
    private int id;
    private String titel;
    private ItemType type;
    private boolean isLent;
    private Integer lentToUserId = null;
    private LocalDateTime lentDate = null;

    // Methoden

    public boolean lendTo(int userId) {
        if (!isAvailable()) {
            return false;
        }
        isLent = true;
        lentToUserId = userId;
        lentDate = LocalDateTime.now();

        return true;
    }

    public boolean returnItem() {
        if (isAvailable()) {
            return false;
        }
        isLent = false;
        lentDate = null;
        lentToUserId = null;
        return true;
    }

    public boolean isAvailable() {
        if (isLent) {
            return false;
        }
        return true;
    }

    // Konstruktor
    public Item(int id, String titel, ItemType type) {
        this.id = id;
        this.titel = titel;
        this.type = type;
        this.isLent = false;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public Integer getLentToUserId() {
        return lentToUserId;
    }

    public ItemType getType() {
        return type;
    }

    public LocalDateTime getLentDate() {
        return lentDate;
    }

}
