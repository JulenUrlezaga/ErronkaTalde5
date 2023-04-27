package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class HegazkinaTest {

	@Test
	void testIrakurriH() {
		Scanner sc=new Scanner(System.in);
		Hegazkina h1=new Hegazkina(1, "1", "1", "1", "1", "1");
		
		Hegazkina h2=new Hegazkina();
		h2.IrakurriH(sc);
		
		equals(h1.getId_garraioa().equals(h2.getId_garraioa()));
		equals(h1.getEnpresa().equals(h2.getEnpresa()));
		equals(h1.getAireportua().equals(h2.getAireportua()));
		equals(h1.getHelmuga().equals(h2.getHelmuga()));
		equals(h1.getJatorria().equals(h2.getJatorria()));
		assertEquals(h1.getH_Jesarlekuak(), h2.getH_Jesarlekuak());
	}

}
