
public class Administrator extends Mitarbeiter {
	
	private String adminCode;

	public Administrator(String vorname, String nachname, String email, String telefonnummer, String personalID,
			String personalPassword, String adminCode) {
		super(vorname, nachname, email, telefonnummer, personalID, personalPassword);
		this.adminCode = adminCode;
	}

	@Override
	public String toString() {
		return "Administrator [adminCode=" + adminCode + ", toString()=" + super.toString() + ", getPersonalID()="
				+ getPersonalID() + ", getPersonalPassword()=" + getPersonalPassword() + ", getVorname()="
				+ getVorname() + ", getNachname()=" + getNachname() + ", getEmail()=" + getEmail()
				+ ", getTelefonnummer()=" + getTelefonnummer() + "]";
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
	

}
