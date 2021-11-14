package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controleur;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class VuePrincipale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private  Controleur control;

	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public VuePrincipale(Controleur control) {
		setBackground(Color.WHITE);
		this.control=control;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 893, 735);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("Files");
		mnNewMenu_3.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu = new JMenu("Configuration");
		mnNewMenu_3.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestion des ues");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VueUe ue=new VueUe(control);
				//ue.main(null);
				 ue.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestion des sujets");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VueSujet sujet =new VueSujet(control);
				
				sujet.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestion des etudiants");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VueEtudiant etudiant=new VueEtudiant(control);
				etudiant.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Gestion des groupes");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VueGroupe groupe=new VueGroupe(control);
			    groupe.affichageTableauGroupe1();
			    groupe.setVisible(true); 
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Fermer");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Compte");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Gestion de nouveaux compte");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Aide ");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("A propos de l'app");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Groupe");
		lblNewLabel.setBounds(56, 29, 103, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblUe = new JLabel("UE");
		lblUe.setBounds(244, 29, 76, 85);
		contentPane.add(lblUe);
		
		JLabel lblEtudiant = new JLabel("Sujet");
		lblEtudiant.setBounds(424, 29, 90, 85);
		contentPane.add(lblEtudiant);
		
		JLabel lblEtudiant_2 = new JLabel("Etudiant");
		lblEtudiant_2.setBounds(619, 29, 103, 85);
		contentPane.add(lblEtudiant_2);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setBounds(154, 63, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("0");
		lblNewLabel_1_1.setBounds(332, 63, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1.setBounds(528, 63, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("0");
		lblNewLabel_1_1_1_1.setBounds(741, 63, 61, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 126, 881, 553);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
