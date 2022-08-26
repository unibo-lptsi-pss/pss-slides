package it.unibo.apice.oop.p14gui.examples;

import javax.swing.*;

public class TrySwing {
	public static void main(String[] args){
		// Creo il frame e imposto titolo e altre proprietà
		final JFrame frame = new JFrame();	   
		frame.setTitle("Prova di JFrame"); 
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(320,240);
		
		// Creo un pannello e gli imposto il bordino
		final JPanel panel = new JPanel();
		// Aggiungo il pannello ai 'contenuti' del frame 
		frame.getContentPane().add(panel);

		// Aggiungo un pulsante al pannello
		panel.add(new JButton("Prova di pulsante"));
		
		// Alla fine rendo visible il JFrame
		frame.setVisible(true);
	}
}
