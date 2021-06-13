package phone;
public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ring() {
		
		return String.format("Galaxy %s says %s", getVersionNumber(), getRingTone()) ;
	}	

	@Override
	public String unlock() {
		return "Unlocking via finger print";
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("Galaxy %s from %s", getVersionNumber(), getCarrier()));
		
	}
	

}
