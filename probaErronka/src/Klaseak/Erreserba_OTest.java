package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Erreserba_OTest {

	@Test
	void testIrakurriErrG() {
		Scanner sc=new Scanner(System.in);
		
		Date d1=new Date(1/1/1);
		Date d2=new Date(1/1/1);
		
		Erreserba_O eo1=new Erreserba_O("", "", d1, d2, 0);
		
		Erreserba_O eo2=new Erreserba_O();
		eo2.PantairalatuErrO();
		
		equals(eo1.getID_Ostatua().equals(eo2.getNAN()));
		equals(eo2.getNAN().equals(eo2.getNAN()));
		equals(eo1.getSarrera_data().equals(eo2.getSarrera_data()));
		equals(eo1.getIrteera_data().equals(eo2.getIrteera_data()));
		equals(eo1.getPrezioa()==eo1.getPrezioa());
	}

}
