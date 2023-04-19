package Klaseak;

import java.util.Scanner;

public class Ostatua {
	private int ID_Ostatua;
	private String lekua;
	private String ostatu_Mota;
	private String izena;
	private double izarrak;

	public Ostatua() {
		this.ID_Ostatua = 0;
		this.lekua = "";
		this.ostatu_Mota = "";
		this.izena = "";
		this.izarrak = 0;
	}

	public Ostatua(int id, String le, String oM, String iz, double izr) {
		this.ID_Ostatua = id;
		this.lekua = le;
		this.ostatu_Mota = oM;
		this.izena = iz;
		this.izarrak = izr;

	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public double getIzarrak() {
		return izarrak;
	}

	public void setIzarrak(double izarrak) {
		this.izarrak = izarrak;
	}

	public int getID_Ostatua() {
		return ID_Ostatua;
	}

	public void setID_Ostatua(int idOstatua) {
		ID_Ostatua = idOstatua;
	}

	public String getLekua() {
		return lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public String getOstatu_Mota() {
		return ostatu_Mota;
	}

	public void setOstatu_Mota(String ostatuMota) {
		this.ostatu_Mota = ostatuMota;
	}

	public void PantailaratuOstuta() {
		System.out.println("ID :" + this.ID_Ostatua + ", non dago :" + this.lekua + ", Zer da :" + this.ostatu_Mota
				+ "Zelan deitzen da: " + this.izena + "Izarrak: "+this.izarrak);
	}

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
