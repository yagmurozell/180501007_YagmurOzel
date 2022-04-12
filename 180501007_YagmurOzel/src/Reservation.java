import java.util.Arrays;

public class Reservation {
	
	private String reservationsNr ;
	private Kunden[] kunde;
	private ReservationsTermin[] reservationsTermine;
	

	public Reservation(String reservationsNr, Kunden[] kunde, ReservationsTermin[] reservationsTermine) {
		super();
		this.reservationsNr = reservationsNr;
		this.kunde = kunde;
		this.reservationsTermine = reservationsTermine;
	}
	

	@Override
	public String toString() {
		return "Reservation [reservationsNr=" + reservationsNr + ", kunde=" + Arrays.toString(kunde)
				+ ", reservationsTermine=" + Arrays.toString(reservationsTermine) + "]";
	}


	public String getReservationsNr() {
		return reservationsNr;
	}

	public void setReservationsNr(String reservationsNr) {
		this.reservationsNr = reservationsNr;
	}

	public Kunden[] getKunde() {
		return kunde;
	}

	public void setKunde(Kunden[] kunde) {
		this.kunde = kunde;
	}
	
	

}
