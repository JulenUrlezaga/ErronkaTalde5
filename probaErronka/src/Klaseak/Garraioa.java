package Klaseak;

import java.util.Scanner;

public abstract class Garraioa {
	protected String id_garraioa;
	protected String enpresa;
	protected String jatorria;
	protected String helmuga;

	
	/**
	 * Defektuzko eraikitzailea
	 */
	public Garraioa() {
		this.id_garraioa = "";
		this.enpresa = "";
		this.jatorria = "";
		this.helmuga = "";
	}

	/**Parametrozko eraikitzailea
	 * 
	 * @param ig String id_garraioa
	 * @param en String enpresa
	 * @param ja String jatorria
	 * @param he String helmuga
	 */
	public Garraioa(String ig, String en, String ja, String he) {
		this.id_garraioa = ig;
		this.enpresa = en;
		this.jatorria = ja;
		this.helmuga = he;
	}

	/**
	 * 
	 * @return Id_garraioa erakusteko metodoa
	 */
	public String getId_garraioa() {
		return id_garraioa;
	}

	/**
	 * 
	 * @param id_garraioa modifikatzeko metodoa
	 */
	public void setId_garraioa(String id_garraioa) {
		this.id_garraioa = id_garraioa;
	}

	/**
	 * 
	 * @return Enpresa erakusteko metodoa
	 */
	public String getEnpresa() {
		return enpresa;
	}

	/**
	 * 
	 * @param enpresa modifikatzeko metodoa
	 */
	public void setEnpresa(String enpresa) {
		this.enpresa = enpresa;
	}

	/**
	 * 
	 * @return Jatorria erakusteko metodoa
	 */
	public String getJatorria() {
		return jatorria;
	}

	/**
	 * 
	 * @param jatorria modifikatzeko metodoa
	 */
	public void setJatorria(String jatorria) {
		this.jatorria = jatorria;
	}

	/**
	 * 
	 * @return Helmuga erakusteko metodoa
	 */
	public String getHelmuga() {
		return helmuga;
	}

	/**
	 * 
	 * @param helmuga modifikatzeko metodoa
	 */
	public void setHelmuga(String helmuga) {
		this.helmuga = helmuga;
	}

	/**
	 * @param PantailaratuG()--> Datuak erakusteko metodo abstraktoa
	 */
	public abstract void PantailaratuG();

	/**
	 * 
	 * @param teklatua Datuak konpilatzen ditu
	 */
	public void IrakurriG(Scanner teklatua) {
		System.out.println("Garraioaren ID: ");
		this.id_garraioa = teklatua.next();
		System.out.println("Garraioaren Enpresa: ");
		this.enpresa = teklatua.next();
		System.out.println("Jatorria :");
		this.jatorria = teklatua.next();
		System.out.println("Helmuga :");
		this.helmuga = teklatua.next();

	}

}
