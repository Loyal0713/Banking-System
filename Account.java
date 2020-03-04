package hw3;

import java.math.BigDecimal;

/**
 * Abstract class that represents a bank account
 * 
 * @author brown8jt - Josh Brown
 * @since 3/14/2018
 *
 */
public abstract class Account {

	// int representing unique account number
	private int accountNumber;

	// BigDecimal representing account balance
	private BigDecimal balance;

	/**
	 * Constructor for account; sets account number and balance with given values
	 * 
	 * @param pAccountNumber
	 *            - Integer representing unique account number
	 * @param pBalance
	 *            - BigDecimall representing starting balance
	 */
	public Account(int pAccountNumber, BigDecimal pBalance) {
		this.accountNumber = pAccountNumber;
		this.balance = pBalance;
	}

	/**
	 * Method used to withdraw money from account
	 * 
	 * @param pAmount
	 *            - amount to be withdrawn
	 * @return boolean - true if withdrawal was successful, false if not
	 * @throws NotEnoughFundsException
	 *             - Amount to be withdrawn exceeded account balance
	 */
	public abstract boolean withdraw(BigDecimal pAmount) throws NotEnoughFundsException;

	/**
	 * Returns unique account number
	 * 
	 * @return Unique account number
	 */
	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * Returns account balance
	 * 
	 * @return BigDecimal representing the account balance
	 */
	public BigDecimal getBalance() {
		return this.balance;
	}

	/**
	 * Sets balance to given amount
	 * @param pNewBalance - Amount for balance to be set to
	 */
	public void setBalance(BigDecimal pNewBalance) {
		this.balance = pNewBalance;
	}

	/**
	 * Adds given amount to balance
	 * @param pAmount - Amount to be added to current balance
	 */
	public void deposit(BigDecimal pAmount) {
		this.balance = this.balance.add(pAmount);
	}
}
