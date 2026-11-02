package Bank_Management;

public class cuurent extends Account {
	
	cuurent(int accno,String name,int pass,int bal){
		super(accno,name,pass,bal);
	}
	
	public int calculateintrest() {
		return 0;
	}
	
	public String getacctype() {
		return "CURRENT";
	}

}
