package code;
/**
 * Contains the person instance
 * 
 *
 */
public class Person {
	/**
	 * String containing person type
	 */
	String PersonType;
	/**
	 * Person instance constructor
	 * @param personType Desired person type
	 */
	public Person(String personType) {
		this.PersonType = personType;	
	}
	/**
	 * Setter for this person's type
	 * @param personType Desired type
	 */
	public void setPersonType(String personType) {
		this.PersonType = personType;
	}
	/**
	 * Getter for this person's type
	 * @return Current perosn type
	 */
	public String getPersonType() {
		return PersonType;
	}
}
