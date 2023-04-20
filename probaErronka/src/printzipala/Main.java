package printzipala;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Klaseak.Bezeroa;
import Klaseak.Bus;
import Klaseak.Erreserba_G;
import Klaseak.Erreserba_O;
import Klaseak.Faktura;
import Klaseak.Garraioa;
import Klaseak.Hegazkina;
import Klaseak.Itsasontzia;
import Klaseak.Ostatua;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean bbezero = false;
		boolean bostatu = false;
		boolean berreserbag = false;
		boolean berreserbao = false;
		boolean bgarraio = false;
		boolean bbus = false;
		boolean bhegazkin = false;
		boolean bitsasontzi = false;

		ArrayList<Bezeroa> bezeroa = new ArrayList<Bezeroa>();
		ArrayList<Ostatua> ostatu = new ArrayList<Ostatua>();
		ArrayList<Erreserba_G> erreserbag = new ArrayList<Erreserba_G>();
		ArrayList<Erreserba_O> erreserbao = new ArrayList<Erreserba_O>();
		ArrayList<Garraioa> garraioa = new ArrayList<Garraioa>();
		ArrayList<Bus> bus = new ArrayList<Bus>();
		ArrayList<Hegazkina> hegazkina = new ArrayList<Hegazkina>();
		ArrayList<Itsasontzia> itsasontzia = new ArrayList<Itsasontzia>();
		ArrayList<Faktura> fakturak = new ArrayList<Faktura>();
		Faktura faktura = new Faktura();
		// Datu basetik datuak kopiatu
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/BidaiAgentzia", "root", "");

			System.out.println("Konekxio zuzena");

			Statement st = conexion.createStatement();

			ResultSet rs1 = st.executeQuery(
					"SELECT * FROM BidaiAgentzia.Bus b, BidaiAgentzia.Garraioa g WHERE b.ID_Garraioa=g.ID_Garraioa;");
			while (rs1.next()) {
				Bus b1 = new Bus(rs1.getString("geltokiak"), rs1.getInt("B_jesarlekuak"), rs1.getString("ID_Garraioa"),
						rs1.getString("Enpresa"), rs1.getString("Jatorria"), rs1.getString("Helmuga"));
				bus.add(b1);
			}
			ResultSet rs2 = st.executeQuery(
					"SELECT * FROM BidaiAgentzia.Hegazkina h, BidaiAgentzia.Garraioa g WHERE h.ID_Garraioa=g.ID_Garraioa;");
			while (rs2.next()) {
				Hegazkina h1 = new Hegazkina(rs2.getInt("H_Jesarlekua"), rs2.getString("ID_Garraioa"),
						rs2.getString("Enpresa"), rs2.getString("Jatorria"), rs2.getString("Helmuga"),
						rs2.getString("Aireportua"));
				hegazkina.add(h1);
			}
			ResultSet rs3 = st.executeQuery(
					"SELECT * FROM BidaiAgentzia.Itsasontzia i, BidaiAgentzia.Garraioa g WHERE i.ID_Garraioa=g.ID_Garraioa;");
			while (rs3.next()) {
				Itsasontzia i1 = new Itsasontzia(rs3.getString("Portua"), rs3.getInt("Kamaroteak"),
						rs3.getString("ID_Garraioa"), rs3.getString("Enpresa"), rs3.getString("Jatorria"),
						rs3.getString("Helmuga"));
				itsasontzia.add(i1);
			}
			ResultSet rs4 = st.executeQuery("SELECT * FROM BidaiAgentzia.erreserba_g;");
			while (rs4.next()) {
				Erreserba_G eg1 = new Erreserba_G(rs4.getString("NAN"), rs4.getString("ID_Garraioa"),
						rs4.getDate("Irteera_data"), rs4.getDate("Helmuga_data"), rs4.getInt("Prezioa"));
				erreserbag.add(eg1);
			}
			ResultSet rs5 = st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_O;");
			while (rs5.next()) {
				Erreserba_O eo1 = new Erreserba_O(rs5.getString("NAN"), rs5.getString("ID_ostatua"),
						rs5.getDate("Sarrera_data"), rs5.getDate("Irteera_data"), rs5.getInt("Prezioa"));
				erreserbao.add(eo1);
			}
			ResultSet rs6 = st.executeQuery("SELECT * FROM BidaiAgentzia.Bezeroa;");
			while (rs6.next()) {
				Bezeroa b1 = new Bezeroa(rs6.getString("NAN"), rs6.getString("Izena"), rs6.getString("Abizenak"),
						rs6.getString("Telefono"), rs6.getString("Email"), rs6.getInt("Ordainketa_metodoa"));
				bezeroa.add(b1);
			}
			ResultSet rs7 = st.executeQuery("SELECT * FROM BidaiAgentzia.Ostatua;");
			while (rs7.next()) {
				Ostatua o1 = new Ostatua(rs7.getInt("ID_Ostatua"), rs7.getString("Lekua"), rs7.getString("Ostatu_mota"),
						rs7.getString("izena"), rs7.getDouble("Izarrak"));
				ostatu.add(o1);
			}

			st.close();
			rs1.close();
			rs2.close();
			rs3.close();
			rs4.close();
			rs5.close();
			rs6.close();
			rs7.close();
			conexion.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Konexioa ez da zuzena");
		}
		// Datu basetik datuak kopiatu
		//
		try {
			FileInputStream fis = new FileInputStream("Faktura.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (fis.available() > 0) {
				fakturak = (ArrayList<Faktura>) ois.readObject();
				fakturak.add(faktura);
			}

			ois.close();
			fis.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error archivo no encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error de Entrada / Salida");
		} catch (InputMismatchException cnfe) {
			System.out.println("Error. Zenbaki bat sartu behar duzu");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error Clase No Encontrada");
		}
		//
		// menua

		int menu;
		String gar;
		String exit;
		String erreser;
		boolean irten = true;
		boolean err = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ongi etorri gure bidai agentziaren programara");
		do {
			System.out.println("1- Garraio baten jesarlekuak ikusi");
			System.out.println("2- Garraioaren geltokiak ikusi");
			System.out.println("3- Erreserba baten prezioa ikusi");
			System.out.println("4- Ostatuak ikusi");
			System.out.println("***********************************");
			menu = sc.nextInt();
			// aukerak
			switch (menu) {

			case 1:
				System.out.println("Zein garraioren jesarleku libreak ikusi nahi dituzu?");
				gar = sc.next();
				if (gar.equalsIgnoreCase("busa")) {
					for (int i = 0; i < bus.size(); i++) {
						System.out.println(bus.get(i));
					}
				} else if (gar.equalsIgnoreCase("hegazkina")) {
					for (int i = 0; i < hegazkina.size(); i++) {
						System.out.println(hegazkina.get(i));
					}
				} else if (gar.equalsIgnoreCase("itsasontzia")) {
					for (int i = 0; i < itsasontzia.size(); i++) {
						System.out.println(itsasontzia.get(i));
					}
				}
				break;

			case 2:
				System.out.println("Zein garraioren geltokiak ikusi nahi dituzu?");
				gar = sc.next();
				if (gar.equalsIgnoreCase("busa")) {
					for (int i = 0; i < bus.size(); i++) {
						System.out.println(bus.get(i));
					}
				} else if (gar.equalsIgnoreCase("hegazkina")) {
					for (int i = 0; i < hegazkina.size(); i++) {
						System.out.println(hegazkina.get(i));
					}
				} else if (gar.equalsIgnoreCase("itsasontzia")) {
					for (int i = 0; i < itsasontzia.size(); i++) {
						System.out.println(itsasontzia.get(i));
					}
				}
				break;

			case 3:
				System.out.println("Sartu erreserbaren ID-a");
				erreser = sc.next();
				for (int i = 0; i < erreserbag.size(); i++) {
					if (erreser == erreserbag.get(i).getID_garraio()) {
						System.out.println("Erreserba horren prezioa: " + erreserbag.get(i).getPrezioa());
					}
				}
				break;

			case 4:
				for (int i = 0; i < ostatu.size(); i++) {
					ostatu.get(i).PantailaratuOstuta();
				}
				break;
				
			case 5: 
				
					System.out.println("Zein garraioren berri bat nahi dituzu?");
					gar = sc.next();
					if (gar.equalsIgnoreCase("busa")) {
						Bus bus1= new Bus();
						bus1.IrakurriB(sc);
						bus.add(bus1);
						bbus=true;
						bhegazkin=true;
						bitsasontzi=true;
						bgarraio=true;
						berreserbag=true;
					} else if (gar.equalsIgnoreCase("hegazkina")) {
						for (int i = 0; i < hegazkina.size(); i++) {
							System.out.println(hegazkina.get(i));
						}
					} else if (gar.equalsIgnoreCase("itsasontzia")) {
						for (int i = 0; i < itsasontzia.size(); i++) {
							System.out.println(itsasontzia.get(i));
						}
					}
			}
			
			// aukerak
			// irteera menu-a
			System.out.println("Programatik irten nahi duzu?");
			exit = sc.next();
			if (exit.equalsIgnoreCase("bai")) {
				irten = true;
			} else if (exit.equalsIgnoreCase("ez")) {
				irten = false;
			} else {
				err = true;
			}
			while (err) {
				System.out.println("Aukera hori ez da onargarria, saiatu berriro");
				exit = sc.next();
				if (exit.equalsIgnoreCase("bai")) {
					irten = true;
					err = false;
				} else if (exit.equalsIgnoreCase("ez")) {
					irten = false;
					err = false;
				}
			}
			// irteera menu-a

		} while (!irten);
		// menu

		// Datuak eguneratu
		if (bbus) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM bus;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bhegazkin) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM hegazkina;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}

		}
		if (bitsasontzi) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM itsasontzia;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (berreserbao) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM erreserba_o;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (berreserbag) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM erreserba_g;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bgarraio) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM garraioa;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}

		}
		if (bostatu) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM ostatua;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bbezero) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				col = "DELETE FROM bezeroa;";
				st.executeUpdate(col);
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bbezero) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String NAN;
				String izena;
				String abizenak;
				String telefono;
				String email;
				int ordainketa_metodoa;

				for (int pos = 0; pos < bezeroa.size(); pos++) {
					NAN = bezeroa.get(pos).getNAN();
					izena = bezeroa.get(pos).getIzena();
					abizenak = bezeroa.get(pos).getAbizenak();
					telefono = bezeroa.get(pos).getNAN();
					email = bezeroa.get(pos).getEmail();
					ordainketa_metodoa = bezeroa.get(pos).getOrdainketa_Metodoa();
					col = "insert into bezeroa values ('" + NAN + "','" + izena + "','" + abizenak + "','" + telefono
							+ "','" + email + "'," + ordainketa_metodoa + ");";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bostatu) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				int ID_ostatua;
				String lekua;
				String ostatu_mota;
				String izena;
				double izarrak;

				for (int pos = 0; pos < ostatu.size(); pos++) {
					ID_ostatua = ostatu.get(pos).getID_Ostatua();
					lekua = ostatu.get(pos).getLekua();
					ostatu_mota = ostatu.get(pos).getOstatu_Mota();
					izena = ostatu.get(pos).getIzena();
					izarrak = ostatu.get(pos).getIzarrak();
					col = "insert into ostatua values (" + ID_ostatua + ",'" + lekua + "','" + ostatu_mota + "','"
							+ izena + "'," + izarrak + ");";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bgarraio) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String ID_garraio;
				String empresa;
				String jatorria;
				String Helmuga;

				for (int pos = 0; pos < garraioa.size(); pos++) {
					ID_garraio = garraioa.get(pos).getId_garraioa();
					empresa = garraioa.get(pos).getEnpresa();
					jatorria = garraioa.get(pos).getJatorria();
					Helmuga = garraioa.get(pos).getHelmuga();
					col = "insert into garraioa values ('" + ID_garraio + "','" + empresa + "','" + jatorria + "','"
							+ Helmuga + "');";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}

		}
		if (berreserbag) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String NAN;
				String ID_garraio;
				Date irteera_data;
				Date helmuga_data;
				double prezioa;

				for (int pos = 0; pos < erreserbag.size(); pos++) {
					NAN = erreserbag.get(pos).getID_garraio();
					ID_garraio = erreserbag.get(pos).getID_garraio();
					irteera_data = erreserbag.get(pos).getIrteera_data();
					helmuga_data = erreserbag.get(pos).getHelmuga_data();
					prezioa = erreserbag.get(pos).getPrezioa();
					col = "insert into erreserba_g values ('"+NAN+"','"+ ID_garraio +"','"+irteera_data+"','"+helmuga_data+"','"+ prezioa+"');";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (berreserbao) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String NAN;
				String ID_ostatu;
				Date sarrera_data;
				Date irteera_data;
				double prezioa;

				for (int pos = 0; pos < erreserbao.size(); pos++) {
					NAN = erreserbao.get(pos).getNAN();
					ID_ostatu = erreserbao.get(pos).getID_Ostatua();
					sarrera_data = erreserbao.get(pos).getSarrera_data();
					irteera_data = erreserbao.get(pos).getIrteera_data();
					prezioa = erreserbao.get(pos).getPrezioa();
					col = "insert into erreserba_o values ('" + NAN + "', " + ID_ostatu + ", '" + sarrera_data + "', '"
							+ irteera_data + "', " + prezioa + ");";
					st.execute(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bitsasontzi) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String ID_garraio;
				String Portua;
				int Kamaroteak;

				for (int pos = 0; pos < itsasontzia.size(); pos++) {
					ID_garraio = itsasontzia.get(pos).getId_garraioa();
					Portua = itsasontzia.get(pos).getPortuak();
					Kamaroteak = itsasontzia.get(pos).getKamaroteak();
					col = "insert into itsasontzia values ('" + ID_garraio + "', '" + Portua + "', " + Kamaroteak + ");";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}
		if (bhegazkin) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String ID_garraio;
				String Aireportua;
				int H_Jesarlekuak;

				for (int pos = 0; pos < hegazkina.size(); pos++) {
					ID_garraio = hegazkina.get(pos).getId_garraioa();
					Aireportua = hegazkina.get(pos).getEnpresa();
					H_Jesarlekuak = hegazkina.get(pos).getH_Jesarlekuak();
					col = "insert into hegazkina values ('" + ID_garraio + "','" + Aireportua + "'," + H_Jesarlekuak
							+ ");";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}

		}
		if (bbus) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				String ID_garraio;
				String Geltokiak;
				int B_Jesarlekuak;

				for (int pos = 0; pos < bus.size(); pos++) {
					ID_garraio = bus.get(pos).getId_garraioa();
					Geltokiak = bus.get(pos).getEnpresa();
					B_Jesarlekuak = bus.get(pos).getB_Jesarlekuak();
					col = "insert into bus values ('" + ID_garraio + "','" + Geltokiak + "'," + B_Jesarlekuak
							+ ");";
					st.executeUpdate(col);
				}
				st.close();

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error de conexion");
			}
		}

	}

}
