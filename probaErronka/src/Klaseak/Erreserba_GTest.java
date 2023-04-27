package Klaseak;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Erreserba_GTest {

	@Test
	void testIrakurriErrG() {
		Scanner sc = new Scanner(System.in);
		Date d1=new Date(1/1/1);
		Date d2=new Date(1/1/1);
		
		Erreserba_G eg1=new Erreserba_G("1", "1", d1, d2, 0);
		
		Erreserba_G eg2=new Erreserba_G();
		eg2.IrakurriErrG(sc);
		
		equals(eg1.getID_garraio().equals(eg2.getID_garraio()));
		equals(eg1.getNAN().equals(eg2.getNAN()));
		equals(eg1.getHelmuga_data().equals(eg2.getHelmuga_data()));
		equals(eg1.getIrteera_data().equals(eg2.getIrteera_data()));
		equals(eg1.getPrezioa()==eg2.getPrezioa());
		
	}

}
