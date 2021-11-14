package controleur;

import Model.Ue;
import vue.VuePrincipale;
import vue.VueSujet;
import vue.VueUe;
import vue.ModifierGroupe;
import vue.VueEtudiant;
import vue.VueGroupe;
import Model.Sujet;
import Model.Student;

import javax.swing.JTable;

import Model.Groupe;
import Model.Modifiergroupe;

public class Controleur {
	
	private VuePrincipale vuep;
	private Ue ue;
	private Sujet sujet;
	private Student eleve;
	private Groupe groupe;
	private VueGroupe vg;
	private Modifiergroupe mg;

	public static void main(String[] args) {
		
		new Controleur();
		
	}
	
	
	
	public Controleur() {
		
		vuep =new VuePrincipale(this);
		vuep.setVisible(true);
	}
	
	

	public void DmdinsertionUe(Object nomUE,Object coefUe,Object desc) {
		ue=new Ue((String)nomUE, (int)coefUe, (String)desc);
		ue.creer_UE();
	}
	
	public void Dmdrefreshue(VueUe vuue){
		vuue.getTextArea().setText("");
		vuue.getTextField().setText("");
	}
	
	public void Dmdinsertionsujet(Object nomSUJET, Object desc, Object ue) {
	
		sujet = new Sujet((String)nomSUJET, (String)desc, (int)ue );
		sujet.creerSujet();
		System.out.println("Sujet inséré");
	}
 
	/**
	 * Cette fonction permet d'inserer un etudiant dans la base de données
	 * @param nomELEVE
	 * @param prenomELEVE
	 * @param age
	 * @param mail
	 * @param filiere
	 * @param idgrp
	 */
	public void Dmdinsereretudiant(Object nomELEVE, Object prenomELEVE, Object age, Object mail, Object filiere, Object idgrp) {
		
		eleve = new Student((String)nomELEVE, (String) prenomELEVE, (int)age, (String)mail, (String)filiere, (int)idgrp );
		eleve.creerStudent();
		System.out.println("Elève inséré");
	}
	
	/**
	 * Cette fonction permet de renitialiser le formulaire etudiant
	 * @param etudiant
	 */
	public void Dmdrefresheleve(VueEtudiant etudiant){
		etudiant.getTextFieldname().setText("");
		etudiant.getTextFieldprenom().setText("");
		etudiant.getTextFieldmail().setText("");
	}
	
	/**
	 * cette fonction permet d'inserer un groupe en base de données
	 * @param nomGroupe
	 * @param idUE
	 * @param idSUJET
	 */
	
	public void Dmdinserergroupe(Object nomGroupe, Object idUE, Object idSUJET) 
	{
		groupe = new Groupe((String)nomGroupe,(int)idUE, (int)idSUJET);
		groupe.creer_Groupe();
		System.out.println("Groupe créé");
		
	}
	
	public void Dmdrefreshgroupe(VueGroupe groupe) {
		groupe.getTextFieldnomgrp().setText("");
	}
	
	
	
	/**
	 * Cette fonction est une demmande de la vue pour afficher les groupe dans le tableau groupe
	 * @param tab
	 */
	public void DmdaffichageGroupe(JTable tab) {
		groupe=new Groupe();
		groupe.RecupererGroupe(tab);
		
	}
	
	
	/**
	 * Cette fonction permet de recupperer un groupe  via un clic
	 * @param vg
	 * @return
	 */
	
	public String DmdDeSelectionDeGroupe(JTable tab) {
		
		String ligne;
		ligne=(String) tab.getModel().getValueAt(tab.getSelectedRow(),0);
		
		return ligne;	
	}
	
	/**
	 * Cette fonction permet de remplire les jtexfield automatiquement
	 * @param vu
	 */
	public void DmdValeurjtxfield(ModifierGroupe vu) {
		mg= new Modifiergroupe();
		
		mg.RemplireChamps(vu);	
	}
	
	/**
	 * Cette fonction va permettre de charger automatiquement les eleves dans le jtbale de la vue ModiferGroupe
	 * @param tab
	 */
	public void DmdchargereleveDansJtable(JTable tab) {
		mg=new Modifiergroupe();
		mg.RecupererEtudiants(tab);  
			
	}
	
	
	/**
	 * Cette fonction permet de demander à la vue etudiant l'affichage des etudiant dans le tableau eleve
	 * @param tab
	 */
public void Dmdaffichageeleve(JTable tab) {
		
		this.eleve.RecupererStudent(tab);
		
	}

public void DmdaffichageSujet(JTable tab) {
	this.sujet.RecupererSujet(tab);
}
	
public void DmdUe(JTable tab) {
	this.ue.RecupererUe(tab);
}
	
}
