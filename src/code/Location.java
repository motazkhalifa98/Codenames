package code;
/**
 * contains Location instances
 * 
 *
 */
public class Location {
	/**
	 * String that holds the codename for this Location
	 */
	String CodeName;
	/**
	 * Person object for this Location instance
	 */
	Person PersonType;
	/**
	 * 1 if revealed, 0 if not
	 */
	int Reveal;
	/**
	 * Location contructor
	 * @param codeName codename from file
	 * @param personType red/blue/assassin/innocent
	 * @param reveal should start as 0
	 */
	public Location(String codeName, Person personType, int reveal) {
		CodeName = codeName;
		PersonType = personType;
		Reveal = reveal;
			
	}
	/**
	 * Getter for this Location's codename
	 * @return the current codename
	 */
	public String getCodeName() {
		return CodeName;
	}
	/**
	 * Setter for this Location's codename
	 * @param codeName the desired codename
	 */
	public void setCodeName(String codeName) {
		CodeName = codeName;
	}
	/**
	 * Getter for this Location's person type
	 * @return current type of person
	 */
	public Object getPersonType() {
		return PersonType;
	}
	/**
	 * Setter for this Location's person type
	 * @param personType desired person type
	 */
	public void setPersonType(Person personType) {
		PersonType = personType;
	}
	/**
	 * Getter for the reveal status of this Location
	 * @return 1 if revealed, 0 otherwise
	 */
	public int getReveal() {
		return Reveal;
	}
	/**
	 * Setter for this Location's reveal status
	 * @param reveal Desired reveal status: 1 or 0
	 */
	public void setReveal(int reveal) {
		Reveal = reveal;
	}
	
}
