package Klaseak;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Julen U,Ander B,Ander B
 *
 */
public class Erreserba_O {
	private String NAN;
	private String ID_Ostatua;
	private Date Sarrera_data;
	private Date Irteera_data;
	private double Prezioa;

	/** Defektuzko eraikitzailea
	 * @param String NAN
	 * @param String ID_Ostatua
	 * @param Date Sarrera_data
	 * @param Date Irteera_date
 	 * @param Double Prezioa
	 */
	public Erreserba_O() {
		this.NAN = "";
		this.ID_Ostatua = "";
		this.Sarrera_data = new Date(0-0-0);
		this.Irteera_data = new Date(0-0-0);
		this.Prezioa = 0;
	}
	
	/** Parametrozko eraikitzailea
	 * 
	 * @param na String NAN
	 * @param ido String ID_Ostatua
	 * @param sd Date Sarrera_data
	 * @param id Date Irteera_date
	 * @param pr Double Prezioa
	 */
	public Erreserba_O(String na, String ido, Date sd, Date id, int pr) {
		this.NAN = na;
		this.ID_Ostatua = ido;
		this.Sarrera_data = sd;
		this.Irteera_data = id;
		this.Prezioa = pr;
	}
	/**
	 * 
	 * @return NAN erakusteko metodoa
	 */
	public String getNAN() {
		return NAN;
	}
	
	/**
	 * 
	 * @param nAN modifikatzeko metodoa
	 */
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	/**
	 * 
	 * @return ID_Ostatua erakusteko metodoa
	 */
	public String getID_Ostatua() {
		return ID_Ostatua;
	}
	/**
	 * 
	 * @param iD_Ostatua modifikatzeko metodoa
	 */
	public void setID_Ostatua(String iD_Ostatua) {
		ID_Ostatua = iD_Ostatua;
	}

	/**
	 * 
	 * @return Sarrera erakusteko metodoa
	 */
	public Date getSarrera_data() {
		return Sarrera_data;
	}

	/**
	 * 
	 * @param sarrera_data modifikatzeko metodoa
	 */
	public void setSarrera_data(Date sarrera_data) {
		Sarrera_data = sarrera_data;
	}

	/**
	 * 
	 * @return Irteera_data erakusteko metodoa
	 */
	public Date getIrteera_data() {
		return Irteera_data;
	}

	/**
	 * 
	 * @param irteera_data modifikatzeko metodoa
	 */
	public void setIrteera_data(Date irteera_data) {
		Irteera_data = irteera_data;
	}

	/**
	 * 
	 * @return Prezioa erakusteko metodoa
	 */
	public double getPrezioa() {
		return Prezioa;
	}

	/**
	 * 
	 * @param prezioa modifikatzeko metodoa
	 */
	public void setPrezioa(double prezioa) {
		Prezioa = prezioa;
	}
	/**
	 * 
	 * @param PantailaratuErrO() --> Datuak erakusten ditu
	 */
	public void PantairalatuErrO() {
		System.out.println("bezeroaren NAN-a : " + this.NAN + " Ostatuaraen IDa : " + this.ID_Ostatua + " Sarrera data: "
						+ this.Sarrera_data + " Irteera data : " + this.Irteera_data + " prezioa : " + this.Prezioa);
				
	}

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriErrG(Scanner teklatua) {
		System.out.println("Nan: ");
		this.NAN = teklatua.next();
		System.out.println("Ostatuaren ID-a: ");
		this.ID_Ostatua = teklatua.next();
		System.out.println();
		try {
			System.out.println("Data: (DD/MM/YYYY)");
			this.Sarrera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			System.out.println("Data: (DD/MM/YYYY)");
			this.Irteera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("prezioa");
		this.Prezioa = teklatua.nextDouble();
	}
}
