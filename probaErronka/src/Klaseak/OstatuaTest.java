package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class OstatuaTest {

	@Test
	void testIrakurriOstatua() {
		Scanner sc=new Scanner(System.in);
		
		Ostatua o1=new Ostatua(1, "1", "1", "1", 1);
		
		Ostatua o2=new Ostatua();
		o2.IrakurriOstatua(sc);
		
		assertEquals(o1.getClass(), o2.getID_Ostatua());
		equals(o1.getIzena().equals(o2.getIzena()));
		equals(o1.getLekua().equals(o2.getLekua()));
		equals(o1.getOstatu_Mota().equals(o2.getOstatu_Mota()));
		equals(o1.getIzarrak()==o2.getIzarrak());
		
	}

}
