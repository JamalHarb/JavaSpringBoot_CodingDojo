public class Bat extends Mammal {
	
	public Bat() {
		super.setEnergyLevel(300); 
	}
	
	public void fly() {
		System.out.println("zik zik");
		super.setEnergyLevel(getEnergyLevel() - 50);
	}
	
	public void eatHuman() {
		super.setEnergyLevel(getEnergyLevel() + 25);
	}
	
	public void attackTown() {
		System.out.println("check crack");
		super.setEnergyLevel(getEnergyLevel() - 100);
	}

}
