package Klaseak;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Erreserba_O {
	private String NAN;
	private String ID_Ostatua;
	private Date Sarrera_data;
	private Date Irteera_data;
	private double Prezioa;

	public Erreserba_O() {
		this.NAN = "";
		this.ID_Ostatua = "";
		this.Sarrera_data = new Date(0 / 0 / 0);
		this.Irteera_data = new Date(0 / 0 / 0);
		this.Prezioa = 0;
	}

	public Erreserba_O(String na, String ido, Date sd, Date id, int pr) {
		this.NAN = na;
		this.ID_Ostatua = ido;
		this.Sarrera_data = sd;
		this.Irteera_data = id;
		this.Prezioa = pr;
	}

	public String getNAN() {
		return NAN;
	}

	public void setNAN(String nAN) {
		NAN = nAN;
	}

	public String getID_Ostatua() {
		return ID_Ostatua;
	}

	public void setID_Ostatua(String iD_Ostatua) {
		ID_Ostatua = iD_Ostatua;
	}

	public Date getSarrera_data() {
		return Sarrera_data;
	}

	public void setSarrera_data(Date sarrera_data) {
		Sarrera_data = sarrera_data;
	}

	public Date getIrteera_data() {
		return Irteera_data;
	}

	public void setIrteera_data(Date irteera_data) {
		Irteera_data = irteera_data;
	}

	public double getPrezioa() {
		return Prezioa;
	}

	public void setPrezioa(double prezioa) {
		Prezioa = prezioa;
	}

	public void PantairalatuErrO() {
		System.out
				.println("bezeroaren NAN-a : " + this.NAN + " Ostatuaraen IDa : " + this.ID_Ostatua + " Sarrera data: "
						+ this.Sarrera_data + " Irteera data : " + this.Irteera_data + " prezioa : " + this.Prezioa);
	}

	public void IrakurriErrG(Scanner teklatua) {
		System.out.println();
		this.NAN = teklatua.next();
		System.out.println();
		this.ID_Ostatua = teklatua.next();
		System.out.println();
		try {
			this.Sarrera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			this.Irteera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("prezioa");
		this.Prezioa = teklatua.nextDouble();
	}
}
