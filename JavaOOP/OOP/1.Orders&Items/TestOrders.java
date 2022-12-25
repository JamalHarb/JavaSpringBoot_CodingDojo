import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        item1.name = "mocha";
        item1.price = 4.5;
        item2.name = "dripCoffe";
        item2.price = 3.0;
        item3.name = "latte";
        item3.price = 4;
        item4.name = "cappuccino";
        item4.price = 3;
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        order1.name = "Cindhuri";
        order1.ready = true;

        order2.name = "Jimmy";
        order2.items.add(item1);
        for(Item item : order2.items) {
            order2.total += item.price;
        }
        order2.ready = true;

        order3.name = "Noah";
        order3.items.add(item4);

        order4.name = "Sam";
        order4.items.add(item3);
        order4.items.add(item3);
        order4.items.add(item3);
        for(Item item : order4.items) {
            order4.total += item.price;
        }
    
        // Application Simulations
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Order 2 total = $%s\n", order2.total);
        System.out.printf("Order 4 total = $%s\n", order4.total);
        System.out.println(order4.items);
        // System.out.println(item1);
    }
}
