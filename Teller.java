package hw3;

import java.math.BigDecimal;

@SuppressWarnings("serial")
class AccountDoesNotExistException extends Exception {
	public AccountDoesNotExistException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class AccountAlreadyExistsException extends Exception {
	public AccountAlreadyExistsException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class CustomerDoesNotExistException extends Exception {
	public CustomerDoesNotExistException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class CustomerAlreadyExistsException extends Exception {
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class InvalidAccountTypeException extends Exception {
	public InvalidAccountTypeException(String message) {
		super(message);
	}
}

/**
 * This class represents a teller which will interact with both a Person class
 * and a BankingSystem class.
 * 
 * @author brown8jt - Josh Brown
 *
 */
public class Teller {

	private Person p;
	private BankingSystem bankSys;

	/**
	 * Public constructor for teller class
	 * 
	 * @param pFName
	 *            - First name of person interacting with teller
	 * @param pLName
	 *            - Last name of person interacting with teller
	 * @param pLicenseNum
	 *            - License number of person interacting with teller
	 */
	public Teller(String pFName, String pLName, int pLicenseNum) {

		// set class attributes
		this.p = new Person(pFName, pLName, pLicenseNum);
		this.bankSys = new BankingSystem();

	}

	/**
	 * This method will try to withdraw a given amount of money from the given
	 * person's given account. If it is a successful withdrawal, it will print a
	 * successful message. Else, it will print an unsuccessful message. The method
	 * will also throw an AccountDoesNotExistException if the given account does not
	 * exist in the banking system.
	 * 
	 * @param pCustomer
	 *            - Person representing the customer
	 * @param pAccountType
	 *            - Account representing the account from which to withdraw from
	 * @param amount
	 *            - BigDecimal amount to withdraw from account
	 * @return - boolean true if transaction was successful, false if unsuccessful
	 * 
	 * @throws AccountDoesNotExistException
	 *             - Person does not have given account
	 * @throws CustomerDoesNotExistException
	 *             - Person does not exist in banking system
	 * @throws NotEnoughFundsException
	 */
	public void withdraw(Person pCustomer, Account pAccount, BigDecimal amount)
			throws AccountDoesNotExistException, CustomerDoesNotExistException, NotEnoughFundsException {

		boolean success = false;

		// verify customer exists
		if (this.bankSys.verifyCustomerExists(pCustomer) == false) {

			// customer does not exist
			throw new CustomerDoesNotExistException("Person " + pCustomer.toString() + " does not exist!");

		} else {

			// customer exists

			// verify that account exists
			if (this.bankSys.verifyAccountExists(pCustomer, pAccount) == false) {

				// account does not exist
				throw new AccountDoesNotExistException("Account with number [" + pAccount.getAccountNumber()
						+ "] does not exist for customer: " + pCustomer.toString());
			} else {
				// account exists -> try to withdraw
				success = pAccount.withdraw(amount);
			}

			// print if withdrawal was successful
			if (success) {
				
				// account has the available funds
				System.out.println("--------------------------------------------");
				System.out.println("Transaction successful!");
				System.out.println("Remaining balance:");
				System.out.println("$" + pAccount.getBalance());
				System.out.println("--------------------------------------------\n");

			} else {
				
				// account does not have the available funds
				System.out.println("--------------------------------------------");
				System.out.println("Error trying to with draw!");
				System.out.println("--------------------------------------------\n");

			}
		}

	}

	/**
	 * This method will try to deposit a given amount to a given person's given
	 * account. The method will throw an AccountDoesNotExistException if the given
	 * account does not exist in the banking system.
	 * 
	 * @param pCustomer
	 *            - Customer for the transaction
	 * @param pAccount
	 *            - Account to be used for deposit
	 * @param amount
	 *            - Amount to be deposited
	 * @throws AccountDoesNotExistException
	 *             - Person does not have given account
	 * @throws CustomerDoesNotExistException
	 *             - Person does not exist in banking system
	 * 
	 */
	public void deposit(Person pCustomer, Account pAccount, BigDecimal amount)
			throws AccountDoesNotExistException, CustomerDoesNotExistException {

		// verify that customer exists
		if (this.bankSys.verifyCustomerExists(pCustomer) == false) {

			// customer does not exist
			throw new CustomerDoesNotExistException("Person " + pCustomer.toString() + " does not exist!");

		} else {

			// customer exists

			// verify that account exists
			if (this.bankSys.verifyAccountExists(pCustomer, pAccount) == false) {

				// account does not exist
				throw new AccountDoesNotExistException("Account with number [" + pAccount.getAccountNumber()
						+ "] does not exist for customer: " + pCustomer.toString());

			} else {

				// account exists -> deposit
				pAccount.deposit(amount);

				// send confirmation
				System.out.println("--------------------------------------------");
				System.out.println("Transaction successful!");
				System.out.println("New balance:");
				System.out.println("$" + pAccount.getBalance());
				System.out.println("--------------------------------------------\n");

			}
		}
	}

	/**
	 * This method will try to add a new customer to the banking system. It will
	 * throw a AccountAlreadyExistsException if the given person already is in the
	 * banking system.
	 * 
	 * @param pCustomer
	 *            - Person to be added to the banking system
	 * 
	 * @throws CustomerAlreadyExistsException
	 *             - Person already exists in banking system
	 */
	public void addPerson(Person pCustomer) throws CustomerAlreadyExistsException {

		// verify that account does not exist
		if (this.bankSys.verifyCustomerExists(pCustomer) == true) {

			// person already exists
			throw new CustomerAlreadyExistsException("Person " + pCustomer.toString() + " already exists!");

		} else {

			// person does not exist in banking system -> add person to system
			this.bankSys.addPerson(pCustomer);

			// send confirmation
			System.out.println("--------------------------------------------");
			System.out.println("Customer successfully added!");
			System.out.println("--------------------------------------------\n");

		}

	}

	/**
	 * This method will try to remove a customer from the banking system. It will
	 * throw an AccountDoesNotExistException if the given person is not in the
	 * banking system.
	 * 
	 * @param pCustomer
	 *            - Person to be removed from the banking system
	 * @throws CustomerDoesNotExistException
	 *             - Person does not exist in banking system
	 */
	public void removePerson(Person pCustomer) throws CustomerDoesNotExistException {

		// verify that customer exists
		if (this.bankSys.verifyCustomerExists(pCustomer) == false) {

			// customer does not exist
			throw new CustomerDoesNotExistException("Person " + pCustomer.toString() + " does not exist!");

		} else {

			// customer exists
			this.bankSys.removePerson(pCustomer);

			// send confirmation
			System.out.println("--------------------------------------------");
			System.out.println("Person successfully removed!");
			System.out.println("--------------------------------------------\n");

		}

	}

	/**
	 * This method will try to open a certain account type for a given customer. The
	 * account type is determined by: 1 = Checking, 2 = Savings. It will throw an
	 * AccountDoesNotExistException if the given person is not in the banking
	 * system.
	 * 
	 * @param pCustomer
	 *            - Person to add the account to
	 * @param accountType
	 *            - Account type to be added (1 = Checking, 2 = Savings)
	 * @throws CustomerDoesNotExistException
	 *             - Person does not exist in banking system
	 * @throws InvalidAccountTypeException
	 *             - An invalid integer was given, could not resolve a valid account
	 *             type
	 * @throws AccountAlreadyExistsException - An account already exists with given id
	 */
	public void openAccount(Person pCustomer, int accountType, int accountNumber)
			throws CustomerDoesNotExistException, InvalidAccountTypeException, AccountAlreadyExistsException {

		// verify that person is in banking system
		if (this.bankSys.verifyCustomerExists(pCustomer) == false) {

			// person is not in banking system
			throw new CustomerDoesNotExistException("Person " + pCustomer.toString() + " does not exist!");

		} else {

			// person is in banking system

			// create new account
			Account newAccount;

			// create account with specific type
			switch (accountType) {

			case 1:
				newAccount = new CheckingAccount(accountNumber, new BigDecimal(0.00));
				break;

			case 2:
				newAccount = new SavingsAccount(accountNumber, new BigDecimal(0.00));
				break;

			default:
				throw new InvalidAccountTypeException(
						"Account type for parameter value: " + accountType + " does not exist!");

			}

			// verify that account exists
			if (this.bankSys.verifyAccountExists(pCustomer, newAccount) == true) {

				// account already exists
				throw new AccountAlreadyExistsException(
						"Customer " + pCustomer.toString() + " already has account with that account number!");
			} else {

				// account does not exist
				this.bankSys.addAccount(pCustomer, newAccount);

				// send confirmation
				System.out.println("--------------------------------------------");
				System.out.println("Account succesfully added!");
				System.out.println("--------------------------------------------\n");

			}

		}

	}

	/**
	 * A different method to open account: uses an already created Account object to add to database.
	 * 
	 * @param pCustomer - Customer to add account to
	 * @param pAccount - Account to be added for customer
	 * @throws CustomerDoesNotExistException - Person does not exist in banking system
	 * @throws AccountAlreadyExistsException - An account already exist with given id
	 */
	public void openAccount(Person pCustomer, Account pAccount)
			throws CustomerDoesNotExistException, AccountAlreadyExistsException {

		// verify that person is in banking system
		if (this.bankSys.verifyCustomerExists(pCustomer) == false) {

			// person is not in banking system
			throw new CustomerDoesNotExistException("Person " + pCustomer.toString() + " does not exist!");

		} else {

			// verify that account exists
			if (this.bankSys.verifyAccountExists(pCustomer, pAccount) == true) {

				// account already exists
				throw new AccountAlreadyExistsException(
						"Customer " + pCustomer.toString() + " already has account with that account number!");
			} else {

				// account does not exist
				this.bankSys.addAccount(pCustomer, pAccount);

				// send confirmation
				System.out.println("--------------------------------------------");
				System.out.println("Account succesfully added!");
				System.out.println("--------------------------------------------\n");


			}

		}

	}
}
