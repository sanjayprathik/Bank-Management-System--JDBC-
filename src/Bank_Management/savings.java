package Bank_Management;

public class savings extends Account {
	
	int intrest;

	savings(int accno,String name,int pass,int bal){
		super(accno,name,pass,bal);
		
	}
	
	public int calculateintrest() {
		intrest=getBalance()*4/100;
		return intrest;
		
	}
	
	public String getacctype() {
		return "SAVINGS";
	}

}
