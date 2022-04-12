import java.util.Date;

public class ReservationsTermin {
	
	private Date datum;
	private String reservationsStart;
	private String reservationsEnde;
	
	
	public ReservationsTermin(Date datum, String reservationsStart, String reservationsEnde) {
		super();
		this.datum = datum;
		this.reservationsStart = reservationsStart;
		this.reservationsEnde = reservationsEnde;
	}


	@Override
	public String toString() {
		return "ReservationsTermin [datum=" + datum + ", reservationsStart=" + reservationsStart + ", reservationsEnde="
				+ reservationsEnde + "]";
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public String getReservationsStart() {
		return reservationsStart;
	}


	public void setReservationsStart(String reservationsStart) {
		this.reservationsStart = reservationsStart;
	}


	public String getReservationsEnde() {
		return reservationsEnde;
	}


	public void setReservationsEnde(String reservationsEnde) {
		this.reservationsEnde = reservationsEnde;
	}
	
	
	
	

}
