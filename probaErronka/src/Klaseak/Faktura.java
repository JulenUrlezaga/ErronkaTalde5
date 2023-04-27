package Klaseak;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Faktura implements Serializable, Fakturazioa {

	private String NAN;
	private int Ordainketa_metodoa;
	private String id;
	private Date Irteera_data;
	private Date Helmuga_data;
	private double prezioa;
	/**
	 * Faktura klasearen defektusko eraikitzailea
	 */
	public Faktura() {
		this.NAN = "";
		this.Ordainketa_metodoa = 0;
		this.id = "";
		this.Irteera_data = new Date(0-0-0);
		this.Helmuga_data = new Date(0-0-0);
		this.prezioa = 0;
	}
	/**
	 * Faktura klasearen eraikitzailea pertsonalizatua
	 * @param na String nan
	 * @param om int ordainketa_metodoa
	 * @param idg String id
	 * @param a Date Helmuga_data
	 * @param as Date Irteera_data
	 * @param d Double prezioa
	 */
	public Faktura(String na, int om, String idg, Date a, Date as, double d) {
		this.NAN = na;
		this.Ordainketa_metodoa = om;
		this.id = idg;
		this.Helmuga_data = a;
		this.Irteera_data = as;
		this.prezioa = d;
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
	 * @return Ordainketa_metodoa erakusteko metodoa
	 */
	public int getOrdainketa_metodoa() {
		return Ordainketa_metodoa;
	}

	/**
	 * 
	 * @param ordainketa_metodoa modifikatzeko metodoa
	 */
	public void setOrdainketa_metodoa(int ordainketa_metodoa) {
		Ordainketa_metodoa = ordainketa_metodoa;
	}

	/**
	 * 
	 * @return ID erakusteko metodoa
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id modifikatzeko metodoa
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return Irteera_data erakusteko metodoa
	 */
	public Date getIrteera_data() {
		return Irteera_data;
	}
	/**
	 * 
	 * @return Helmuga_data erakusteko metodoa
	 */
	public Date getHelmuga_data() {
		return Helmuga_data;
	}

	/**
	 * 
	 * @param helmuga_data modifikatzeko metodoa
	 */
	public void setHelmuga_data(Date helmuga_data) {
		Helmuga_data = helmuga_data;
	}

	/**
	 * 
	 * @return Prezioa erakusteko metodoa
	 */
	public double getPrezioa() {
		return prezioa;
	}
	/**
	 * 
	 * @param prezioa modifikatzeko metodoa
	 */
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
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
	/**
	 * @param total Double=0
	 * @param total= prezioa + prezioa*BEZ(0.21)
	 * @param
	 */
	public double kalkulatuTotala() {
		// TODO Auto-generated method stub
		double total = 0;
		total = this.prezioa + (this.prezioa * BEZ);
		return total;
	}

}
