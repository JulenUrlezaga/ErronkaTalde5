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

	public Erreserba_G() {
		this.NAN = "";
		this.ID_garraio = "";
		this.Helmuga_data = new Date(0 / 0 / 0);
		this.Irteera_data = new Date(0 / 0 / 0);
		this.prezioa = 0;
	}

	public Erreserba_G(String na, String idg, Date hd, Date id, int p) {
		this.NAN = na;
		this.ID_garraio = idg;
		this.Helmuga_data = hd;
		this.Irteera_data = id;
		this.prezioa = p;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public String getID_garraio() {
		return ID_garraio;
	}

	public void setID_garraio(String iD_garraio) {
		ID_garraio = iD_garraio;
	}

	public Date getIrteera_data() {
		return Irteera_data;
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

	public void PantailaratuErrG() {
		System.out.println("Bezeroaren nan:" + this.NAN + "garraioaren id-a: " + this.ID_garraio + "noiz irtengo da: "
				+ this.Irteera_data + "noiz helduko da " + this.Helmuga_data);
	}

	public void IrakurriErrG(Scanner teklatua) {
		System.out.println();
		this.NAN = teklatua.next();
		System.out.println();
		this.ID_garraio = teklatua.next();
		System.out.println();
		try {
			this.Irteera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			this.Helmuga_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("prezioa");
		this.prezioa = teklatua.nextDouble();
	}
}
