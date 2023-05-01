package Klaseak;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Erreserba_G {
	private String NAN;
	private String ID_garraio;
	private Date Irteera_data;
	private Date Helmuga_data;
	private double prezioa;
	/**
	 *  Errezerba klasearen defektusko eraikitzailea
	 */
	public Erreserba_G() {
		this.NAN = "";
		this.ID_garraio = "";
		this.Helmuga_data = new Date(0-0-0);
		this.Irteera_data = new Date(0-0-0);
		this.prezioa = 0;
	}
	/**
	 * Errezerba_G klasearen  eraikitzailea pertsonalizatua
	 * @param na String NAN
	 * @param idg String ID_garraio
	 * @param hd Date Helmuga_data
	 * @param id Date irteera data
	 * @param p int prezioa
	 */
	public Erreserba_G(String na, String idg, Date hd, Date id, int p) {
		this.NAN = na;
		this.ID_garraio = idg;
		this.Helmuga_data = hd;
		this.Irteera_data = id;
		this.prezioa = p;
	}
	/**
	 * 
	 * @return  NAN erakuzteko metodoa
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
	 * @return ID_garraio erakuzteko metodoa
	 */
	public String getID_garraio() {
		return ID_garraio;
	}
	/**
	 * 
	 * @param iD_garraio modifikatzeko metodoa
	 */
	public void setID_garraio(String iD_garraio) {
		ID_garraio = iD_garraio;
	}
	/**
	 * 
	 * @return Irteera_data erakuzteko metodoa
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
	 * @return helmuga_data erakuzteko metodoa
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
	 * @return prezioa erakuzteko metodoa
	 */
	public double getPrezioa() {
		return prezioa;
	}
	/**
	 * 
	 * @param prezioa  modifikatzeko metodoa
	 */
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	
	public void PantailaratuErrG() {
		System.out.println("Bezeroaren nan:" + this.NAN + "garraioaren id-a: " + this.ID_garraio + "noiz irtengo da: "
				+ this.Irteera_data + "noiz helduko da " + this.Helmuga_data);
	}
	/**
	 * 
	 * @param teklatua  datuak kopilatzen ditu
	 */
	public void IrakurriErrG(Scanner teklatua) {
		System.out.println("Nan:");
		this.NAN = teklatua.next();
		System.out.println("Garraioaren ID-a");
		this.ID_garraio = teklatua.next();
		System.out.println();
		try {
			System.out.println("Data: (DD/MM/YYYY)");
			this.Irteera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			System.out.println("Data: (DD/MM/YYYY)");
			this.Helmuga_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("prezioa");
		this.prezioa = teklatua.nextDouble();
	}
}
