
public class ProjectTest {

	public static void main(String[] args) {
		ProjectClass test = new ProjectClass("Tamara","java-OOP", 0.2);
		System.out.println(test.getName());
		System.out.println(test.elevatorPitch());
		Portfolio print = new Portfolio();
		print.projects.add(test);
		print.showPortfolio();
	}

}
