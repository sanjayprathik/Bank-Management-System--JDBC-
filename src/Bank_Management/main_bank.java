package Bank_Management;
import java.util.Scanner;

public class main_bank {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("                        --------WELCOME TO OUR BANK--------                            ");
		System.out.println("PREE 1 TO CREATE ACCOUNT");
		System.out.println("PREE 2 TO DISPLAY YOUR DETAILS");
		System.out.println("PRESS 3 TO DEPOSIT");
		System.out.println("PRESS 4 TO WITHDRAW");
		System.out.println("PRESS 5 TO TRANSFER MONEY");
		System.out.println("PRESS 6 TO CALCULATE INTREST");
		System.out.println("PRESS 7 TO DELETE YOUR ACCOUNT");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println();
		
		System.out.print("ENTER YOUR CHOICE :");
		int choice=sc.nextInt();
		System.out.println();
		
		
		Account account;
		bankoperations operation=new banksql();
		if(choice==1) {
			System.out.print("SET ACCOUNT NUMBER :");
			int accno=sc.nextInt();
			
			System.out.print("SET YOUR NAME :");
			String name=sc.next();
			
			System.out.print("SET YOUR PASSWORD :");
			int pass=sc.nextInt();
			
			System.out.print("SET YOUR INTIAL BALANCE :");
			int bal=sc.nextInt();
			
			System.out.println();
			System.out.println("WHICH TYPE ACCOUNT DO YOU WANT SAVINGS OR CURRENT");
			System.out.print("PRESS 1 TO CREATE SAVINGS AACOUNT OR PRESS 2 TO CREATE CURRENT ACCOUNT :");
			int acctype=sc.nextInt();
			
			if(acctype==1) {
				account=new savings(accno,name,pass,bal);
			}
			else {
				account=new cuurent(accno,name,pass,bal);
			}
			
		
			operation.createaccount(account);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
				
		}
		
		
		else if(choice==2){
			System.out.print("ENTER YOUR ACCOUNT NUMBER :");
			int saccno=sc.nextInt();
			operation.searchaccount(saccno);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
			
		}
		
		else if(choice==3) {
			System.out.print("ENTER YOUR ACCOUNT NUMBER :");
			int daccno=sc.nextInt();
			
			System.out.print("ENTER YOUR DEPOSIT AMOUNT :");
			int damount=sc.nextInt();
			
			operation.depositaccount(daccno,damount);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
		}
		
		
		else if(choice==4) {
			System.out.print("ENTER YOUR ACCOUNT NUMBER :");
			int waccno=sc.nextInt();
			
			System.out.print("ENTER YOUR WITHDRAW AMOUNT :");
			int wamount=sc.nextInt();
			
			operation.withdrawaccount(waccno,wamount);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
		}
		
		
		else if(choice==5) {
			System.out.print("ENTER YOUR ACCOUNT NUMBER :");
			int from=sc.nextInt();
			
			System.out.print("ENTER RECIVER AACOUNT NUMBER :");
			int to=sc.nextInt();
			
			System.out.print("ENTER AMOUNT :");
			int tamount=sc.nextInt();
			
			operation.transfermoney(tamount,from,to);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
		}
		
		
		else if(choice==6) {
			System.out.print("ENTER ACCOUNT NUMBER :");
			int iaccno=sc.nextInt();
			
			operation.intrestmoney(iaccno);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
		}
		
		
		else if(choice==7) {
			System.out.print("ENTER YOUR ACCOUNT NUMBER :");
			int daccno=sc.nextInt();
			
			operation.deleteaccount(daccno);
			System.out.println();
			System.out.println("THANK YOU!!!!!");
		}
		
		else {
			System.out.println("ENTER VALID NUMBER");
		}

	}

}
