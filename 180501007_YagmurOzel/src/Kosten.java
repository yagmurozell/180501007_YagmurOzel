
public class Kosten {
	
	private String teppichKosten;
	private String sofaKosten;
	private String gardinenKosten;
	private String matratzenKosten;
	private String hausreinigung;
	
	public Kosten(String teppichKosten, String sofaKosten, String gardinenKosten, String matratzenKosten,
			String hausreinigung) {
		super();
		this.teppichKosten = teppichKosten;
		this.sofaKosten = sofaKosten;
		this.gardinenKosten = gardinenKosten;
		this.matratzenKosten = matratzenKosten;
		this.hausreinigung = hausreinigung;
	}

	@Override
	public String toString() {
		return "Kosten [teppichKosten=" + teppichKosten + ", sofaKosten=" + sofaKosten + ", gardinenKosten="
				+ gardinenKosten + ", matratzenKosten=" + matratzenKosten + ", hausreinigung=" + hausreinigung + "]";
	}

	public String getTeppichKosten() {
		return teppichKosten;
	}

	public void setTeppichKosten(String teppichKosten) {
		this.teppichKosten = teppichKosten;
	}

	public String getSofaKosten() {
		return sofaKosten;
	}

	public void setSofaKosten(String sofaKosten) {
		this.sofaKosten = sofaKosten;
	}

	public String getGardinenKosten() {
		return gardinenKosten;
	}

	public void setGardinenKosten(String gardinenKosten) {
		this.gardinenKosten = gardinenKosten;
	}

	public String getMatratzenKosten() {
		return matratzenKosten;
	}

	public void setMatratzenKosten(String matratzenKosten) {
		this.matratzenKosten = matratzenKosten;
	}

	public String getHausreinigung() {
		return hausreinigung;
	}

	public void setHausreinigung(String hausreinigung) {
		this.hausreinigung = hausreinigung;
	}
	
	
	
	

}
