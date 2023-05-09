package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class FakturaTest {

	@Test
	void testIrakurriFak() {
		Scanner sc=new Scanner(System.in);
		
		Date d1=new Date(1/1/1);
		Date d2=new Date(1/1/1);
		
		Faktura f1=new Faktura("1", 1, "1", d1, d2, 5);
		
		
		
		
		assertEquals(f1.getNAN(),"1");
		assertEquals(f1.getOrdainketa_metodoa(),1);
		assertEquals(f1.getId(),"1");
		assertEquals(f1.getIrteera_data(),1/1/1);
		assertEquals(f1.getHelmuga_data(),1/1/1);
		assertEquals(f1.getPrezioa(),5);
		
	}

	@Test
	void testKalkulatuTotala() {
		Date d1=new Date(1/1/1);
		Date d2=new Date(1/1/1);
		Faktura f=new Faktura("1", 1, "1", d1, d2,5);
		double prezioa=5;
		
		
		double total =f.kalkulatuTotala();
		assertEquals(6.05,total);
	}

}
