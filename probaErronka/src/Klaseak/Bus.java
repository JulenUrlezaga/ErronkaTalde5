package Klaseak;

import java.util.Scanner;

/**
 * 
 * @author Julen U,Ander B,Ander B
 *
 */

public class Bus extends Garraioa {
	private String Geltokiak;
	private int B_Jesarlekuak;

	/** Defektuzko eraikitzailea
	 * 
	 * @param Garraio klasetik--> super(id_garraioa,enpresa,jatorria,helmuga)
	 * @param String Geltokiak 
	 * @param Int B_Jesarlekuak 
	 */
	public Bus() {
		super();
		this.Geltokiak = "";
		this.B_Jesarlekuak = 0;
	}
	
	/** Parametrozko eraikitzailea 
	 * 
	 * @param g -->  String Geltokiak
	 * @param Bj --> Int B_Jesarlekuak
	 * @param ig --> String  id_garraioa
	 * @param en --> String enpresa
	 * @param ja --> String jatorria
	 * @param he --> String helmuga
	 */
	public Bus(String g, int Bj, String ig, String en, String ja, String he) {
		super(ig, en, ja, he);
		this.Geltokiak = g;
		this.B_Jesarlekuak = Bj;
	}
	/**
	 * 
	 * @return Geltokiak erakusteko metodoa
	 */
	public String getGeltokiak() {
		return Geltokiak;
	}
	
	/**
	 * @param geltokiak modifikatzeko metodoa
	 */
	public void setGeltokiak(String geltokiak) {
		Geltokiak = geltokiak;
	}
	/**
	 * 
	 * @return B_Jesarlekuak erakusteko metodoa
	 */
	public int getB_Jesarlekuak() {
		return B_Jesarlekuak;
	}
	/**
	 * 
	 * @param b_Jesarlekuak modifikatzeko metodoa
	 */
	public void setB_Jesarlekuak(int b_Jesarlekuak) {
		B_Jesarlekuak = b_Jesarlekuak;
	}
	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriB(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Geltokiak: ");
		this.Geltokiak = teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.B_Jesarlekuak = teklatua.nextInt();

	}

	@Override
	/**
	 * PantailaratuG()--> Datuak erakusten ditu
	 */
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :" + this.id_garraioa + ", Enpresa : " + this.enpresa + ", Jatorria : "
				+ this.jatorria + ", Helmuga: " + this.helmuga + ", Geltokiak: " + this.Geltokiak + ", Jesarlekuak: "
				+ this.B_Jesarlekuak);
	}

}
