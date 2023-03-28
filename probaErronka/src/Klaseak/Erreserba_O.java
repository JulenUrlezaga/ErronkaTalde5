package Klaseak;

import java.util.Date;

public class Erreserba_O {
	private String NAN;
	private int ID_Ostatua;
	private Date Sarrera_data;
	private Date Irteera_data;
	private int Prezioa;

	public Erreserba_O() {
		this.NAN = "";
		this.ID_Ostatua = 0;
		this.Sarrera_data = new Date(0 / 0 / 0);
		this.Irteera_data = new Date(0 / 0 / 0);
		this.Prezioa = 0;
	}
	public Erreserba_O(String na, int ido,Date sd, Date id,int pr) {
		this.NAN=na;
		this.ID_Ostatua=ido;
		this.Sarrera_data=sd;
		this.Irteera_data=id;
		this.Prezioa=pr;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public int getID_Ostatua() {
		return ID_Ostatua;
	}
	public void setID_Ostatua(int iD_Ostatua) {
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
	public int getPrezioa() {
		return Prezioa;
	}
	public void setPrezioa(int prezioa) {
		Prezioa = prezioa;
	}
	public void PantairalatuErrO(){
		System.out.println("bezeroaren NAN-a : "+this.NAN+" Ostatuaraen IDa : "+this.ID_Ostatua+" Sarrera data: "+this.Sarrera_data+" Irteera data : "+this.Irteera_data+" prezioa : "+this.Prezioa);
	}
}
