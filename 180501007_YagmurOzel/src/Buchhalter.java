import java.util.Arrays;

public class Buchhalter extends Mitarbeiter{
	
	private Produkt[] produktKosten;

	public Buchhalter(String vorname, String nachname, String email, String telefonnummer, String personalID,
			String personalPassword, Produkt[] produktKosten) {
		super(vorname, nachname, email, telefonnummer, personalID, personalPassword);
		this.produktKosten = produktKosten;
	}

	@Override
	public String toString() {
		return "Buchhalter [produktKosten=" + Arrays.toString(produktKosten) + ", toString()=" + super.toString()
				+ ", getPersonalID()=" + getPersonalID() + ", getPersonalPassword()=" + getPersonalPassword()
				+ ", getVorname()=" + getVorname() + ", getNachname()=" + getNachname() + ", getEmail()=" + getEmail()
				+ ", getTelefonnummer()=" + getTelefonnummer() + "]";
	}

	public Produkt[] getProduktKosten() {
		return produktKosten;
	}

	public void setProduktKosten(Produkt[] produktKosten) {
		this.produktKosten = produktKosten;
	}
	
	
	

}
