package hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that uses a Map to map customers' unique id to a list of their bank
 * accounts.
 * 
 * @author brown8jt - Josh Brown
 * @since 3/14/2018
 *
 */
public class BankingSystem {

	// map used to represent database of customers and accounts
	private Map<String, ArrayList<Account>> database;

	/**
	 * Constructor for banking system.
	 */
	public BankingSystem() {

		this.database = new HashMap<String, ArrayList<Account>>();

	}

	/**
	 * Verifies if a customer already has given account (using unique id)
	 * 
	 * @param pCustomer
	 *            - Customer to check accounts for
	 * @param pAccount
	 *            - Account used to check for duplicates
	 * @return boolean - true if account already exist, false if account does not
	 *         exist
	 */
	public boolean verifyAccountExists(Person pCustomer, Account pAccount) {

		// convert customers license number integer to string
		String licNumString = Integer.toString(pCustomer.getLicenseNum());

		// get list of accounts for customer
		ArrayList<Account> accountList = this.database.get(licNumString);

		// iterate through account list
		for (int i = 0; i < accountList.size(); i++) {

			// get account at index i
			Account currAccount = accountList.get(i);

			// account has the same account number as current account in list
			if (currAccount.getAccountNumber() == pAccount.getAccountNumber()) {
				return true;
			}

		}

		return false;

	}

	/**
	 * Verifies if customer is in the bank database using the customers' license
	 * number.
	 * 
	 * @param pCustomer
	 *            - Customer used to check for duplicate entries
	 * @return boolean - true if customer is in bank database, false if not
	 */
	public boolean verifyCustomerExists(Person pCustomer) {

		// convert customers license number integer to string
		String licNumString = Integer.toString(pCustomer.getLicenseNum());

		// check if database has customers license number stored
		if (this.database.containsKey(licNumString)) {

			// customer is already in database
			return true;

		} else {

			// customer is not in database
			return false;

		}

	}

	/**
	 * Adds given person to bank database
	 * 
	 * @param pCustomer
	 *            - Customer to be added to bank database
	 */
	public void addPerson(Person pCustomer) {

		// convert customers license number integer to string
		String licNumString = Integer.toString(pCustomer.getLicenseNum());

		// create empty account list for customer
		ArrayList<Account> newAccount = new ArrayList<Account>();

		// add customer with no accounts opened
		this.database.put(licNumString, newAccount);

	}

	/**
	 * Removes given person from bank database
	 * 
	 * @param pCustomer
	 *            - Customer to be removed from bank database
	 */
	public void removePerson(Person pCustomer) {

		// convert customers license number integer to string
		String licNumString = Integer.toString(pCustomer.getLicenseNum());

		// remove customer
		this.database.remove(licNumString);

	}

	/**
	 * Adds a given account to the customers list of accounts
	 * 
	 * @param pCustomer
	 *            - Customer to add account to
	 * @param newAccount
	 *            - Account to be added
	 */
	public void addAccount(Person pCustomer, Account newAccount) {

		// convert customers license number integer to string
		String licNumString = Integer.toString(pCustomer.getLicenseNum());

		// add new account
		this.database.get(licNumString).add(newAccount);

	}

}
