package phone;

public class test {

	public static void main(String[] args) {
		Galaxy g1 = new Galaxy("s9", 99, "verizon", "ring ring !!");
		g1.displayInfo();
		g1.getCarrier();
		g1.ring();
		System.out.println(g1.ring());
		

	}

}
