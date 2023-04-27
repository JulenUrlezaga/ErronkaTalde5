package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class BusTest {

	@Test
	void testIrakurriB() {
		Scanner sc=new Scanner(System.in);
		Bus b1=new Bus("1", 1, "1", "1", "1", "1");
		
		Bus b2=new Bus();
		b2.IrakurriB(sc);
		
		equals(b1.getId_garraioa().equals(b2.getId_garraioa()));
		equals(b1.getEnpresa().equals(b2.getEnpresa()));
		equals(b1.getGeltokiak().equals(b2.getGeltokiak()));
		equals(b1.getHelmuga().equals(b2.getHelmuga()));
		equals(b1.getJatorria().equals(b2.getJatorria()));
		assertEquals(b1.getB_Jesarlekuak(), b2.getB_Jesarlekuak());
		
		
	}

}
