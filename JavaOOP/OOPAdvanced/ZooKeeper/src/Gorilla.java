public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		super.setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBanana() {
		System.out.println("the gorilla has eaten a banana");
		super.setEnergyLevel(getEnergyLevel() + 10);
	}
	
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		super.setEnergyLevel(getEnergyLevel() - 10);
	}
}
