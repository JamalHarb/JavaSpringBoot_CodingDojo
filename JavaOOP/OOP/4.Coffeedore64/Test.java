public class Test {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        kiosk.addMenuItem("latte", 3.5, 0);
        kiosk.addMenuItem("coffee", 2.5, 1);
        kiosk.addMenuItem("vanilla", 4, 2);
        kiosk.addMenuItem("banana", 1.5, 3);

        kiosk.newOrder();
    }
}