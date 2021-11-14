package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controleur;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VueGroupe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldnomgrp;
	private JTable tablegroupe1;

	private Controleur control;
	private JComboBox comboBoxlisteues;
    private JComboBox comboBox_1listesujet;
    
    
    
    
	public Controleur getControl() {
		return control;
	}


	public JTable getTablegroupe1() {
		return tablegroupe1;
	}


	public JTextField getTextFieldnomgrp() {
		return textFieldnomgrp;
	}

	
	/**
	 * Create the dialog.
	 */
	public void inseregroupe() { 
		this.control.Dmdinserergroupe(textFieldnomgrp.getText(), Integer.parseInt(comboBoxlisteues.getSelectedItem().toString()), Integer.parseInt(comboBox_1listesujet.getSelectedItem().toString()));
	}
	
	public void affichageTableauGroupe1() {

		this.control.DmdaffichageGroupe(this.tablegroupe1);
		
	}
	
	
	
	
	/*public void reinitialisergroupe() {
		this.control.Dmdrefreshgroupe(null);;
		System.out.println("Mis à jour effectué");
	}*/
	
	/*
	 * 
	 * public void BindData()  
        {  
            cmd = new SqlCommand("select name from Table1", cn);  
            dr = cmd.ExecuteReader();  
            while(dr.Read())  
            {  
                comboBox1.Items.Add(dr[0].ToString());  
            }  
            dr.Close();  
        }  
	 * 
	 */
	
	public VueGroupe(Controleur control) {
		setResizable(false);
		setModal(true);
		this.control=control;
		setBackground(Color.WHITE);
		setTitle("Groupe");
		setForeground(Color.WHITE);
		setBounds(100, 100, 829, 718);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblNewLabel = new JLabel("Nom du groupe:");
			lblNewLabel.setBounds(347, 99, 121, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldnomgrp = new JTextField();
			textFieldnomgrp.setBounds(480, 91, 271, 38);
			contentPanel.add(textFieldnomgrp);
			textFieldnomgrp.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("Ajouter le groupe");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inseregroupe();
					affichageTableauGroupe1();
				}
			});
			btnNewButton.setBounds(480, 298, 271, 57);
			contentPanel.add(btnNewButton);
		}
		
		comboBoxlisteues = new JComboBox();
	    comboBoxlisteues.addItem(1);
	    comboBoxlisteues.addItem(2);
	    comboBoxlisteues.addItem(3);
		comboBoxlisteues.setBounds(480, 156, 271, 57);
		contentPanel.add(comboBoxlisteues);
		
		JLabel lblListeDesUes = new JLabel("Liste des UES :");
		lblListeDesUes.setBounds(347, 172, 121, 23);
		contentPanel.add(lblListeDesUes);
		
		comboBox_1listesujet = new JComboBox();
		comboBox_1listesujet.addItem(1);
		comboBox_1listesujet.addItem(2);
		comboBox_1listesujet.addItem(3);
		comboBox_1listesujet.setBounds(480, 238, 271, 48);
		contentPanel.add(comboBox_1listesujet);
		
		JLabel lblListeDesSujets = new JLabel("Liste des sujets");
		lblListeDesSujets.setBounds(347, 250, 121, 23);
		contentPanel.add(lblListeDesSujets);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 276, 623);
		contentPanel.add(scrollPane);
		
		tablegroupe1 = new JTable();
		scrollPane.setViewportView(tablegroupe1);
		
		JButton btnEtudiants = new JButton("+ etudiants");
		btnEtudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			   // control.DmdDeSelectionDeGroupe(tablegroupe1);
			    //System.out.println(test);
			    ModifierGroupe mg=new ModifierGroupe(control,control.DmdDeSelectionDeGroupe(tablegroupe1));
			    control.DmdValeurjtxfield(mg);
			    control.DmdchargereleveDansJtable(mg.getTable());
				
				mg.setVisible(true); 
			}
		});
		btnEtudiants.setBounds(446, 417, 121, 57);
		contentPanel.add(btnEtudiants);
		
		JButton btnSuprimer = new JButton("Suprimer");
		btnSuprimer.setBounds(630, 417, 121, 57);
		contentPanel.add(btnSuprimer);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option ");
		menuBar.add(mnNewMenu);
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setBackground(Color.WHITE);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Paramettres groupes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
	}
}
