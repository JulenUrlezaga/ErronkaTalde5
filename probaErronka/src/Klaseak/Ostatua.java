package Klaseak;

import java.util.Scanner;

public class Ostatua {
	private int IdOstatua;
	private String lekua;
	private String ostatuMota;

	public Ostatua() {
		this.IdOstatua = 0;
		this.lekua = "";
		this.ostatuMota = "";
	}

	public Ostatua(int id, String le, String oM) {
		this.IdOstatua = id;
		this.lekua = le;
		this.ostatuMota = oM;
	}

	public int getIdOstatua() {
		return IdOstatua;
	}

	public void setIdOstatua(int idOstatua) {
		IdOstatua = idOstatua;
	}

	public String getLekua() {
		return lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public String getOstatuMota() {
		return ostatuMota;
	}

	public void setOstatuMota(String ostatuMota) {
		this.ostatuMota = ostatuMota;
	}

	public void PantailaratuOstuta() {
		System.out.println("ID :" + this.IdOstatua + ", non dago :" + this.lekua + ", Zer da :" + this.ostatuMota);
	}
	
	public void IrakurriOstatua(Scanner teklatua) {
		System.out.println("ID : ");
		this.IdOstatua=teklatua.nextInt();
		System.out.println("Non dago :");
		this.lekua=teklatua.next();
		System.out.println("Zer heraikin mota da :");
		this.ostatuMota=teklatua.next();
	}
}
