package Klaseak;

import java.util.Scanner;

public class Bus extends Garraioa{
	private String Geltokiak;
	private int B_Jesarlekuak;
	
	public Bus() {
		super();
		this.Geltokiak= "";
		this.B_Jesarlekuak = 0;
	}
	public Bus(String g,int Bj,String ig,String en,String ja,String he) {
		super(ig,en,ja,he);
		this.Geltokiak=g;
		this.B_Jesarlekuak=Bj;
	}
	
	public String getGeltokiak() {
		return Geltokiak;
	}
	public void setGeltokiak(String geltokiak) {
		Geltokiak = geltokiak;
	}
	public int getB_Jesarlekuak() {
		return B_Jesarlekuak;
	}
	public void setB_Jesarlekuak(int b_Jesarlekuak) {
		B_Jesarlekuak = b_Jesarlekuak;
	}
	
	public void IrakurriB(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Geltokiak: ");
		this.Geltokiak=teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.B_Jesarlekuak=teklatua.nextInt();

	}
	
	@Override
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :"+this.id_garraioa+", Enpresa : "+this.enpresa+", Jatorria : "+this.jatorria+", Helmuga: "+this.helmuga+", Geltokiak: "+this.Geltokiak+", Jesarlekuak: "+this.B_Jesarlekuak);
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
