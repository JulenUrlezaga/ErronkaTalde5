package Klaseak;

import java.util.Scanner;

public class Itsasontzia extends Garraioa{
	
	private String Portuak;
	private int Kamaroteak;
	
	public Itsasontzia() {
		super();
		this.Portuak= "";
		this.Kamaroteak = 0;
	}
	public Itsasontzia(String P,int Kmk,String ig,String en,String ja,String he) {
		super(ig,en,ja,he);
		this.Portuak=P;
		this.Kamaroteak=Kmk;
	}
	

	public String getPortuak() {
		return Portuak;
	}
	public void setPortuak(String portuak) {
		Portuak = portuak;
	}
	public int getKamaroteak() {
		return Kamaroteak;
	}
	public void setKamaroteak(int kamaroteak) {
		Kamaroteak = kamaroteak;
	}
	public void IrakurriI(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Aireportua: ");
		this.Portuak=teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.Kamaroteak=teklatua.nextInt();
	}
	@Override
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :"+this.id_garraioa+", Enpresa : "+this.enpresa+", Jatorria : "+this.jatorria+", Helmuga: "+this.helmuga+", Portuak: "+this.Portuak+", Kamaroteak: "+this.Kamaroteak);
	}

	@Override
	public boolean Premium() {
		// TODO Auto-generated method stub
		String erantzuna="";
		System.out.println("Premium izan nahi duzu? BAI/EZ (+5€)");
		if (erantzuna.equalsIgnoreCase("bai")) {
			
		}else if (erantzuna.equalsIgnoreCase("ez")) {
			
		}
		return false;
	}

	

}
