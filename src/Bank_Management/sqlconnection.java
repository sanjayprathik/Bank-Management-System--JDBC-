package Bank_Management;
import java.sql.Connection;
import java.sql.DriverManager;

public class sqlconnection  {
	public static Connection getconnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/qsp?user=sanjay&password=newpass123");
		
		
	}
   
}
