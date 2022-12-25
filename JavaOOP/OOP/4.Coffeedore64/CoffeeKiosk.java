import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // constructor
    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    // methods
    public void addMenuItem(String name, double price, int index) {
        Item item = new Item(name, price);
        item.setIndex(index);
        this.menu.add(index, item); // what if index is greater than size?
    }
    public void displayMenu() {
        for(Item item: menu) {
            System.out.printf("%s %s -- $%.2f\n", item.getIndex(), item.getName(), item.getPrice());
        }
    }
    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order order = new Order(name);
        this.displayMenu();
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            Item item = menu.get(Integer.parseInt(itemNumber));
            order.addItem(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        // as the example below. You may use the order's display method.
        System.out.printf("Tank you, %s. Here are your order details:\n", name);
        order.display();
    }
}