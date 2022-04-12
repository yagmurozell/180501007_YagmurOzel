
public class Mitarbeiter extends Person {
	
	private String personalID;
	private String personalPassword;
	
	public Mitarbeiter(String vorname, String nachname, String email, String telefonnummer,String personalID,String personalPassword) {
		super(vorname, nachname, email, telefonnummer);
		this.personalID = personalID;
		this.personalPassword =personalPassword; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Mitarbeiter [personalID=" + personalID + ", personalPassword=" + personalPassword + ", toString()="
				+ super.toString() + ", getVorname()=" + getVorname() + ", getNachname()=" + getNachname()
				+ ", getEmail()=" + getEmail() + ", getTelefonnummer()=" + getTelefonnummer() + "]";
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}

	public String getPersonalPassword() {
		return personalPassword;
	}

	public void setPersonalPassword(String personalPassword) {
		this.personalPassword = personalPassword;
	}
	

}
