
public class ProjectClass {
	String name;
	String desc;
	double initialCost;

	public ProjectClass() {}
	public ProjectClass(String name) {
		this.name = name;
	}
	public ProjectClass (String name, String  desc, double cost) {
		this.name = name;
		this.desc = desc;
		this.initialCost = cost;
	}
	public String elevatorPitch() {
		return String.format("%s (%.2f): %s", this.name,this.initialCost, this.desc);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getInitialCost() {
		return initialCost;
	}
	public void setInitialCost(double initialCost) {
		this.initialCost = initialCost;
	}
	
}
