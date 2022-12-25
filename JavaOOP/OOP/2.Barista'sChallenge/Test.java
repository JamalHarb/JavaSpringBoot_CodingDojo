public class Test {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Jimmy");
        Order order4 = new Order("Sam");
        Order order5 = new Order("Jack");

        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("latte", 3);
        Item item3 = new Item("coffe", 2.5);
        Item item4 = new Item("espresso", 4.5);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item3);
        order3.addItem(item3);
        order3.addItem(item4);
        order4.addItem(item2);
        order4.addItem(item4);

        order1.display();
        order2.display();
        order3.display();
        order4.display();

        order3.setReady(true);
        order4.setReady(false);
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
    }
}