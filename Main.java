package hw3;

import java.math.BigDecimal;

public class Main {

	public static void main(String args[]) throws CustomerAlreadyExistsException, CustomerDoesNotExistException,
			InvalidAccountTypeException, AccountAlreadyExistsException, AccountDoesNotExistException, NotEnoughFundsException {

		// create person
		Person p1 = new Person("Josh", "Brown", 123456789);

		// create teller
		Teller t1 = new Teller("Billy", "Joel", 987654321);

		// add person to bank database
		t1.addPerson(p1);

		// attempt to add same person again - works
		// t1.addPerson(p1);

		// random numbersfor accounts
		int checkingAccountNum = 46567163;
		int savingsAccountNum = 654684155;
		
		// balances for accounts
		BigDecimal checkAccBal = new BigDecimal(100.00);
		BigDecimal savingAccBal = new BigDecimal(50.00);
		
		//create accounts
		Account checkingAcc = new CheckingAccount(checkingAccountNum, checkAccBal);
		Account savingAcc = new SavingsAccount(savingsAccountNum, savingAccBal);
		
		//open accounts
		t1.openAccount(p1, checkingAcc);
		t1.openAccount(p1, savingAcc);
		
		//reopen accounts - works
		//t1.openAccount(p1, checkingAcc);
		//t1.openAccount(p1, savingAcc);
		
		//withdraw 50 from checking - works
		t1.withdraw(p1, checkingAcc, new BigDecimal(50.00));
		
		//withdraw 75 from checking - works
		t1.withdraw(p1, checkingAcc, new BigDecimal(75.00));
		
		//deposit 50 to checking - works
		t1.deposit(p1, checkingAcc, new BigDecimal(50.00));
		
		//withdraw 50 from savings - works
		t1.withdraw(p1, savingAcc, new BigDecimal(50.00));
		
		//withdraw 50 from savings again - works
		t1.withdraw(p1, savingAcc, new BigDecimal(50.00));

	}

}
