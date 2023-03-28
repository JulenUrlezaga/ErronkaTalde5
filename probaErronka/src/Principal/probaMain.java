package Principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Klaseak.Bezeroa;
import Klaseak.Bus;
import Klaseak.Hegazkina;
import Klaseak.Itsasontzia;
import Klaseak.Ostatua;


public class probaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Bezeroa> bezeroa=new ArrayList<Bezeroa>();
		ArrayList<Ostatua> ostatu=new ArrayList<Ostatua>();
		ArrayList<Bus>bus=new ArrayList<Bus>();
		ArrayList<Hegazkina>hegazkina=new ArrayList<Hegazkina>();
		ArrayList<Itsasontzia>itsasontzia=new ArrayList<Itsasontzia>(); 
		

		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/BidaiAgentzia", "root", "");
			
			System.out.println("Konexio zuzena");
			
			Statement st=conexion.createStatement();
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM BidaiAgentzia.Bus b, BidaiAgentzia.Garraioa g WHERE b.ID_Garraioa=g.ID_Garraioa;");
			while (rs1.next()) {
			Bus b1=new Bus();
			}
			ResultSet rs2 = st.executeQuery("SELECT * FROM BidaiAgentzaia.Hegazkina;");
			while (rs2.next()) {
			}
			ResultSet rs3 = st.executeQuery("SELECT * FROM BidaiAgentzia.Itsasontzi;");
			while (rs3.next()) {

			}
			ResultSet rs4 = st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_G;");
			while (rs4.next()) {

			}
			ResultSet rs5 = st.executeQuery("SELECT * FROM BidaiAgentzia.Itsasontzi;");
			while (rs5.next()) {

			}
			ResultSet rs6=st.executeQuery("SELECT * FROM BidaiAgentzia.Garraioa;");
			while (rs6.next()) {
				
			}
			ResultSet rs7=st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_O;");
			while (rs7.next()) {
				
			}
			ResultSet rs8=st.executeQuery("SELECT * FROM BidaiAgentzia.Erreserba_O;");
			while (rs8.next()) {
				
			}
			ResultSet rs9=st.executeQuery("SELECT * FROM BidaiAgentzia.Ostatua;");
			st.close();
			rs1.close();
			rs2.close();
			rs3.close();
			rs4.close();
			rs5.close();
			conexion.close();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Konexioa ez da zuzena");
		}
		
	}

}
