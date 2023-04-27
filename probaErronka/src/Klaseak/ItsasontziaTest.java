package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ItsasontziaTest {

	@Test
	void testIrakurriI() {
		Scanner sc=new Scanner(System.in);
		Itsasontzia i1=new Itsasontzia("1", 1, "1", "1", "1", "1");
		
		Itsasontzia i2=new Itsasontzia();
		i2.IrakurriI(sc);
		
		equals(i1.getId_garraioa().equals(i2.getId_garraioa()));
		equals(i1.getEnpresa().equals(i2.getEnpresa()));
		equals(i1.getPortuak().equals(i2.getPortuak()));
		equals(i1.getHelmuga().equals(i2.getHelmuga()));
		equals(i1.getJatorria().equals(i2.getJatorria()));
		assertEquals(i1.getKamaroteak(), i2.getKamaroteak());
	}

}
