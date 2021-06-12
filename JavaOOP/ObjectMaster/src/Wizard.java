
public class Wizard extends Human {
	public Wizard() {
		super();
		this.health = 50;
		this.intelligence = 8;
	}
	public void heal(Human player) {
		player.health += this.intelligence;
	}
	public void fireball(Human attacker) {
		attacker.health -= this.intelligence * 3;
	}
}
