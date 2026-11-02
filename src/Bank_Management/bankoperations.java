package Bank_Management;

public interface bankoperations {
	void createaccount(Account account) throws Exception;
	void searchaccount(int saccno) throws Exception;
	void depositaccount(int daccno,int damount) throws Exception;
	void withdrawaccount(int waccno,int wamount) throws Exception;
	void transfermoney(int tamount,int from,int to) throws Exception;
	void intrestmoney(int iaccno) throws Exception;
	void deleteaccount(int daccno) throws Exception;

}
