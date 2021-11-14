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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VueUe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controleur control;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextField textField;
	private JTable tableues;

	
	
	
	
	
	
	
	public JTextArea getTextArea() {
		return textArea;
	}


	public JTextField getTextField() {
		return textField;
	}


	public void inserereue() {
		
		this.control.DmdinsertionUe(textField.getText(),Integer.parseInt(comboBox.getSelectedItem().toString()), textArea.getText());
		System.out.println("L'ue a été insérer");		
		
	}
	
	
	public void reinitialiserue() {
		this.control.Dmdrefreshue(this);;
		System.out.println("Mis à jour effectué");
	}
	

	public void affichageUe() {

		this.control.DmdUe(tableues);;
		
	}
	
	/**
	 * Create the dialog.
	 */
	public VueUe(Controleur control) {
		this.control=control;
		
		setType(Type.POPUP);
		setResizable(false);
		setModal(true);
		setTitle("Unité d'esignement");
		setForeground(Color.WHITE);
		setBounds(100, 100, 739, 735);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nom UE :");
			lblNewLabel.setBounds(68, 154, 61, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCoefUe = new JLabel("Coef UE :");
			lblCoefUe.setBounds(68, 195, 61, 16);
			contentPanel.add(lblCoefUe);
		}
		{
			JLabel lblDescription = new JLabel("Description: ");
			lblDescription.setBounds(68, 248, 89, 16);
			contentPanel.add(lblDescription);
		}
		
		textField = new JTextField();
		textField.setBounds(172, 148, 433, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(172, 191, 78, 31);
		contentPanel.add(comboBox);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("3");
		
		textArea = new JTextArea();
		textArea.setBounds(182, 248, 426, 58);
		contentPanel.add(textArea);
		
		JButton btnNewButton = new JButton("Creer UE ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 inserereue();
			 affichageUe();
			
			}
		});
		btnNewButton.setBounds(172, 330, 129, 29);
		contentPanel.add(btnNewButton);
		
		JButton btnRenitialiser = new JButton("Renitialiser ");
		btnRenitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reinitialiserue();
			}
		});
		btnRenitialiser.setBounds(311, 330, 138, 29);
		contentPanel.add(btnRenitialiser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 398, 487, 226);
		contentPanel.add(scrollPane);
		
		tableues = new JTable();
		scrollPane.setColumnHeaderView(tableues);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(563, 418, 139, 29);
		contentPanel.add(btnModifier);
		
		JButton btnNewButton_1_1 = new JButton("Suprimer");
		btnNewButton_1_1.setBounds(573, 479, 129, 29);
		contentPanel.add(btnNewButton_1_1);
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
