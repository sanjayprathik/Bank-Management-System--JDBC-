package Bank_Management;

public abstract class Account {
	private int Accountno;
	private String Name;
	private int Balance;
	private int Password;
	
	Account(int accno,String name,int pass,int bal){
		this.Accountno=accno;
		this.Name=name;
		this.Password=pass;
		this.Balance=bal;
	}
	
	public int getAccountno() {
		return Accountno;
	}
	
	public String getName(){
		return Name;
	}
	
	public int getBalance() {
		return Balance;
	}
	
	public int getPassword() {
		return Password;
	}
	
	public abstract int calculateintrest();
	public abstract String getacctype();

}
