package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controleur;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class ModifierGroupe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private String nomGoupe;
	private Controleur control;
	private JTable table_1;

	
	/*public static void main(String[] args) {
		try {
			ModifierGroupe dialog = new ModifierGroupe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	  
	public JTextField getTextField() {
		return textField;
	}


	public JTextField getTextField_1() {
		return textField_1;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public String getNomGoupe() {
		return nomGoupe;
	}
	
	
	
	
	

     
	public JTable getTable() {
		return table;
	}


	/**
	 * Create the dialog.
	 */
	public ModifierGroupe(Controleur control,String nomGroupe) {
		this.control=control;
		this.nomGoupe=nomGroupe;
		System.out.println("Depuis la classe modif :"+this.nomGoupe);
		
		setAlwaysOnTop(true);
		setResizable(false);
		setModal(true);
		setForeground(Color.WHITE);
		setBounds(100, 100, 964, 691);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(656, 6, 299, 45);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(383, 95, 244, 45);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(383, 164, 244, 45);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nom groupe");
		lblNewLabel.setBounds(335, 48, 84, 31);
		contentPanel.add(lblNewLabel);
		
		JLabel lblUe = new JLabel("UE");
		lblUe.setBounds(335, 102, 84, 31);
		contentPanel.add(lblUe);
		
		JLabel lblSujet = new JLabel("Sujet");
		lblSujet.setBounds(335, 171, 84, 31);
		contentPanel.add(lblSujet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 305, 555);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ajouter au groupe");
		btnNewButton.setBounds(6, 573, 305, 45);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1_2 = new JButton("Mise a jour");
		btnNewButton_1_2.setBounds(383, 240, 244, 45);
		contentPanel.add(btnNewButton_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(656, 54, 299, 507);
		contentPanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
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
