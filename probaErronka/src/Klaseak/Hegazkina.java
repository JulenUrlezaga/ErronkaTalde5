package Klaseak;

import java.util.Scanner;

public class Hegazkina extends Garraioa {
	private int H_Jesarlekuak;
	private String Aireportua;

	
	/**
	 * Defektuzko eraikitzailea
	 */
	public Hegazkina() {
		super();
		this.Aireportua = "";
		this.H_Jesarlekuak = 0;
	}

	/**Parametrozko eraikitzailea
	 * 
	 * @param Hj-->Int H_Jesarlekuak
	 * @param ig-->String id_garraioa
	 * @param en-->String enpresa
	 * @param ja-->String jatorria
	 * @param he-->String helmuga
	 * @param ai-->String Aireportua
	 */
	public Hegazkina(int Hj, String ig, String en, String ja, String he, String ai) {
		super(ig, en, ja, he);
		this.Aireportua = ai;
		this.H_Jesarlekuak = Hj;
	}

	/**
	 * 
	 * @return Aireportua erakusteko metodoa
	 */
	public String getAireportua() {
		return Aireportua;
	}

	/**
	 * 
	 * @param aireportua modifikatzeko metodoa
	 */
	public void setAireportua(String aireportua) {
		Aireportua = aireportua;
	}

	/**
	 * 
	 * @return H_Jesarlekuak erakusteko metodoa
	 */
	public int getH_Jesarlekuak() {
		return H_Jesarlekuak;
	}

	/**
	 * 
	 * @param h_Jesarlekuak modifikatzeko metodoa
	 */
	public void setH_Jesarlekuak(int h_Jesarlekuak) {
		H_Jesarlekuak = h_Jesarlekuak;
	}

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriH(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Aireportua: ");
		this.Aireportua = teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.H_Jesarlekuak = teklatua.nextInt();
	}

	@Override
	/**
	 * @param PantailaratuG() --> Datuak erakusten ditu
	 */
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :" + this.id_garraioa + ", Enpresa : " + this.enpresa + ", Jatorria : "
				+ this.jatorria + ", Helmuga: " + this.helmuga + ", Aireportua: " + this.Aireportua + ", Jesarlekuak: "
				+ this.H_Jesarlekuak);
	}

}
