public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 4.5;
        double dripCoffePrice = 3.0;
        double lattePrice = 4;
        double cappuccinoPrice = 3;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println("\n");
        System.out.print(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder1) {
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + dripCoffePrice);
        }
        else {
            System.out.println(pendingMessage);
        }

        System.out.println("\n");
        System.out.print(generalGreeting + customer4);
        if (isReadyOrder4) {
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        else {
            System.out.println(pendingMessage);
        }

        System.out.println("\n");
        System.out.print(generalGreeting + customer2);
        if (isReadyOrder2) {
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + lattePrice * 2);
        }
        else {
            System.out.println(pendingMessage);
        }

        System.out.println("\n");
        System.out.print(generalGreeting + customer3);
        if (isReadyOrder3) {
            System.out.println(readyMessage);
            double newPrice = dripCoffePrice - lattePrice;
            System.out.println("You ordered a latte but charged for a coffe");
            if (newPrice > 0) {
                System.out.println("You get back $" + newPrice);
            }
            else {
                System.out.println("You have to pay $" + -newPrice + " more");
            }
        }
        else {
            System.out.println(pendingMessage);
        }
    }
}
