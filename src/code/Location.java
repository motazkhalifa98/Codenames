package code;

public class Location {
	String CodeName;
	
	int Reveal;
	public Location(String codeName, int reveal) {
		CodeName = codeName;
		
		Reveal = reveal;
			
	}
	public String getCodeName() {
		return CodeName;
	}
	public void setCodeName(String codeName) {
		CodeName = codeName;
	}
	
	
	public int getReveal() {
		return Reveal;
	}
	public void setReveal(int reveal) {
		Reveal = reveal;
	}
	
}
