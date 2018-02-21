package code;

public class Person extends Location {
	String CodeName;
	Object PersonType;
	int Reveal;
	public Person(String codeName, Object personType, int reveal) {
		CodeName = codeName;
		PersonType = personType;
		Reveal = reveal;
		
		
		
	}
	public String getCodeName() {
		return CodeName;
	}
	public void setCodeName(String codeName) {
		CodeName = codeName;
	}
	public Object getPersonType() {
		return PersonType;
	}
	public void setPersonType(Object personType) {
		PersonType = personType;
	}
	public int getReveal() {
		return Reveal;
	}
	public void setReveal(int reveal) {
		Reveal = reveal;
	}
	
}
