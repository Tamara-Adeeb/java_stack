
public class HumanTest {

	public static void main(String[] args) {
		Ninja mohammad = new Ninja();
		Wizard ahmad = new Wizard();
		Samurai amro = new Samurai();
		mohammad.steal(amro);
		mohammad.runAway();
		ahmad.fireball(mohammad);
		ahmad.heal(mohammad);
		amro.meditate();
		amro.deathBlow(ahmad);
		System.out.println(amro.health);
		System.out.println(mohammad.health);
		System.out.println(ahmad.health);
		System.out.println(amro.getNumberOfSamuSamurai());

	}
}
	