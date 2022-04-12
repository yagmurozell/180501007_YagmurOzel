import java.util.Arrays;

public class Kundendienst extends Mitarbeiter {
	
	private Reservation[] bestatigendeRT;

	public Kundendienst(String vorname, String nachname, String email, String telefonnummer, String personalID,
			String personalPassword, Reservation[] bestatigendeRT) {
		super(vorname, nachname, email, telefonnummer, personalID, personalPassword);
		this.bestatigendeRT = bestatigendeRT;
	}

	@Override
	public String toString() {
		return "Kundendienst [bestatigendeRT=" + Arrays.toString(bestatigendeRT) + ", toString()=" + super.toString()
				+ ", getPersonalID()=" + getPersonalID() + ", getPersonalPassword()=" + getPersonalPassword()
				+ ", getVorname()=" + getVorname() + ", getNachname()=" + getNachname() + ", getEmail()=" + getEmail()
				+ ", getTelefonnummer()=" + getTelefonnummer() + "]";
	}

	public Reservation[] getBestatigendeRT() {
		return bestatigendeRT;
	}

	public void setBestatigendeRT(Reservation[] bestatigendeRT) {
		this.bestatigendeRT = bestatigendeRT;
	}
	
	
	

}
