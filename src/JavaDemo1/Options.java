package JavaDemo1;

import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Options extends Account{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	/* Validate login information customer number and pin number*/
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {
				data.put(987654321, 1234);
				
				System.out.println("Welcome to the ATM project!!!");
				
				System.out.println("Enter your customer number:");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your pin number:");
				setPinNumber(menuInput.nextInt());
			} catch(Exception e) {
				System.out.println("\n"+ "Invalid character(s).Only numbers are allowed." + "\n");
				x=2;
			}
			for (Map.Entry<Integer, Integer> entry: data.entrySet()) {  
				if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) { 
					getAccountType(); 
				}
			}
			System.out.println("\n"+ "Wrong Customer number or Pin Number." + "\n");
		}while(x==1);
	}
	

	/*Display Account Type Menu with selection*/
	public void getAccountType() {
		System.out.println("Enter the Account you want to access:");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice:");
		
		selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank you for using this ATM, bye.");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getAccountType();
		}
	}
	
	/*Display Checking Account Menu with selection*/
	public void getChecking() {
		System.out.println("Checking Account:");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice:");
		
		selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance:" + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye.");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getChecking();
		}
	}
	
	/*Display Saving Account Menu with selection*/
	public void getSaving() {
		System.out.println("Checking Account:");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice:");
		
		selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance:" + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye.");
			break;
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getSaving();
		}
	}
	int selection;
}
