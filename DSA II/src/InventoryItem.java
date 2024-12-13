// Define the InventoryItem class
public class InventoryItem {
    private String productID;
    private String name;
    private double price;
    private int quantity;
    private String category;

    // Constructor
    public InventoryItem(String productID, String name, double price, int quantity, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and Setters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Override toString() for easier display
    @Override
    public String toString() {
        return "ProductID: " + productID + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}
