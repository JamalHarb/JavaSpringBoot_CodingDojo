import java.util.ArrayList;

public class CafeUtil {
    public int[] getStreakGoal() {
        int sum = 0;
        for(int i = 1; i <= 10; i++){
            sum += i;
        }
        int[] output = new int[2];
        output[0] = 10;
        output[1] = sum;
        return output;
    }
    public int[] getStreakGoal(int numWeeks) {
        int sum = 0;
        for(int i = 1; i <= numWeeks; i++){
            sum += i;
        }
        int[] output = new int[2];
        output[0] = numWeeks;
        output[1] = sum;
        return output;
    }
    public double getOrderTotal(double[] prices){
        double sumPrices = 0;
        for(double price : prices){
            sumPrices += price;
        }
        return sumPrices;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for(String item : menuItems) {
            System.out.println(menuItems.indexOf(item) + " " + item);
        }
    }
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if(menuItems.size() == prices.size()) {
            for(int i = 0; i < prices.size(); i++) {
                System.out.printf("%s %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
            }
            return true;
        }
        else {
            System.out.println("Sizes of menu items and prices do not match");
            return false;
        }
    }
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for(int i = 0; i < maxQuantity; i++) {
            System.out.printf("%s - $%.2f\n", i+1, price*(i+1) - i*0.5);
        }
    }
    public void addCustomers(ArrayList<Object> customers) {
        System.out.println("Please enter your name(s): (enter q to finish)");
        ArrayList<String> users = new ArrayList<String>();
        // String userName = System.console().readLine();
        while(true) {
            String userName = System.console().readLine();
            if(! userName.equals("q")) {
                users.add(userName);
            }
            else {
                break;
            }
        }
        System.out.println("Hello, " + users);
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(users);
        System.out.println(customers);
    }
}