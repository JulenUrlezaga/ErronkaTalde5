package Klaseak;
import java.util.Scanner;
public class Bezeroa {
private String NAN;
	private String Izena;
	private String Abizenak;
	private String Telefono;
	private String Email;
	private int Ordainketa_Metedoa;

	public Bezeroa() {
		this.NAN = "";
		this.Izena = "";
		this.Abizenak = "";
		this.Telefono = "";
		this.Email = "";
		this.Ordainketa_Metedoa = 0;
	}
	public Bezeroa(String n,String iz,String ab, String te, String em, int orme) {
		this.NAN=n;
		this.Izena=iz;
		this.Abizenak=ab;
		this.Telefono=te;
		this.Email=em;
		this.Ordainketa_Metedoa=orme;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getAbizenak() {
		return Abizenak;
	}
	public void setAbizenak(String abizenak) {
		Abizenak = abizenak;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getOrdainketa_Metedoa() {
		return Ordainketa_Metedoa;
	}
	public void setOrdainketaMetedoa(int ordainketa_Metedoa) {
		Ordainketa_Metedoa = ordainketa_Metedoa;
	}
	public void PantailaratuBezero() {
		System.out.println("NAN :"+this.NAN+", izena : "+this.Izena+", Abizenak : "+this.Abizenak+", telefonoa : "+this.Telefono+", email-a : "+this.Email+", Ordainketa : "+this.Ordainketa_Metedoa);
	}
	public void IrakurriBezero(Scanner teklatua) {
		System.out.println("NAN :");
		this.NAN=teklatua.next();
		System.out.println("Izena :");
		this.Izena=teklatua.next();
		System.out.println("Abizenak :");
		this.Abizenak=teklatua.next();
		System.out.println("Telofono zenbakia :");
		this.Telefono=teklatua.next();
		System.out.println("email kontua:");
		this.Email=teklatua.next();
		System.out.println("ordainketa kontua zenbakia");
		this.Ordainketa_Metedoa=teklatua.nextInt();
	}
}
