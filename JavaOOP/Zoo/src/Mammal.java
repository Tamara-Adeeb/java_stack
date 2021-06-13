
public class Mammal {
	int energyLevel;
//	int energyLevel = 100;
	public Mammal() {
		energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return energyLevel;
	}
}
