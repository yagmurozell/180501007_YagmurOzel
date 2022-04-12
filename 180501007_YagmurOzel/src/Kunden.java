import java.util.Arrays;

public class Kunden extends Person {
	private String tcNummer;
	private Reservation[] erbetenenRT;
	private Produkt[] gewünschtesPR;
	
	public Kunden(String vorname, String nachname, String email, String telefonnummer, String tcNummer,
			Reservation[] erbetenenRT, Produkt[] gewünschtesPR) {
		super(vorname, nachname, email, telefonnummer);
		this.tcNummer = tcNummer;
		this.erbetenenRT = erbetenenRT;
		this.gewünschtesPR = gewünschtesPR;
		
	}

	@Override
	public String toString() {
		return "Kunden [tcNummer=" + tcNummer + ", erbetenenRT=" + Arrays.toString(erbetenenRT) + ", gewünschtesPR="
				+ Arrays.toString(gewünschtesPR) + ", toString()=" + super.toString() + ", getVorname()=" + getVorname()
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

	public Produkt[] getGewünschtesPR() {
		return gewünschtesPR;
	}

	public void setGewünschtesPR(Produkt[] gewünschtesPR) {
		this.gewünschtesPR = gewünschtesPR;
	}


	

}
