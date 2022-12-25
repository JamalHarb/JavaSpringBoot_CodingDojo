public class Test {
    public static void main(String[] args) {
        // Vehicle v1 = new Vehicle(); // doesn't work bcz abstract classes cannot be instantiated
        Vehicle v1 = new Car(); // v1 is car object hidden behind vehicle
        System.out.println(v1);
        // v1.move(); // doesn't work bcz move is not defined in vehicle
        v1.drive(); // envokes car drive method bcz it has priority. if doesn't exist in car it will envoke from vehicle
    }
}