import java.lang.Math;
import java.util.Random;

public class BankAccount {
	String accountNumber="";
	private double checkingBalance;
	private double savingsBalance;
	static int numberOfAccounts = 0;
	static double track;
	
	public BankAccount() {
		this.accountNumber = accountNumber( );
		numberOfAccounts++;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public String accountNumber( ) {
		Random r = new Random ();
		for (int i=1;i<=10;i++) {
			accountNumber+=r.nextInt(10);
			
		}
		return accountNumber; 
		
	}
	
	public void de (double amount , int x ) {
		double y =0 ;
		if (x==1) {
			y= getCheckingBalance()+amount;
			setCheckingBalance(y);
			System.out.println("checking is "+getCheckingBalance());
			
			
		}else if(x ==2) {
			y =getSavingsBalance()+amount ;
			setSavingsBalance(y);
			System.out.println("saving  "+getSavingsBalance());
			
		}
		track = getCheckingBalance()+getSavingsBalance();
		System.out.println(track);
		
	}
	public void withdrawMoney(double amount, int num) {
		
			if(num == 1) {
				if(getCheckingBalance()-amount > 0) {
				setCheckingBalance((getCheckingBalance()-amount));
	//			this.checkingBalance -= amount;
				}
				else { System.out.println("you dont have enough money in your Checking Balance");}
			}
		else if (num == 2) {
			if(getSavingsBalance()-amount > 0) {
			setSavingsBalance((getSavingsBalance()-amount));
//			this.savingsBalance -= amount;
			}
			else { System.out.println("you dont have enough money in your Saving Balance");}
		}
	}
	
	public void totalMoney() {
		System.out.println("your total account" + (getCheckingBalance()+getSavingsBalance()));
	}
	
	
}
