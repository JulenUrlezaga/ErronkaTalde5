package Klaseak;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Bodega.fakturazioa;

public class Faktura implements Serializable, Fakturazioa {

	private String NAN;
	private int Ordainketa_metodoa;
	private String id;
	private Date Irteera_data;
	private Date Helmuga_data;
	private double prezioa;

	public Faktura() {
		this.NAN = "";
		this.Ordainketa_metodoa = 0;
		this.id = "";
		this.Helmuga_data = new Date(0 - 0 - 0);
		this.Irteera_data = new Date(0 - 0 - 0);
		this.prezioa = 0;
	}

	public Faktura(String na, int om, String idg, Date a, Date as, double d) {
		this.NAN = na;
		this.Ordainketa_metodoa = om;
		this.id = idg;
		this.Helmuga_data = a;
		this.Irteera_data = as;
		this.prezioa = d;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public int getOrdainketa_metodoa() {
		return Ordainketa_metodoa;
	}

	public void setOrdainketa_metodoa(int ordainketa_metodoa) {
		Ordainketa_metodoa = ordainketa_metodoa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIrteera_data(Date irteera_data) {
		Irteera_data = irteera_data;
	}

	public Date getHelmuga_data() {
		return Helmuga_data;
	}

	public void setHelmuga_data(Date helmuga_data) {
		Helmuga_data = helmuga_data;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public void IrakurriFak(Scanner teklatua) {
		System.out.println("NAN:");
		this.NAN = teklatua.next();
		System.out.println("Garraio edo Ostatuaren IDa");
		this.id = teklatua.next();
		System.out.println();
		try {
			this.Irteera_data = new SimpleDateFormat("dd-MM-yyyy").parse(teklatua.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			this.Helmuga_data = new SimpleDateFormat("dd-MM-yyyy").parse(teklatua.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Prezio");
		this.prezioa = teklatua.nextInt();
		System.out.println("Zure txartel zenbakia");
		this.Ordainketa_metodoa = teklatua.nextInt();
	}

	@Override
	public double kalkulatuTotala() {
		// TODO Auto-generated method stub
		double total = 0;
		total = this.prezioa + (this.prezioa * BEZ);
		return total;
	}

}
