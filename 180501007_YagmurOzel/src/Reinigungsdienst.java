import java.util.Arrays;

public class Reinigungsdienst extends Mitarbeiter {
	
	private Produkt[] reinigendePR;

	public Reinigungsdienst(String vorname, String nachname, String email, String telefonnummer, String personalID,
			String personalPassword, Produkt[] reinigendePR) {
		super(vorname, nachname, email, telefonnummer, personalID, personalPassword);
		this.reinigendePR = reinigendePR;
	}

	@Override
	public String toString() {
		return "Reinigungsdienst [reinigendePR=" + Arrays.toString(reinigendePR) + ", toString()=" + super.toString()
				+ ", getPersonalID()=" + getPersonalID() + ", getPersonalPassword()=" + getPersonalPassword()
				+ ", getVorname()=" + getVorname() + ", getNachname()=" + getNachname() + ", getEmail()=" + getEmail()
				+ ", getTelefonnummer()=" + getTelefonnummer() + "]";
	}

	public Produkt[] getReinigendePR() {
		return reinigendePR;
	}

	public void setReinigendePR(Produkt[] reinigendePR) {
		this.reinigendePR = reinigendePR;
	}
	
	

}
