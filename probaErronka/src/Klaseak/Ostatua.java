package Klaseak;

import java.util.Scanner;

public class Ostatua {
	private int ID_Ostatua;
	private String lekua;
	private String ostatu_Mota;
	private String izena;
	private double izarrak;

	/**
	 * Defektuzko eraikitzailea
	 */
	public Ostatua() {
		this.ID_Ostatua = 0;
		this.lekua = "";
		this.ostatu_Mota = "";
		this.izena = "";
		this.izarrak = 0;
	}

	/**Parametrozko eraikitzailea
	 * 
	 * @param id Int ID_Ostatua 
	 * @param le String lekua
	 * @param oM String ostatu_Mota
	 * @param iz String izena
	 * @param izr Double izarrak
	 */
	public Ostatua(int id, String le, String oM, String iz, double izr) {
		this.ID_Ostatua = id;
		this.lekua = le;
		this.ostatu_Mota = oM;
		this.izena = iz;
		this.izarrak = izr;

	}

	/**
	 * 
	 * @return Izena metodoa erakusteko
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * 
	 * @param izena metodoa modifikatzeko
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * 
	 * @return Izarrak metodoa erakusteko
	 */
	public double getIzarrak() {
		return izarrak;
	}

	/**
	 * 
	 * @param izarrak metodoa modifikatzeko
	 */
	public void setIzarrak(double izarrak) {
		this.izarrak = izarrak;
	}

	/**
	 * 
	 * @return ID_Ostatua metodoa erakusteko
	 */
	public int getID_Ostatua() {
		return ID_Ostatua;
	}

	/**
	 * 
	 * @param idOstatua metodoa modifikatzeko
	 */
	public void setID_Ostatua(int idOstatua) {
		ID_Ostatua = idOstatua;
	}

	/**
	 * 
	 * @return Lekua metodoa erakusteko
	 */
	public String getLekua() {
		return lekua;
	}

	/**
	 * 
	 * @param lekua metodoa modifikatzeko
	 */
	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	/**
	 * 
	 * @return Ostatu_Mota metodoa erakusteko
	 */
	public String getOstatu_Mota() {
		return ostatu_Mota;
	}

	/**
	 * 
	 * @param ostatuMota metodoa modifikatzeko
	 */
	public void setOstatu_Mota(String ostatuMota) {
		this.ostatu_Mota = ostatuMota;
	}

	/**
	 * @param PantailaratuOstuta() --> Datuak erakusten ditu
	 */
	public void PantailaratuOstuta() {
		System.out.println("ID :" + this.ID_Ostatua + ", non dago :" + this.lekua + ", Zer da :" + this.ostatu_Mota
				+ "Zelan deitzen da: " + this.izena + "Izarrak: "+this.izarrak);
	}

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriOstatua(Scanner teklatua) {
		System.out.println("ID: ");
		this.ID_Ostatua = teklatua.nextInt();
		System.out.println("Non dago:");
		this.lekua = teklatua.next();
		System.out.println("Zer eraikin mota da:");
		this.ostatu_Mota = teklatua.next();
		System.out.println("Izena: ");
		this.izena = teklatua.next();
		System.out.println("Zenbat izar: ");
		this.izarrak = teklatua.nextInt();
	}
}
