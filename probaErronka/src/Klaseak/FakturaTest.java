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
		
		Faktura f1=new Faktura("1", 1, "1", d1, d2, 0);
		
		Faktura f2=new Faktura();
		f2.IrakurriFak(sc);
		
		equals(f1.getNAN().equals(f2.getNAN()));
		assertEquals(f1.getOrdainketa_metodoa(), f2.getOrdainketa_metodoa());
		equals(f1.getId().equals(f2.getId()));
		equals(f1.getIrteera_data().equals(f2.getIrteera_data()));
		equals(f1.getHelmuga_data().equals(f2.getHelmuga_data()));
		equals(f1.getPrezioa()==f1.getPrezioa());
		
	}

	@Test
	void testKalkulatuTotala() {
		double total=0;
		int prezioa=5;
		Faktura f=new Faktura();
		f.kalkulatuTotala();
		equals(6.05==f.getPrezioa());
	}

}
