import java.util.ArrayList;

public class Order {
    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<>();

    // constructor
    public Order() {
        this("Guest");
    }
    public Order (String name) {
        this.name = name;
    }

    // setters and getters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setReady(boolean bool) {
        this.ready = bool;
    }
    public boolean isReady() {
        return this.ready;
    }

    // methods
    public void addItem(Item item) {
        this.items.add(item);
    }
    public String getStatusMessage() {
        if (this.isReady()) {
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public void display() {
        System.out.println("Customer name: " + this.name);
        
        for(Item item : this.items) {
            // total += item.price;
            System.out.printf("%s - $%s\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", this.getOrderTotal());
    }
    public double getOrderTotal() {
        double total = 0;
        for(Item item : this.items) {
            total += item.getPrice();
        }
        return total;
    }
}