package Klaseak;

import java.util.Scanner;

public abstract class Garraioa {
	protected String id_garraioa;
	protected String enpresa;
	protected String jatorria;
	protected String helmuga;
	
	public Garraioa() {
		this.id_garraioa= "";
		this.enpresa = "";
		this.jatorria= "";
		this.helmuga = "";
	}
	public Garraioa(String ig,String en,String ja,String he) {
		this.id_garraioa= ig;
		this.enpresa = en;
		this.jatorria= ja;
		this.helmuga = he;
	}
	public String getId_garraioa() {
		return id_garraioa;
	}
	public void setId_garraioa(String id_garraioa) {
		this.id_garraioa = id_garraioa;
	}
	public String getEnpresa() {
		return enpresa;
	}
	public void setEnpresa(String enpresa) {
		this.enpresa = enpresa;
	}
	public String getJatorria() {
		return jatorria;
	}
	public void setJatorria(String jatorria) {
		this.jatorria = jatorria;
	}
	public String getHelmuga() {
		return helmuga;
	}
	public void setHelmuga(String helmuga) {
		this.helmuga = helmuga;
	}
	public abstract void PantailaratuG();
	
	public abstract boolean Premium();

	public void IrakurriG(Scanner teklatua) {
		System.out.println("Garraioaren ID: ");
		this.id_garraioa=teklatua.next();
		System.out.println("Garraioaren Enpresa: ");
		this.enpresa=teklatua.next();
		System.out.println("Jatorria :");
		this.jatorria=teklatua.next();
		System.out.println("Helmuga :");
		this.helmuga=teklatua.next();

	}
	
	

}
