package Bank_Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class banksql implements bankoperations{
	public void createaccount(Account account)throws Exception {
		Connection con=sqlconnection.getconnection();
		String q="INSERT INTO Bank(Accno,Name,Password,Balance,Account_type) VALUES(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1,account.getAccountno());
		ps.setString(2,account.getName());
		ps.setInt(3, account.getPassword());
		ps.setInt(4, account.getBalance());
		ps.setString(5,account.getacctype());
		
		ps.executeUpdate();
		System.out.println("YOUR ACCOUNT CREATED SUCCESSFULLY");
		
	}
	
	
	
	public void searchaccount(int saccno) throws Exception{
		Connection con=sqlconnection.getconnection();
		String  q="SELECT * FROM Bank WHERE Accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, saccno);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("ACCOUNT NUMBER :"+rs.getInt("Accno"));
			System.out.println("NAME :"+rs.getString("Name"));
			System.out.println("PASSWORD :"+rs.getInt("Password"));
			System.out.println("YOUR BALANCE :"+rs.getInt("Balance"));
			
		}
		else {
			System.out.println("ACCOUNT NOT FOUND PLZ ENTER VALID ACCOUNT NUMBER");
		}
	}
	
	
	
	public void depositaccount(int daccno,int damount) throws Exception {
		Connection con=sqlconnection.getconnection();
		
		String q="SELECT Name FROM Bank WHERE Accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, daccno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println();
			System.out.println("WELCOME "+rs.getString("Name"));
		}
		
		String q1="UPDATE Bank SET Balance=Balance+? WHERE accno=?";
		PreparedStatement ps1=con.prepareStatement(q1);
		ps1.setInt(1,damount);
		ps1.setInt(2, daccno);
		
		int result=ps1.executeUpdate();
		
		if(result>0) {
			System.out.println("MONEY DEPOSITED SUCCESSFULLY");
		}
		else {
			System.out.println("MONEY NOT DEPOSITED");
		}
		
		
		String q2="SELECT Balance FROM Bank WHERE Accno=?";
		PreparedStatement ps2=con.prepareStatement(q2);
		ps2.setInt(1,daccno);
		ResultSet rs2=ps2.executeQuery();
		if(rs2.next()) {
			System.out.println("YOUR AVAILABLE BALANCE IS "+rs2.getInt("Balance")+" Now!!!!");
		}
	}
	
	
	
	
	public void withdrawaccount(int waccno,int wamount) throws Exception {
		Connection con=sqlconnection.getconnection();
		
		String q2="SELECT Name FROM Bank WHERE Accno=?";
		PreparedStatement ps2=con.prepareStatement(q2);
		ps2.setInt(1, waccno);
		ResultSet rs2=ps2.executeQuery();
		if(rs2.next()) {
			System.out.println();
			System.out.println("WELCOME "+rs2.getString("Name"));
		}
		
		String q="UPDATE Bank SET Balance=Balance-? WHERE accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, wamount);
		ps.setInt(2, waccno);
		
		int result=ps.executeUpdate();
		
		if(result>0) {
			System.out.println("MONEY WITHDRAW SUCCESSFULLY");
		}
		
		else {
			System.out.println("MONEY WAS NOT WITHDRAWL TRY AGAIN");
		}
		
		String q1="SELECT Balance FROM Bank WHERE Accno=?";
		PreparedStatement ps1=con.prepareStatement(q1);
		ps1.setInt(1,waccno);
		ResultSet rs=ps1.executeQuery();
		if(rs.next()) {
			System.out.println("YOUR EXXISTING BALANCE IS :"+rs.getInt("Balance"));
		}
	}
	
	
	
	
	public void transfermoney(int tamount,int from,int to) throws Exception{
		
        int count=0;
		Connection con=sqlconnection.getconnection();
		String q="UPDATE Bank SET Balance=Balance+? WHERE Accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1,tamount);
		ps.setInt(2,to);
		int result1 =ps.executeUpdate();
		if(result1>0) {
			count++;
		}
		
		String q1="UPDATE Bank SET Balance=Balance - ? WHERE Accno=? AND Balance>=?";
		PreparedStatement ps1=con.prepareStatement(q1);
		ps1.setInt(1,tamount);
		ps1.setInt(2,from);
		ps1.setInt(3,tamount);
		int result2=ps1.executeUpdate();
		if(result2>0) {
			count++;
		}
		
		if(count==2) {
			System.out.println();
			System.out.println("MONEY TRANSFERED SUCCESSFULLY");
		}
		else {
			System.out.println();
			System.out.println("INSUFFICIENT BALANCE!!");
		}
		
		String q2="SELECT Balance FROM Bank WHERE Accno=?";
		PreparedStatement ps2=con.prepareStatement(q2);
		ps2.setInt(1,from);
		ResultSet rs2=ps2.executeQuery();
		if(rs2.next()) {
			System.out.println("YOUR AVAILABLE BALANCE IS "+rs2.getInt("Balance")+" RIGHT NOW!!");
		}
		
	}
	
	
	
	public void intrestmoney(int iccno) throws Exception {
		Connection con=sqlconnection.getconnection();
		String q="SELECT Balance,Account_type FROM Bank WHERE Accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, iccno);
		ResultSet rs=ps.executeQuery();
		
		int balance;
		String Acctype;
		
		if(rs.next()) {
			balance=rs.getInt("Balance");
		    Acctype=rs.getString("Account_type");
			
			int intrest;
			if(Acctype.equals("SAVINGS")) {
				intrest=balance*4/100;
			}
			else {
				intrest=0;
			}
			
			System.out.println("YOUR ACCOUT TYPE IS "+Acctype+" AND YOUR INTREST IS ₹"+intrest+"per year AND YOUR BALANCE IS ₹ "+balance+" NOW");
		}
		else {
			System.out.println("ACCOUNT NOT FOUND");
		}
		  		
		}
	
	
	public void deleteaccount(int daccno) throws Exception {
		Connection con=sqlconnection.getconnection();
		String q="DELETE FROM Bank WHERE Accno=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, daccno);
		int result= ps.executeUpdate();
		
		if(result>0) {
			System.out.println("ACCOUNT DELETED SUCCESSFULLY");
		}
		else{
			System.out.println("ACCOUNT NOT DELETED");
			
		}		
		
	}
			
}

