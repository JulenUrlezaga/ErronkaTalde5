package Principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Klaseak.Bezeroa;
import Klaseak.Bus;
import Klaseak.Erreserba_G;
import Klaseak.Erreserba_O;
import Klaseak.Garraioa;
import Klaseak.Hegazkina;
import Klaseak.Itsasontzia;
import Klaseak.Ostatua;


public class probaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Bezeroa> bezeroa=new ArrayList<Bezeroa>();
		ArrayList<Ostatua> ostatu=new ArrayList<Ostatua>();
		ArrayList<Erreserba_G>erreserbag=new ArrayList<Erreserba_G>();
		ArrayList<Erreserba_O>erreserbao=new ArrayList<Erreserba_O>();
		ArrayList<Garraioa>garraioa=new ArrayList<Garraioa>();
		ArrayList<Bus>bus=new ArrayList<Bus>();
		ArrayList<Hegazkina>hegazkina=new ArrayList<Hegazkina>();
		ArrayList<Itsasontzia>itsasontzia=new ArrayList<Itsasontzia>(); 


		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/BidaiAgentzia", "root", "");
			
			System.out.println("Konexio zuzena");
			
			Statement st=conexion.createStatement();
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM BidaiAgentzia.Bus b, BidaiAgentzia.Garraioa g WHERE b.ID_Garraioa=g.ID_Garraioa;");
			while (rs1.next()) {
				Bus b1=new Bus(rs1.getString("geltokiak"), rs1.getInt("B_jesarlekuak"), rs1.getString("ID_Garraioa"), rs1.getString("Enpresa"), rs1.getString("Jatorria"), rs1.getString("Helmuga"));
				bus.add(b1);
			}
			ResultSet rs2 = st.executeQuery("SELECT * FROM BidaiAgentzaia.Hegazkina h, BidaiAgentzia.Garraioa g WHERE h.ID_Garraioa=g.ID_Garraioa;");
			while (rs2.next()) {
				Hegazkina h1=new Hegazkina(rs2.getInt("H_Jesarlekua"), rs2.getString("ID_Garraioa"), rs2.getString("Enpresa"), rs2.getString("Jatorria"), rs2.getString("Helmuga"));
				hegazkina.add(h1);
			}
			ResultSet rs3 = st.executeQuery("SELECT * FROM BidaiAgentzia.Itsasontzi i, BidaiAgentzia.Garraioa g WHERE i.ID_Garraioa=g.ID_Garraioa;");
			while (rs3.next()) {
				Itsasontzia i1=new Itsasontzia(rs3.getString("Portua"), rs3.getInt("Kamaroteak"), rs3.getString("ID_Garraioa"), rs3.getString("Enpresa"), rs3.getString("Jatorria"), rs3.getString("Helmuga"));
				itsasontzia.add(i1);
			}
			ResultSet rs4 = st.executeQuery("SELECT * FROM BidaiAgentzia.erreserba_g;");
			while (rs4.next()) {
				Erreserba_G eg1=new Erreserba_G(rs4.getString("NAN"), rs4.getString("ID_Garraioa"), rs4.getDate("Irteera_data"), rs4.getDate("Helmuga_data"), rs4.getInt("prezioa"));
				erreserbag.add(eg1);
			}
			ResultSet rs5=st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_O;");
			while (rs5.next()) {
				Erreserba_O eo1=new Erreserba_O();
				erreserbao.add(eo1);
			}
			ResultSet rs6=st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_O;");
			while (rs6.next()) {
				
			}
			ResultSet rs9=st.executeQuery("SELECT * FROM BidaiAgentzia.Ostatua;");
			st.close();
			rs1.close();
			rs2.close();
			rs3.close();
			rs4.close();
			rs5.close();
			rs6.close();
			conexion.close();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Konexioa ez da zuzena");
		}
		
	}

}
