
public class Bat extends Mammal {
	public Bat() {
		energyLevel = 300;
	}
	public void fly() {
		energyLevel -= 50;
	}
	public void eatHumans() {
		energyLevel += 25;
	}
	public void attackTown() {
		energyLevel -= 100;
	}

}
