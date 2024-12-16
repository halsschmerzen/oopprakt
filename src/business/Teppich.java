package business;

import java.util.ArrayList;

public class Teppich {
	
    private String artikelnummer;
    private float breite;
    private float laenge;
    private String kategorie;
    private ArrayList<String> farben;

    
	
	public Teppich(String artikelnummer, float breite, float laenge, String kategorie, String[] farben) {
		this.artikelnummer = artikelnummer;
		this.breite = breite;
		this.laenge = laenge;
		this.kategorie = kategorie;
		
		if(farben==null) {
			throw new IllegalArgumentException("Farben wurden nicht initialisiert!");
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for(String s : farben) {
			arr.add(s);
		}
		this.farben = arr;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getBreite() {
		return breite;
	}

	public void setBreite(float breite) {
		this.breite = breite;
	}

	public float getLaenge() {
		return laenge;
	}

	public void setLaenge(float laenge) {
		this.laenge = laenge;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public ArrayList<String> getFarben() {
		return farben;
	}

	public void setFarben(ArrayList<String> farben) {
		this.farben = farben;
	}
	
	public static ArrayList<String> fromStringArrToArrayList(String[] arr) {
		ArrayList<String> tempArr = new ArrayList<String>();
		for(String x : arr) {
			tempArr.add(x);
		}
		
		return tempArr;
	}

	public String getFarbenalsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarben().size() - 1; i++) {
			ergebnis = ergebnis + this.getFarben().get(i) + trenner; 
		}
		return ergebnis	+ this.getFarben().get(i);
	}
	
	public String gibTeppichZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getBreite() + trenner
  		    + this.getLaenge() + trenner
  		    + this.getKategorie() + trenner
  		    + this.getFarbenalsString(trenner) + "\n";
  	}
}

