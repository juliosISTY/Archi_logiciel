package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Ue {


	private String nomUE;
	private int coefUE;
	private String descUE;
	private ResultSet resultat;
	
	public Ue(String nomUE,int coefUE, String descUE) {
		
	    this.nomUE= nomUE;
	    this.coefUE = coefUE;
	    this.descUE = descUE;
	
	}

    public void RecupererUe(JTable tableau) {
    	
    	
    	Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		String sql="SELECT nomue, coefue, descue FROM ue";
	
		try {
			ps=con.prepareStatement(sql);
			resultat=ps.executeQuery();
			tableau.setModel(DbUtils.resultSetToTableModel(resultat));
			//tableau.setTableHeader(null);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}


	public String getNomUE() {
		return nomUE;
	}


	public void setNomUE(String nomUE) {
		this.nomUE = nomUE;
	}


	public int getCoefUE() {
		return coefUE;
	}


	public void setCoefUE(int coefUE) {
		this.coefUE = coefUE;
	}


	public String getDescUE() {
		return descUE;
	}


	public void setDescUE(String descUE) {
		this.descUE = descUE;
	}
	
	
	
	public void creer_UE() {
		
		
		Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
	try {
		
		String sql="INSERT INTO ue(nomue,coefue,descue) VALUES(?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1,this.nomUE);
		ps.setInt(2,this.coefUE);
		ps.setString(3,this.descUE);
		ps.execute();
		
		System.out.println("insertion ok!");
		
	} catch ( SQLException e) {
		System.out.println(e.toString());	
	}
		
		
	}
	public void supprimer_UE() {
	/*	Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		try {
			
			String sql="INSERT INTO ue(nomue,coefue,descue) VALUES(?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.execute();
			
			System.out.println("suppression ok!");
			
		} catch ( SQLException e) {
			System.out.println(e.toString());	
		}*/
	}
	
	
	
	
	
	
	
}