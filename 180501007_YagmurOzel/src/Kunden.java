import java.util.Arrays;

public class Kunden extends Person {
	private String tcNummer;
	private Reservation[] erbetenenRT;
	private Produkt[] gew�nschtesPR;
	
	public Kunden(String vorname, String nachname, String email, String telefonnummer, String tcNummer,
			Reservation[] erbetenenRT, Produkt[] gew�nschtesPR) {
		super(vorname, nachname, email, telefonnummer);
		this.tcNummer = tcNummer;
		this.erbetenenRT = erbetenenRT;
		this.gew�nschtesPR = gew�nschtesPR;
		
	}

	@Override
	public String toString() {
		return "Kunden [tcNummer=" + tcNummer + ", erbetenenRT=" + Arrays.toString(erbetenenRT) + ", gew�nschtesPR="
				+ Arrays.toString(gew�nschtesPR) + ", toString()=" + super.toString() + ", getVorname()=" + getVorname()
				+ ", getNachname()=" + getNachname() + ", getEmail()=" + getEmail() + ", getTelefonnummer()="
				+ getTelefonnummer() + "]";
	}

	public String getTcNummer() {
		return tcNummer;
	}

	public void setTcNummer(String tcNummer) {
		this.tcNummer = tcNummer;
	}

	public Reservation[] getErbetenenRT() {
		return erbetenenRT;
	}

	public void setErbetenenRT(Reservation[] erbetenenRT) {
		this.erbetenenRT = erbetenenRT;
	}

	public Produkt[] getGew�nschtesPR() {
		return gew�nschtesPR;
	}

	public void setGew�nschtesPR(Produkt[] gew�nschtesPR) {
		this.gew�nschtesPR = gew�nschtesPR;
	}


	

}
