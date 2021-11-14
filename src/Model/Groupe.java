package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Groupe {

	
	private String nomGroupe;
	private int idue;
	private int idsujet;
	//private PreparedStatement prepare;
	private ResultSet resultat;

	
	public Groupe (String nomGroupe, int  idue, int idsujet) {
		this.nomGroupe= nomGroupe;
		this.idue=idue;
		this.idsujet=idsujet;

}
	/**
	 * 
	 * Constructeur par défaut
	 * 
	 */
	public Groupe() {
		
	}
	
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}



	public int getIdue() {
		return idue;
	}

	public void setIdue(int idue) {
		this.idue = idue;
	}

	public int getIdsujet() {
		return idsujet;
	}


	public void setIdsujet(int idsujet) {
		this.idsujet = idsujet;
	}


	public void creer_Groupe() {
		
		Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
	try {
		
		String sql="INSERT INTO groupe(nomgroupe,idue,idsujet) VALUES(?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1,this.nomGroupe);
		ps.setInt(2,this.idue);
		ps.setInt(3,this.idsujet);
		ps.execute();
		
		System.out.println("insertion ok!");
		
	} catch ( SQLException e) {
		System.out.println(e.toString());	
	}
		
		
		
	}
	
	/**
	 * 
	 * @param tableau
	 */
	
    public void RecupererGroupe(JTable tableau) {
    	
    	Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		String sql="SELECT nomgroupe FROM groupe";
	
		try {
			ps=con.prepareStatement(sql);
			resultat=ps.executeQuery();
			tableau.setModel(DbUtils.resultSetToTableModel(resultat));
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}
    
    
    
    
	
	public void supprimer_Groupe() {
		
	}


	public void creer_Groupes_aleatoire(Student student) {
	
	}
	
	public void changer_student() {
	
	}
	

}