public abstract class Vehicle {
    public String engine = "Engine";
    public void drive() {
        System.out.println("I am a vehicle driving");
    }
    public abstract void makeNoise();
}