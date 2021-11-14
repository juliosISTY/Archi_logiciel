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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VueEtudiant extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldname;
	private JTextField textFieldprenom;
	private JTextField textFieldmail;
	private JComboBox comboBoxFiliere;
	private JComboBox comboBoxAge;
	private Controleur control;
    private JComboBox comboBoxGroupe;
    private JTable tableau_etudiant;
   
    

	public JTextField getTextFieldname() {
		return textFieldname;
	}


	public JTextField getTextFieldprenom() {
		return textFieldprenom;
	}


	public JTextField getTextFieldmail() {
		return textFieldmail;
	}


	public void insererstudent() {
		
		this.control.Dmdinsereretudiant(textFieldname.getText(),textFieldprenom.getText(),Integer.parseInt(comboBoxAge.getSelectedItem().toString()),textFieldmail.getText(),comboBoxFiliere.getSelectedItem(),0 );
		System.out.println("L'élève a été insérer");		
		
	}
	
	
	public void reinitialisereleve() {
		this.control.Dmdrefresheleve(this);;
		System.out.println("Mis à jour effectué");
	}
	
	
	public void affiche_tableau_etudiant() {
		this.control.Dmdaffichageeleve(this.tableau_etudiant);
	}
	
	/**
	 * Create the dialog.
	 */
	public VueEtudiant(Controleur control) {
		this.control=control;
		
		setType(Type.POPUP);
		setModal(true);
		setResizable(false);
		setTitle("Etudiant");
		setForeground(Color.WHITE);
		setBounds(100, 100, 739, 792);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nom etudiant :");
			lblNewLabel.setBounds(82, 139, 116, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPenomtudiant = new JLabel("Prénom étudiant:");
			lblPenomtudiant.setBounds(82, 173, 116, 16);
			contentPanel.add(lblPenomtudiant);
		}
		{
			JLabel lblAgetudiant = new JLabel("Age étudiant:");
			lblAgetudiant.setBounds(82, 212, 116, 16);
			contentPanel.add(lblAgetudiant);
		}
		{
			JLabel lblMailtudiant = new JLabel("Mail étudiant:");
			lblMailtudiant.setBounds(82, 311, 116, 16);
			contentPanel.add(lblMailtudiant);
		}
		{
			textFieldname = new JTextField();
			textFieldname.setBounds(210, 134, 372, 26);
			contentPanel.add(textFieldname);
			textFieldname.setColumns(10);
		}
		{
			textFieldprenom = new JTextField();
			textFieldprenom.setColumns(10);
			textFieldprenom.setBounds(210, 168, 372, 26);
			contentPanel.add(textFieldprenom);
		}
		{
			comboBoxAge = new JComboBox();
			
			comboBoxAge.addItem(23);
			comboBoxAge.addItem(24);
			comboBoxAge.addItem(16);
			comboBoxAge.addItem(26);
			comboBoxAge.addItem(18);
			
			comboBoxAge.setBounds(207, 208, 95, 26);
			contentPanel.add(comboBoxAge);
		}
		{
			textFieldmail = new JTextField();
			textFieldmail.setColumns(10);
			textFieldmail.setBounds(210, 306, 372, 26);
			contentPanel.add(textFieldmail);
		}
		{
			JButton btnNewButton = new JButton("Créer étudiant");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					insererstudent();
					affiche_tableau_etudiant();
				}
			});
			btnNewButton.setBounds(210, 404, 133, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnRnitialiser = new JButton("Rénitialiser");
			btnRnitialiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reinitialisereleve();
				}
			});
			btnRnitialiser.setBounds(355, 404, 133, 29);
			contentPanel.add(btnRnitialiser);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(165, 445, 372, 254);
			contentPanel.add(scrollPane);
			
			tableau_etudiant = new JTable();
			scrollPane.setColumnHeaderView(tableau_etudiant);
		}
		{
			JButton btnModifier = new JButton("Modifier");
			btnModifier.setBounds(560, 443, 133, 29);
			contentPanel.add(btnModifier);
		}
		{
			JButton btnSuprimer = new JButton("Suprimer");
			btnSuprimer.setBounds(560, 499, 133, 29);
			contentPanel.add(btnSuprimer);
		}
		
		JLabel lblFiliere = new JLabel("Filiere: ");
		lblFiliere.setBounds(82, 263, 116, 16);
		contentPanel.add(lblFiliere);
		{
			comboBoxFiliere = new JComboBox();
			
			comboBoxFiliere.addItem("Informatique");
			comboBoxFiliere.addItem("Mécatronique");
			comboBoxFiliere.addItem("Système Embarqué");
			
			
			comboBoxFiliere.setBounds(207, 259, 375, 26);
			contentPanel.add(comboBoxFiliere);
		}
		
		{
			JLabel lblGroupe = new JLabel("Groupe:");
			lblGroupe.setBounds(82, 372, 116, 16);
			contentPanel.add(lblGroupe);
		}
		{
			comboBoxGroupe = new JComboBox();
			comboBoxGroupe.setBounds(207, 366, 375, 26);
			contentPanel.add(comboBoxGroupe);
		}
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
	}
}
