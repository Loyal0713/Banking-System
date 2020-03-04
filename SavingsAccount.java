package hw3;

import java.math.BigDecimal;

@SuppressWarnings("serial")
class NotEnoughFundsException extends Exception {
	public NotEnoughFundsException(String message) {
		super(message);
	}
}

/**
 * This class represents a savings account
 * 
 * @author brown8jt - Josh Brown
 * @since 3/14/2018
 *
 */
public class SavingsAccount extends Account {

	/**
	 * Constructor that calls to abstract super class Account
	 * 
	 * @param pAccountNumber
	 *            - Integer representing the unique account number
	 * @param pBalance
	 *            - BigDecimal number representing the starting balance
	 */
	public SavingsAccount(int pAccountNumber, BigDecimal pBalance) {
		super(pAccountNumber, pBalance);

	}

	@Override
	/**
	 * This method will try to withdraw a given amount from the account balance if
	 * there are available funds. If there is not enough funds in the account, the
	 * current balance will be shown and a NotEnoughFundsException thrown.
	 * 
	 * @param pAmount
	 *            - Amount to be withdrawn if possible
	 * @return boolean - true if withdrawal was successful
	 * 
	 */
	public boolean withdraw(BigDecimal pAmount) throws NotEnoughFundsException {

		// check if balance is less than amount to be withdrawn
		if (this.getBalance().subtract(pAmount).compareTo(new BigDecimal(0.00)) == -1) {

			// show current balance
			System.out.println("--------------------------------------------");
			System.out.println("Current balance:");
			System.out.println("$" + this.getBalance());
			System.out.println("--------------------------------------------\n");

			// account does not have available funds
			throw new NotEnoughFundsException("Withdraw amount requested exceeds available funds!");

		} else {

			// subtract amount from balance
			this.setBalance(this.getBalance().subtract(pAmount));
			
			return true;

		}

	}

}
