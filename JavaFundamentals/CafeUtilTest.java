import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CafeUtilTest {
    public static void main(String[] args) {
    	CafeUtil appTest = new CafeUtil();

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        int[] output = appTest.getStreakGoal(7);
        System.out.printf("Purchases needed by week %s: %s \n\n", output[0], output[1]);
    
        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test -----");
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(loadMenu);

        List<Double> loadPrices = Arrays.asList(
            2.5,
            3.0,
            3.5,
            3.5
        );
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.addAll(loadPrices);
        appTest.displayMenu(menu, prices);
    
        // System.out.println("\n----- Add Customer Test -----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }

        System.out.println("\n----- Add Customers Test -----");
        ArrayList<Object> customers = new ArrayList<Object>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomers(customers);
            System.out.println("\n");
        }

        System.out.println("\n----- Print Price Chart -----");
        appTest.printPriceChart("Espresso", 3, 5);
    }
}
