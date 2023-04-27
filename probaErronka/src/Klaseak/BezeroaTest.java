package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class BezeroaTest {

	@Test
	void testIrakurriBezero() {
		Scanner sc = new Scanner(System.in);
		
		Bezeroa b1=new Bezeroa("1", "1", "1", "1", "1", 1);
		
		Bezeroa b2=new Bezeroa();
		b2.IrakurriBezero(sc);
		
		equals(b1.getNAN().equals(b2.getNAN()));
		equals(b1.getIzena().equals(b2.getIzena()));
		equals(b1.getAbizenak().equals(b2.getAbizenak()));
		equals(b1.getEmail().equals(b2.getEmail()));
		equals(b1.getTelefono().equals(b2.getTelefono()));
		assertEquals(b1.getOrdainketa_Metodoa(), b2.getOrdainketa_Metodoa());
		
	}

}
