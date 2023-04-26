package Klaseak;

import java.util.Scanner;
/**
 * @author Julen U, Ander B, 
 */
public class Bezeroa {
	private String NAN;
	private String Izena;
	private String Abizenak;
	private String Telefono;
	private String Email;
	private int Ordainketa_Metodoa;
	/**
	 * Bezeroa klasearen defektusko eraikitzailea
	 */
	public Bezeroa() {
		this.NAN = "";
		this.Izena = "";
		this.Abizenak = "";
		this.Telefono = "";
		this.Email = "";
		this.Ordainketa_Metodoa = 0;
	}
	
	/**
	 * Bezeroa klasearen eraikitzailea pertsonalizatua
	 * @param n String NAN
	 * @param iz String izena 
	 * @param ab String abizena
	 * @param te String Telefono
	 * @param em String Email
	 * @param orme int Ordainketa_metodoa
	 */
	public Bezeroa(String n, String iz, String ab, String te, String em, int orme) {
		this.NAN = n;
		this.Izena = iz;
		this.Abizenak = ab;
		this.Telefono = te;
		this.Email = em;
		this.Ordainketa_Metodoa = orme;
	}
	/**
	 * 
	 * @return NAN erakuzteko metodoa
	 */
	public String getNAN() {
		return NAN;
	}
	/**
	 * 
	 * @param NAN modifikatzeko metodoa
	 */
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	/**
	 * 
	 * @return izena erakuzteko metodoa
	 */
	public String getIzena() {
		return Izena;
	}
	/**
	 * 
	 * @param izena modifikatzeko metodoa
	 */
	public void setIzena(String izena) {
		Izena = izena;
	}
	/**
	 * 
	 * @return abizena erakuzteko metodoa
	 */
	public String getAbizenak() {
		return Abizenak;
	}
	/**
	 * 
	 * @param abizena modifikatzeko metodoa
	 */
	public void setAbizenak(String abizenak) {
		Abizenak = abizenak;
	}
	/**
	 * 
	 * @return Telefono erakuzteko metodoa
	 */
	public String getTelefono() {
		return Telefono;
	}
	/**
	 * 
	 * @param Telefono modifikatzeko metodoa
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	/**
	 * 
	 * @return email erakuzteko metodoa
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * 
	 * @param Email modifikatzeko metodoa
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * 
	 * @return Ordainketa_Metodoa erakuzteko metodoa
	 */
	public int getOrdainketa_Metodoa() {
		return Ordainketa_Metodoa;
	}
	/**
	 * 
	 * @param Ordainketa_Metedoa modifikatzeko metodoa
	 */
	public void setOrdainketa_Metodoa(int ordainketa_Metedoa) {
		Ordainketa_Metodoa = ordainketa_Metedoa;
	}
	/**
	 * 
	 */
	public void PantailaratuBezero() {
		System.out.println(
				"NAN :" + this.NAN + ", izena : " + this.Izena + ", Abizenak : " + this.Abizenak + ", telefonoa : "
						+ this.Telefono + ", email-a : " + this.Email + ", Ordainketa : " + this.Ordainketa_Metodoa);
	}
	/**
	 * 
	 * @param teklatua datuak kopilatzen ditu
	 */
	public void IrakurriBezero(Scanner teklatua) {
		System.out.println("NAN :");
		this.NAN = teklatua.next();
		System.out.println("Izena :");
		this.Izena = teklatua.next();
		System.out.println("Abizenak :");
		this.Abizenak = teklatua.next();
		System.out.println("Telofono zenbakia :");
		this.Telefono = teklatua.next();
		System.out.println("email kontua:");
		this.Email = teklatua.next();
		System.out.println("ordainketa kontua zenbakia");
		this.Ordainketa_Metodoa = teklatua.nextInt();
	}
}
