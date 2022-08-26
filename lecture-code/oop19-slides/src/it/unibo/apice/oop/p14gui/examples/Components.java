package it.unibo.apice.oop.p14gui.examples;

import javax.swing.*;

public class Components {
	public static void main(String[] args){
		// Creo il frame e imposto titolo e altre proprietà
		final JFrame frame = new JFrame();	   
		frame.setTitle("Vari JComponent"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,100);
		
		// Creo un pannello senza bordino e lo aggiungo al frame
		final JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		final String[] strings = new String[]{"str1","str2","str3","str4"};
		// Aggiungo vari componenti
		panel.add(new JButton("JButton"));
		panel.add(new JLabel("JLabel"));
		panel.add(new JTextField("JTextField",15));
		panel.add(new JList<String>(strings));
		panel.add(new JComboBox<String>(strings));
		panel.add(new JTextArea(5,10));
		
		// Alla fine rendo visible il JFrame
		frame.setVisible(true);
	}
}
