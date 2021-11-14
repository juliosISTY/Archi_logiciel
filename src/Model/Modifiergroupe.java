package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import vue.ModifierGroupe;

public class Modifiergroupe {
	private ResultSet resultat;
	
	
	/**
	 * Cette focntion permet de remplire les champs d'un jtexfield automatiquement
	 * @param vu
	 */
	
	public void RemplireChamps(ModifierGroupe vu) {
		
		Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		
		String sql="SELECT * FROM groupe WHERE nomgroupe='" + vu.getNomGoupe() + "'";
	
		try {
			ps=con.prepareStatement(sql);
			resultat=ps.executeQuery();
			
			while (resultat.next()) {
				String nom=resultat.getString("nomgroupe").toString();
				System.out.println(nom);
				
				
				int idue=resultat.getInt("idue");
				System.out.println(idue);
				
				
				
				int idsujet=resultat.getInt("idsujet");
				System.out.println(idsujet);
				
				vu.getTextField().setText(nom);
				vu.getTextField_1().setText(""+idue);
				vu.getTextField_2().setText(""+idsujet);
				
			}
			
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	
	}
	
	/**
	 * Cette fonction permet de recuperer les etudiant en base de donnéées et les afficher dans un jtable
	 * @param tableau
	 */
	
	 public void RecupererEtudiants(JTable tableau) {
	    	
	    	Connection con=Dbconnection.Connect();
			PreparedStatement ps=null;
			
			String sql="SELECT nom,prenom FROM eleve";
		
			try {
				ps=con.prepareStatement(sql);
				resultat=ps.executeQuery();
				tableau.setModel(DbUtils.resultSetToTableModel(resultat));
			    
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
			
		}
	    
	    

}
