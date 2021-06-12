
public class Samurai extends Human {
	static int numberOfSamuSamurai;

	public Samurai() {
		this.health = 200;
		numberOfSamuSamurai++;
	}
	public void deathBlow(Human attacker) {
		attacker.health = 0;
		this.health = this.health/2;
	}
	public void meditate() {
		this.health += this.health/2;
	}
	
	public static int getNumberOfSamuSamurai() {
		return numberOfSamuSamurai;
	}
}
