package Klaseak;

import java.util.Scanner;

public class Ostatua {
	private int ID_Ostatua;
	private String lekua;
	private String ostatu_Mota;

	public Ostatua() {
		this.ID_Ostatua = 0;
		this.lekua = "";
		this.ostatu_Mota = "";
	}

	public Ostatua(int id, String le, String oM) {
		this.ID_Ostatua = id;
		this.lekua = le;
		this.ostatu_Mota = oM;
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
		System.out.println("ID :" + this.ID_Ostatua + ", non dago :" + this.lekua + ", Zer da :" + this.ostatu_Mota);
	}
	
	public void IrakurriOstatua(Scanner teklatua) {
		System.out.println("ID : ");
		this.ID_Ostatua=teklatua.nextInt();
		System.out.println("Non dago :");
		this.lekua=teklatua.next();
		System.out.println("Zer heraikin mota da :");
		this.ostatu_Mota=teklatua.next();
	}
}
