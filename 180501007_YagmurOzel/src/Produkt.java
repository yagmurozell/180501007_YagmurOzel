import java.util.Arrays;

public class Produkt {
	
	private String name;
	private Kosten[] aktuelleKosten;
	
	
	public Produkt(String name, Kosten[] aktuelleKosten) {
		super();
		this.name = name;
		this.aktuelleKosten = aktuelleKosten;
	}


	@Override
	public String toString() {
		return "Produkt [name=" + name + ", aktuelleKosten=" + Arrays.toString(aktuelleKosten) + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Kosten[] getAktuelleKosten() {
		return aktuelleKosten;
	}


	public void setAktuelleKosten(Kosten[] aktuelleKosten) {
		this.aktuelleKosten = aktuelleKosten;
	}
	
	

}
