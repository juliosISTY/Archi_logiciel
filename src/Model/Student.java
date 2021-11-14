package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Student {
	
	
	private String nomStudent;
	private String prenomStudent;
	private int ageStudent;
	private String mailStudent;
	private String Filiere;
	public int idgrp;
	private ResultSet resultat;
	
	
	

	/**
	 * Constructeur principale de la classe student
	 * @param nomStudent
	 * @param prenomStudent
	 * @param ageStudent
	 * @param mailStudent
	 * @param Filiere
	 * @param grp
	 */
	public Student(String nomStudent, String prenomStudent,int ageStudent,String mailStudent,String Filiere, int grp) {
		
	
		this.nomStudent=nomStudent;
		this.prenomStudent = prenomStudent;
		this.ageStudent= ageStudent;
		this.mailStudent = mailStudent;
		this.Filiere = Filiere;
		this.idgrp = grp;
		
	}
	
	/**
	 * Surcharge constructeur student
	 * @param nomStudent
	 * @param prenomStudent
	 * @param ageStudent
	 * @param mailStudent
	 * @param Filiere
	 */
	public Student(String nomStudent, String prenomStudent,int ageStudent,String mailStudent,String Filiere) {
		
		
		this.nomStudent=nomStudent;
		this.prenomStudent = prenomStudent;
		this.ageStudent= ageStudent;
		this.mailStudent = mailStudent;
		this.Filiere = Filiere;
		
		
	}
	
	/**
	 * Constructeur par défaut
	 */
	public Student() {
		
	}
	
	/**
	 * Cette fonction permet la récupération des ele
	 * @param tableau
	 */
public void RecupererStudent(JTable tableau) {
    	
    	
    	Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
		String sql="SELECT nom,prenom,age,filiere FROM eleve";
	
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
	
	

	public String getNomStudent() {
		return nomStudent;
	}
	public void setNomStudent(String nomStudent) {
		this.nomStudent = nomStudent;
		
	}
	
	public String getPrenomStudent() {
		return prenomStudent;
	}
	public void setPrenomStudent(String prenomStudent) {
		this.prenomStudent = prenomStudent;
	}
	
	public int getAgeStudent() {
		return ageStudent;
	}
	public void setAgeStudent(int ageStudent) {
		this.ageStudent = ageStudent;
	}
	
	public String getMailStudent() {
		return mailStudent;
	}
	public void setMailStudent(String mailStudent) {
		this.mailStudent = mailStudent;
	}
	
	public String getFiliere() {
		return Filiere;
	}
	public void setFiliere(String Filiere) {
		this.Filiere = Filiere;
	}
	
	public int getGrp() {
		return idgrp;
	}

	
	public void setInt(int grp) {
		this.idgrp = grp;
	}

	
	
	public void creerStudent() {	
		
		Connection con=Dbconnection.Connect();
		PreparedStatement ps=null;
		
	try {
		
		String sql="INSERT INTO eleve(nom,prenom,age,mail,filiere,idgroupe) VALUES(?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1,this.nomStudent);
		ps.setString(2,this.prenomStudent);
		ps.setInt(3,this.ageStudent);
		ps.setString(4,this.mailStudent);
		ps.setString(5,this.Filiere);
		ps.setInt(6,this.idgrp);
		ps.execute();
		
		System.out.println("insertion ok!");
		
	} catch ( SQLException e) {
		System.out.println(e.toString());	
	}
						
	}
	

	
	/**
	 * focntion
	 * @param indice
	 */
	public void suprimerStudent(int indice) {
		
		
		
	}
	
	
	
	
	
   /*public void modifierStudent() {
	
	}
	public void consulterStudent() {
		
	}*/
	

	
}