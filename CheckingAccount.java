package hw3;

import java.math.BigDecimal;

/**
 * This class represents a checking account
 * 
 * @author brown8jt - Josh Brown
 * @since 3/14/2018
 *
 */
public class CheckingAccount extends Account {

	/**
	 * Constructor that calls to the abstract super class Account
	 * 
	 * @param pAccountNumber
	 *            - Integer representing unique account number
	 * @param pBalance
	 *            - BigDecimal number representing the starting balance
	 */
	public CheckingAccount(int pAccountNumber, BigDecimal pBalance) {
		super(pAccountNumber, pBalance);

	}

	@Override
	/**
	 * This method will withdraw a given amount from the account. The account can go
	 * negative; if so, the system will send message to teller.
	 * 
	 * @param pAmount
	 *            - Amount to be withdrawn from account balance
	 */
	public boolean withdraw(BigDecimal pAmount) {

		boolean success = false;

		if (pAmount.compareTo(new BigDecimal(0.00)) == -1) {

			// amount passed was less than 0.00
			return false;

		} else {

			// set balance to current balance minus amount withdrawn
			this.setBalance(this.getBalance().subtract(pAmount));

			// withdrawal was successful
			success = true;

		}

		// return message saying if account was overdrawn
		if (this.getBalance().compareTo(new BigDecimal(0.00)) == -1) {

			System.out.println("--------------------------------------------");
			System.out.println("Account was overdrawn!");
			System.out.println("--------------------------------------------\n");

		}

		return success;

	}

}
