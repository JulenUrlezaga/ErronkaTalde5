package Klaseak;

import java.util.Scanner;

public class Hegazkina extends Garraioa{
	private int H_Jesarlekuak;
	
	public Hegazkina() {
		super();

		this.H_Jesarlekuak = 0;
	}
	public Hegazkina(int Hj,String ig,String en,String ja,String he) {
		super(ig,en,ja,he);

		this.H_Jesarlekuak=Hj;
	}

	public int getH_Jesarlekuak() {
		return H_Jesarlekuak;
	}
	public void setH_Jesarlekuak(int h_Jesarlekuak) {
		H_Jesarlekuak = h_Jesarlekuak;
	}
	
	public void IrakurriH(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Aireportua: ");
		this.Aireportua=teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.H_Jesarlekuak=teklatua.nextInt();
	}
	
	@Override
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :"+this.id_garraioa+", Enpresa : "+this.enpresa+", Jatorria : "+this.jatorria+", Helmuga: "+this.helmuga+", Aireportua: "+this.Aireportua+", Jesarlekuak: "+this.H_Jesarlekuak);
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
