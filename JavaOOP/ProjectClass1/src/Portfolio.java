import java.util.*;
public class Portfolio {
	ArrayList<ProjectClass> projects = new ArrayList<ProjectClass>();
	
	public Portfolio() {
		this.projects = projects;
	}

	public ArrayList<ProjectClass> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<ProjectClass> projects) {
		this.projects = projects;
	}
	public double getPortfolioCost() {
		double cost = 0;
		for(int i = 0; i<projects.size(); i++) {
		cost += projects.get(i).getInitialCost();
//		System.out.println(projects.get(i).elevatorPitch());
		}
		return cost;
	}
	public void showPortfolio() {
		double x = getPortfolioCost();
		for(int i = 0; i<projects.size(); i++) {
			System.out.println(projects.get(i).elevatorPitch()+ " " + x );	
			}
	}
	
}
