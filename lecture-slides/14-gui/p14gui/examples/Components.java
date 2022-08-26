package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Components {
	public static void main(String[] args){
		// Creo il frame e imposto titolo e altre proprietà
		JFrame frame = new JFrame();	   
		frame.setTitle("Vari JComponent"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,100);
		
		// Creo un pannello senza bordino e lo aggiungo al frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		String[] str = new String[]{"str1","str2","str3","str4"};
		// Aggiungo vari componenti
		panel.add(new JButton("JButton"));
		panel.add(new JLabel("JLabel"));
		panel.add(new JTextField("JTextField",15));
		panel.add(new JList<String>(str));
		panel.add(new JComboBox<String>(str));
		panel.add(new JTextArea(5,10));
		
		// Alla fine rendo visible il JFrame
		frame.setVisible(true);
	}
}
