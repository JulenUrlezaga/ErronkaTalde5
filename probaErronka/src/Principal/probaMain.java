package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Klaseak.Bus;
import Klaseak.Hegazkina;
import Klaseak.Itsasontzia;


public class probaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
				
		ArrayList<Bus>bus=new ArrayList<Bus>();
		ArrayList<Hegazkina>hegazkina=new ArrayList<Hegazkina>();
		ArrayList<Itsasontzia>itsasontzia=new ArrayList<Itsasontzia>(); 
		

		try {
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/BidaiAgentzia", "root", "");
			
			System.out.println("Konexio zuzena");
			
			Statement st=conexion.createStatement();
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM BidaiAgentzia.Bus b, BidaiAgentzia.Garraioa g WHERE b.ID_Garraioa=g.ID_Garraioa;");
			while (rs1.next()) {
			Bus b1=new Bus(rs1.getString("g.ID_Garraioa"), rs1.getString("g.Empresa"), rs1.getString("g.Jatorria"), rs1.getString("g.Helmuga"), rs1.getString("b.geltokiak"), rs1.getInt("B_Jesarlekuak"));
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
//patata
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
			System.out.println("Konexioa ez da zuzenañ");
		}
		
	}

}
