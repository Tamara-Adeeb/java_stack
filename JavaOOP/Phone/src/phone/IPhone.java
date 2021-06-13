package phone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
	public String ring() {
		
		return String.format("iPhone %s says %s", getVersionNumber(), getRingTone()) ;
	}	

	@Override
	public String unlock() {
		return "Unlocking via face recogntion";
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("iPhone %s from %s", getVersionNumber(), getCarrier()));
		
	}
}
