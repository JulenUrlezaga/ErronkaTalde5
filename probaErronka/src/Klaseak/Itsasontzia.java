package Klaseak;

import java.util.Scanner;

public class Itsasontzia extends Garraioa {

	private String Portuak;
	private int Kamaroteak;

	/**
	 * Defektuzko eraikitzailea
	 */
	public Itsasontzia() {
		super();
		this.Portuak = "";
		this.Kamaroteak = 0;
	}

	/**Parametrozko metodoa
	 * 
	 * @param P String Portuak
	 * @param Kmk Int Kamaroteak
	 * @param ig String id_garraioa
	 * @param en String enpresa
	 * @param ja String Jatorria
	 * @param he String Helmuga
	 */
	public Itsasontzia(String P, int Kmk, String ig, String en, String ja, String he) {
		super(ig, en, ja, he);
		this.Portuak = P;
		this.Kamaroteak = Kmk;
	}

	/**
	 * 
	 * @return Portuak erakusteko metodoa
	 */
	public String getPortuak() {
		return Portuak;
	}

	/**
	 * 
	 * @param portuak modifikatzeko metodoa
	 */
	public void setPortuak(String portuak) {
		Portuak = portuak;
	}

	/**
	 * 
	 * @return Kamaroteak erakusteko metodoa
	 */
	public int getKamaroteak() {
		return Kamaroteak;
	}

	/**
	 * 
	 * @param kamaroteak modifikatzeko metodoa
	 */
	public void setKamaroteak(int kamaroteak) {
		Kamaroteak = kamaroteak;
	}

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriI(Scanner teklatua) {
		super.IrakurriG(teklatua);
		System.out.println("Aireportua: ");
		this.Portuak = teklatua.next();
		System.out.println("Jesarlekuak: ");
		this.Kamaroteak = teklatua.nextInt();
	}

	@Override
	/**
	 * @param PantailaratuG()--> Datuak erakusten ditu
	 */
	public void PantailaratuG() {
		// TODO Auto-generated method stub
		System.out.println("Garraio ID :" + this.id_garraioa + ", Enpresa : " + this.enpresa + ", Jatorria : "
				+ this.jatorria + ", Helmuga: " + this.helmuga + ", Portuak: " + this.Portuak + ", Kamaroteak: "
				+ this.Kamaroteak);
	}

}
