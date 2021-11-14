package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Sujet {

	
	private String nomSujet;
   	private String descriptif;
	private int idue;
	private ResultSet resultat;
	public Sujet(String nomSujet, String descriptif,int idue) {
		
		this.nomSujet = nomSujet;
		this.descriptif = descriptif;
		this.idue=idue;
		
	}
	/**
	 * Cette fonction permet de recupérer dans la base de donnée les information concernant un 
	 * @param tableau
	 */
public void RecupererSujet(JTable tableau) {
    	
    	
    	Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		String sql="SELECT nom,prenom,age,filiere FROM eleve";
	
		try {
			ps=con.prepareStatement(sql);
			resultat=ps.executeQuery();
			tableau.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}
	
	

	public String getNomSujet() {
		return nomSujet;
	}

	public void setNomSujet(String nomSujet) {
		this.nomSujet = nomSujet;
	}
/*public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}*/

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	public int  getIdue() {
		return idue;
	}

	public void setUe(int idue) {
		this.idue = idue;
	}
	
	public void creerSujet() {
		
			Connection con=Dbconnection.Connect();
			PreparedStatement ps=null;
			
		try {
			
			String sql="INSERT INTO sujet(nomsujet,date,descsujet,idue) VALUES(?,CURRENT_DATE,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,this.nomSujet);
			//ps.setString(2,this.date);
			ps.setString(2,this.descriptif);
			ps.setInt(3,this.idue);
			ps.execute();
			
			System.out.println("insertion ok!");
			
		} catch ( SQLException e) {
			System.out.println(e.toString());	
		}	
			
	}
	

	public void suprimerSujet() {
		
	}
	
	

}