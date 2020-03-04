package hw3;

/**
 * The Person class represents a person who will be using the banking system.
 * 
 * @author brown8jt - Josh Brown
 * @since 2/28/2019
 *
 */

public class Person {

	private String fName, lName;
	private int licenseNum;

	/**
	 * Public constructor for person class
	 * 
	 * @param pFName
	 *            - First name of person
	 * @param pLName
	 *            - Last name of person
	 * @param pLicenseNum
	 *            - License number of person
	 */
	public Person(String pFName, String pLName, int pLicenseNum) {

		// set class attributes
		this.fName = pFName;
		this.lName = pLName;
		this.licenseNum = pLicenseNum;

	}

	/**
	 * Returns the first name of the person
	 * 
	 * @return String representing the first name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * Returns the last name of the person
	 * 
	 * @return - String representing the last name
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * Returns the license number of the person
	 * 
	 * @return - int representing the license number
	 */
	public int getLicenseNum() {
		return licenseNum;
	}

	/**
	 * Sets the person's first name with the given first name
	 * 
	 * @param fName
	 *            - String representing the new first name
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * Sets the person's last name with the given last name
	 * 
	 * @param lName
	 *            - String representing the new last name
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * Sets the person's license number with the given number
	 * 
	 * @param licenseNum
	 *            - int representing the new license number
	 */
	public void setLicenseNum(int licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String toString() {
		return "[First: " + this.fName + ", Last: " + this.lName + ", License num: " + this.licenseNum + "]";
	}

}