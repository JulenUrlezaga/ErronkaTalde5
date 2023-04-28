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
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Klaseak.Bezeroa;
import Klaseak.Bus;
import Klaseak.Erreserba_G;
import Klaseak.Erreserba_O;
import Klaseak.Faktura;
import Klaseak.Formato;
import Klaseak.Hegazkina;
import Klaseak.Itsasontzia;
import Klaseak.Ostatua;

public class Mainproba {
	private static final Logger LOGGER = Logger.getLogger("Nombre del logger");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler consoleHandler = null;
		Handler fileHandler = null;
		Handler fileHandler1 = null;

		ArrayList<Bezeroa> bezeroa = new ArrayList<Bezeroa>();
		ArrayList<Ostatua> ostatu = new ArrayList<Ostatua>();
		ArrayList<Erreserba_G> erreserbag = new ArrayList<Erreserba_G>();
		ArrayList<Erreserba_O> erreserbao = new ArrayList<Erreserba_O>();
		ArrayList<Bus> bus = new ArrayList<Bus>();
		ArrayList<Hegazkina> hegazkina = new ArrayList<Hegazkina>();
		ArrayList<Itsasontzia> itsasontzia = new ArrayList<Itsasontzia>();
		ArrayList<Faktura> fakturak = new ArrayList<Faktura>();
		Faktura faktura = new Faktura();
		Boolean bbezero = false;
		Boolean bostatua = false;
		Boolean berreserbag = false;
		Boolean berreserbao = false;
		Boolean bbus = false;
		Boolean bhegazkin = false;
		Boolean bitsasontzi = false;
		Boolean bfaktura = false;
		Boolean bgarraioa = false;
		// Datu basetik datuak kopiatu
		try {

			fileHandler = new FileHandler("./logs/ficheroLogErrores.log", true);

			fileHandler1 = new FileHandler("./logs/ficheroLogActividades" + System.currentTimeMillis() + ".log", false);

			fileHandler.setFormatter(new Formato());

			fileHandler1.setFormatter(new SimpleFormatter());

			LOGGER.addHandler(fileHandler);

			LOGGER.addHandler(fileHandler1);

			fileHandler.setLevel(Level.SEVERE);

			fileHandler1.setLevel(Level.FINE);

			LOGGER.setLevel(Level.FINE);
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/BidaiAgentzia", "root", "");

				System.out.println("Konexio zuzena");

				Statement st = conexion.createStatement();

				ResultSet rs1 = st.executeQuery(
						"SELECT * FROM BidaiAgentzia.Bus b, BidaiAgentzia.Garraioa g WHERE b.ID_Garraioa=g.ID_Garraioa;");
				while (rs1.next()) {
					Bus b1 = new Bus(rs1.getString("geltokiak"), rs1.getInt("B_jesarlekuak"),
							rs1.getString("ID_Garraioa"), rs1.getString("Enpresa"), rs1.getString("Jatorria"),
							rs1.getString("Helmuga"));
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
					Ostatua o1 = new Ostatua(rs7.getInt("ID_Ostatua"), rs7.getString("Lekua"),
							rs7.getString("Ostatu_mota"), rs7.getString("izena"), rs7.getDouble("Izarrak"));
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

			try {
				FileInputStream fis = new FileInputStream("Fakturak.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);

				while (fis.available() > 0) {
					faktura = (Faktura) ois.readObject();
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

			// menua

			int menu = 0;
			String gar;
			String erreser;
			boolean irten = true;
			Scanner sc = new Scanner(System.in);
			System.out.println("Ongi etorri gure bidai agentziaren programara");
			do {
				System.out.println("0- Programatik irten");
				System.out.println("1- Garraio baten jesarlekuak ikusi");
				System.out.println("2- Garraioaren geltokiak ikusi");
				System.out.println("3- Erreserba baten prezioa ikusi");
				System.out.println("4- Ostatuak ikusi");
				System.out.println("5- Garraio berriak sartu");
				System.out.println("6- Ostatu berria sartu");
				System.out.println("7- Erreserba bat egin");
				System.out.println("8- Bezeroak ikusi");
				System.out.println("9- Bezero berria sartu");
				System.out.println("***********************************");
				try {
					menu = sc.nextInt();
				} catch (NumberFormatException adi) {
					System.out.println("error");

				} catch (InputMismatchException adi) {
					System.out.println("error");
				}
				// aukerak
				switch (menu) {

				case 0:
					irten = true;
					break;

				case 1:
					System.out.println(
							"Zein garraioren jesarleku libreak ikusi nahi dituzu? (busa,hegazkina,itsasontzia)");
					gar = sc.next();
					if (gar.equalsIgnoreCase("busa")) {
						for (int i = 0; i < bus.size(); i++) {
							System.out.println(bus.get(i).getB_Jesarlekuak());
						}
					} else if (gar.equalsIgnoreCase("hegazkina")) {
						for (int i = 0; i < hegazkina.size(); i++) {
							System.out.println(hegazkina.get(i).getH_Jesarlekuak());
						}
					} else if (gar.equalsIgnoreCase("itsasontzia")) {
						for (int i = 0; i < itsasontzia.size(); i++) {
							System.out.println(itsasontzia.get(i).getKamaroteak());
						}
					}
					break;

				case 2:
					System.out.println("Zein garraioren geltokiak ikusi nahi dituzu?");
					gar = sc.next();
					if (gar.equalsIgnoreCase("busa")) {
						for (int i = 0; i < bus.size(); i++) {
							System.out.println(bus.get(i).getGeltokiak());
						}
					} else if (gar.equalsIgnoreCase("hegazkina")) {
						for (int i = 0; i < hegazkina.size(); i++) {
							System.out.println(hegazkina.get(i).getHelmuga());
							System.out.println(hegazkina.get(i).getJatorria());
						}
					} else if (gar.equalsIgnoreCase("itsasontzia")) {
						for (int i = 0; i < itsasontzia.size(); i++) {
							System.out.println(itsasontzia.get(i).getJatorria());
							System.out.println(itsasontzia.get(i).getHelmuga());
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
					try {
						for (int i = 0; i < ostatu.size(); i++) {
							ostatu.get(i).PantailaratuOstuta();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}

					break;

				case 5:

					System.out.println("Zein garraio mota sartu nahi duzu?");
					gar = sc.next();
					if (gar.equalsIgnoreCase("busa")) {
						Bus bus1 = new Bus();
						bus1.IrakurriB(sc);
						bus.add(bus1);
						bbus = true;
						bhegazkin = true;
						bitsasontzi = true;
						berreserbag = true;
						bgarraioa = true;
					} else if (gar.equalsIgnoreCase("hegazkina")) {
						Hegazkina hegaz1 = new Hegazkina();
						hegaz1.IrakurriH(sc);
						hegazkina.add(hegaz1);
						bbus = true;
						bhegazkin = true;
						bitsasontzi = true;
						berreserbag = true;
						bgarraioa = true;
					} else if (gar.equalsIgnoreCase("itsasontzia")) {
						Itsasontzia itsas1 = new Itsasontzia();
						itsas1.IrakurriI(sc);
						itsasontzia.add(itsas1);
						bbus = true;
						bhegazkin = true;
						bitsasontzi = true;
						berreserbag = true;
						bgarraioa = true;
					}
					break;

				case 6:

					System.out.println("Ostatuaren datuak sartu");
					Ostatua ost = new Ostatua();
					ost.IrakurriOstatua(sc);
					ostatu.add(ost);
					bostatua = true;
					berreserbao = true;
					break;

				case 7:

					System.out.println("Erreserbarik egin duzu iraganean?");
					boolean zuzen;
					do {
						String bezn;
						bezn = sc.next();
						if (bezn.equalsIgnoreCase("bai")) {
							zuzen = true;
							System.out.println("Sartu zuren NAN zenbakia:");
							String bnan;
							boolean rep = true;
							int c = 0;
							bnan = sc.next();
							while (c < bezeroa.size() && rep) {
								if (bnan.equals(bezeroa.get(c).getNAN())) {
									rep = false;
									c = c++;
								} else {
									System.out.println("Zure nan zenbakia ez da aurkitu, saiatu berriro");
									bnan = sc.next();
									rep = true;

								}
							}

						} else if (bezn.equalsIgnoreCase("ez")) {
							zuzen = true;
							boolean rep = false;
							System.out.println("Zure datuak erregistratu:");
							Bezeroa b1 = new Bezeroa();
							do {
								b1.IrakurriBezero(sc);

								try {
									for (int i = 0; i < bezeroa.size(); i++) {
										if (b1.getNAN().equals(bezeroa.get(i).getNAN())) {
											System.out.println("Beste bezero baten zenbakia da hori, saiatu berriro");
											rep = true;
										} else {
											rep = false;
										}
									}
								} catch (IndexOutOfBoundsException a) {
									System.out.println("Error");
								}
							} while (rep);
							bezeroa.add(b1);
							berreserbao = true;
							berreserbag = true;
							bbezero = true;

						} else {
							System.out.println("erantzun hori ez da onargarria, saiatu berriro");
							zuzen = false;
						}

					} while (!zuzen);
					System.out.println("Zer errerbatu nahi duzu(Ostatua/Garraioa)");
					String OG;
					OG = sc.next();
					if (OG.equalsIgnoreCase("Ostatua")) {
						Erreserba_O eo = new Erreserba_O();
						eo.IrakurriErrG(sc);
						erreserbao.add(eo);
						berreserbao = true;
					} else if (OG.equalsIgnoreCase("Garraioa")) {
						Erreserba_G eg = new Erreserba_G();
						eg.IrakurriErrG(sc);
						erreserbag.add(eg);
						berreserbag = true;
					}
					break;
				case 8:
					try {
						for (int i = 0; i < bezeroa.size(); i++) {
							bezeroa.get(i).PantailaratuBezero();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}

					break;
				case 9:
					Bezeroa be = new Bezeroa();
					be.IrakurriBezero(sc);
					bezeroa.add(be);
					bbezero = true;
					break;
				case 10:

					Faktura fa1 = new Faktura();
					System.out.println("Busak : ");
					try {
						for (int i = 0; i < bus.size(); i++) {
							bus.get(i).PantailaratuG();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}
					System.out.println("Hegakinak : ");
					try {
						for (int i = 0; i < hegazkina.size(); i++) {
							hegazkina.get(i).PantailaratuG();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}
					System.out.println("Itsasontziak : ");
					try {
						for (int i = 0; i < itsasontzia.size(); i++) {
							itsasontzia.get(i).PantailaratuG();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}
					System.out.println("Ostautak : ");
					try {
						for (int i = 0; i < ostatu.size(); i++) {
							ostatu.get(i).PantailaratuOstuta();
						}
					} catch (IndexOutOfBoundsException a) {
						System.out.println("Error");
					}
					fa1.IrakurriFak(sc);
					
					fakturak.add(fa1);
					bfaktura = true;
					break;
				}

				// aukerak

			} while (!irten);
			// menu

			// Datuak ezabatu
			if (bbus) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
			if (bgarraioa) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
			if (bostatua) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
			// Datuak ezabatu

			// Datuak sartu
			if (bbezero) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
						col = "insert into bezeroa values ('" + NAN + "','" + izena + "','" + abizenak + "','"
								+ telefono + "','" + email + "'," + ordainketa_metodoa + ");";
						st.executeUpdate(col);
					}
					st.close();

					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error de conexion");
				}
			}
			if (bostatua) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
			if (bgarraioa) {
				try {
					String col = "";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
					Statement st = conexion.createStatement();
					String ID_garraio;
					String empresa;
					String jatorria;
					String Helmuga;

					for (int pos = 0; pos < bus.size(); pos++) {
						ID_garraio = bus.get(pos).getId_garraioa();
						empresa = bus.get(pos).getEnpresa();
						jatorria = bus.get(pos).getJatorria();
						Helmuga = bus.get(pos).getHelmuga();
						col = "insert into garraioa values ('" + ID_garraio + "','" + empresa + "','" + jatorria + "','"
								+ Helmuga + "');";
						st.executeUpdate(col);
					}
					for (int pos = 0; pos < hegazkina.size(); pos++) {
						ID_garraio = hegazkina.get(pos).getId_garraioa();
						empresa = hegazkina.get(pos).getEnpresa();
						jatorria = hegazkina.get(pos).getJatorria();
						Helmuga = hegazkina.get(pos).getHelmuga();
						col = "insert into garraioa values ('" + ID_garraio + "','" + empresa + "','" + jatorria + "','"
								+ Helmuga + "');";
						st.executeUpdate(col);
					}
					for (int pos = 0; pos < itsasontzia.size(); pos++) {
						ID_garraio = itsasontzia.get(pos).getId_garraioa();
						empresa = itsasontzia.get(pos).getEnpresa();
						jatorria = itsasontzia.get(pos).getJatorria();
						Helmuga = itsasontzia.get(pos).getHelmuga();
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
					Statement st = conexion.createStatement();
					String NAN;
					String ID_garraio;
					Date irteera_data;
					Date helmuga_data;
					double prezioa;

					for (int pos = 0; pos < erreserbag.size(); pos++) {
						NAN = erreserbag.get(pos).getNAN();
						ID_garraio = erreserbag.get(pos).getID_garraio();
						irteera_data = erreserbag.get(pos).getIrteera_data();
						helmuga_data = erreserbag.get(pos).getHelmuga_data();
						prezioa = erreserbag.get(pos).getPrezioa();
						col = "insert into erreserba_g values ('" + NAN + "','" + ID_garraio + "','" + irteera_data
								+ "','" + helmuga_data + "','" + prezioa + "');";
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
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
						col = "insert into erreserba_o values ('" + NAN + "', " + ID_ostatu + ", '" + sarrera_data
								+ "', '" + irteera_data + "', " + prezioa + ");";
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
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root",
							"");
					Statement st = conexion.createStatement();
					String ID_garraio;
					String Portua;
					int Kamaroteak;

					for (int pos = 0; pos < itsasontzia.size(); pos++) {
						ID_garraio = itsasontzia.get(pos).getId_garraioa();
						Portua = itsasontzia.get(pos).getPortuak();
						Kamaroteak = itsasontzia.get(pos).getKamaroteak();
						col = "insert into itsasontzia values ('" + ID_garraio + "', '" + Portua + "', " + Kamaroteak
								+ ");";
						st.executeUpdate(col);
					}
					st.close();

					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error de conexion");
				}

				if (bhegazkin) {
					try {
						String col = "";
						Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia",
								"root", "");
						Statement st = conexion.createStatement();
						String ID_garraio;
						String Aireportua;
						int H_Jesarlekuak;

						for (int pos = 0; pos < hegazkina.size(); pos++) {
							ID_garraio = hegazkina.get(pos).getId_garraioa();
							Aireportua = hegazkina.get(pos).getAireportua();
							H_Jesarlekuak = hegazkina.get(pos).getH_Jesarlekuak();
							col = "insert into hegazkina values ('" + ID_garraio + "','" + H_Jesarlekuak + "',"
									+ Aireportua + ");";
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
						Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia",
								"root", "");
						Statement st = conexion.createStatement();
						String ID_garraio;
						String Geltokiak;
						int B_Jesarlekuak;

						for (int pos = 0; pos < bus.size(); pos++) {
							ID_garraio = bus.get(pos).getId_garraioa();
							Geltokiak = bus.get(pos).getGeltokiak();
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
				if (bfaktura) {
					try {
						FileOutputStream fos = new FileOutputStream("Fakturak.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);

						Faktura faktura2 = new Faktura();
						for (int i = 0; i < fakturak.size(); i++) {

							faktura2 = fakturak.get(i);
							oos.writeObject(faktura2);
						}

						oos.close();
						fos.close();
					} catch (FileNotFoundException eah) {
						System.out.print("El archivo no existe");
						eah.printStackTrace();
					} catch (IOException eh) {
						System.out.print("El archivo no existe");
						eh.printStackTrace();
					}
				}
			}

		} catch (IOException a) {
			System.out.println("Se liado parda");
			System.out.println();
		}
	}

}
