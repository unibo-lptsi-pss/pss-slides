package it.unibo.apice.oop.p15gui.mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

@SuppressWarnings("serial")
public class Form extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JButton okButton = new JButton("OK");
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_Code;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnMaschile = new JRadioButton("Maschile");
	private final JRadioButton rdbtnFemminile = new JRadioButton("Femminile");
	
	
	private final JSpinner spinner;
	private boolean okState = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form dialog = new Form(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form(View view) {
		super(view);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JPanel data = new JPanel();
			contentPanel.add(data);
			GridBagLayout gbl_data = new GridBagLayout();
			gbl_data.columnWidths = new int[] {0, 0, 10};
			gbl_data.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 10};
			gbl_data.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_data.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			data.setLayout(gbl_data);
			{
				JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
				GridBagConstraints gbc_lblCodiceFiscale = new GridBagConstraints();
				gbc_lblCodiceFiscale.anchor = GridBagConstraints.EAST;
				gbc_lblCodiceFiscale.insets = new Insets(0, 0, 5, 5);
				gbc_lblCodiceFiscale.gridx = 0;
				gbc_lblCodiceFiscale.gridy = 0;
				data.add(lblCodiceFiscale, gbc_lblCodiceFiscale);
			}
			{
				textField_Code = new JTextField();
				GridBagConstraints gbc_textField_CF = new GridBagConstraints();
				gbc_textField_CF.insets = new Insets(0, 0, 5, 0);
				gbc_textField_CF.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_CF.gridx = 1;
				gbc_textField_CF.gridy = 0;
				data.add(textField_Code, gbc_textField_CF);
				textField_Code.setColumns(10);
			}
			{
				JLabel lblNome = new JLabel("Nome");
				GridBagConstraints gbc_lblNome = new GridBagConstraints();
				gbc_lblNome.insets = new Insets(0, 0, 5, 5);
				gbc_lblNome.anchor = GridBagConstraints.EAST;
				gbc_lblNome.gridx = 0;
				gbc_lblNome.gridy = 1;
				data.add(lblNome, gbc_lblNome);
			}
			{
				textField_Nome = new JTextField();
				GridBagConstraints gbc_textField_Nome = new GridBagConstraints();
				gbc_textField_Nome.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Nome.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Nome.gridx = 1;
				gbc_textField_Nome.gridy = 1;
				data.add(textField_Nome, gbc_textField_Nome);
				textField_Nome.setColumns(15);
			}
			{
				JLabel lblCognome = new JLabel("Cognome");
				GridBagConstraints gbc_lblCognome = new GridBagConstraints();
				gbc_lblCognome.anchor = GridBagConstraints.EAST;
				gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
				gbc_lblCognome.gridx = 0;
				gbc_lblCognome.gridy = 2;
				data.add(lblCognome, gbc_lblCognome);
			}
			{
				textField_Cognome = new JTextField();
				GridBagConstraints gbc_textField_Cognome = new GridBagConstraints();
				gbc_textField_Cognome.insets = new Insets(0, 0, 5, 0);
				gbc_textField_Cognome.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_Cognome.gridx = 1;
				gbc_textField_Cognome.gridy = 2;
				data.add(textField_Cognome, gbc_textField_Cognome);
				textField_Cognome.setColumns(10);
			}
			{
				JLabel lblAnnoDiNsacita = new JLabel("Anno di nascita");
				GridBagConstraints gbc_lblAnnoDiNsacita = new GridBagConstraints();
				gbc_lblAnnoDiNsacita.anchor = GridBagConstraints.EAST;
				gbc_lblAnnoDiNsacita.insets = new Insets(0, 0, 5, 5);
				gbc_lblAnnoDiNsacita.gridx = 0;
				gbc_lblAnnoDiNsacita.gridy = 3;
				data.add(lblAnnoDiNsacita, gbc_lblAnnoDiNsacita);
			}
			{
				spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(2000, 1900, 2014, 1));
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.anchor = GridBagConstraints.WEST;
				gbc_spinner.insets = new Insets(0, 0, 5, 0);
				gbc_spinner.gridx = 1;
				gbc_spinner.gridy = 3;
				data.add(spinner, gbc_spinner);
			}
			{
				JLabel lblSesso = new JLabel("Sesso");
				GridBagConstraints gbc_lblSesso = new GridBagConstraints();
				gbc_lblSesso.anchor = GridBagConstraints.EAST;
				gbc_lblSesso.insets = new Insets(0, 0, 5, 5);
				gbc_lblSesso.gridx = 0;
				gbc_lblSesso.gridy = 4;
				data.add(lblSesso, gbc_lblSesso);
			}
			{
				buttonGroup.add(rdbtnMaschile);
				GridBagConstraints gbc_rdbtMaschile = new GridBagConstraints();
				gbc_rdbtMaschile.anchor = GridBagConstraints.WEST;
				gbc_rdbtMaschile.insets = new Insets(0, 0, 5, 0);
				gbc_rdbtMaschile.gridx = 1;
				gbc_rdbtMaschile.gridy = 4;
				data.add(rdbtnMaschile, gbc_rdbtMaschile);
			}
			{
				buttonGroup.add(rdbtnFemminile);
				GridBagConstraints gbc_rdbtnFemminile = new GridBagConstraints();
				gbc_rdbtnFemminile.insets = new Insets(0, 0, 5, 0);
				gbc_rdbtnFemminile.anchor = GridBagConstraints.WEST;
				gbc_rdbtnFemminile.gridx = 1;
				gbc_rdbtnFemminile.gridy = 5;
				data.add(rdbtnFemminile, gbc_rdbtnFemminile);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JSeparator separator = new JSeparator();
				buttonPane.add(separator);
			}
			{
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okState = true;  
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okState = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	// Lo stato è true se abbiamo premuto OK invece che Cancel
	public boolean getOKState(){
		return this.okState; 
	}
	
	public void reinit(){
		this.textField_Nome.setText("");
		this.textField_Cognome.setText("");
		this.textField_Code.setText("");
		this.rdbtnMaschile.setSelected(true);
		this.rdbtnMaschile.setSelected(false);
		this.spinner.setValue(2000);
	}
		
	public String getName(){
		return this.textField_Nome.getText();
	}
	
	public String getSurname(){
		return this.textField_Cognome.getText();
	}
	
	public String getCode(){
		return this.textField_Code.getText();
	}
	
	public int getBirthYear(){
		return (Integer)this.spinner.getValue();
	}
	
	public boolean getMale(){
		return this.rdbtnMaschile.isSelected();
	}
}
