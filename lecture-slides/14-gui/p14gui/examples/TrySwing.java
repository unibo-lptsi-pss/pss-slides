package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TrySwing {
	public static void main(String[] args){
		// Creo il frame e imposto titolo e altre proprietà
		JFrame frame = new JFrame();	   
		frame.setTitle("Prova di JFrame"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320,240);
		
		// Creo un pannello e gli imposto il bordino
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Prova di Panel"));
		
		// Aggiungo il pannello al frame 
		frame.getContentPane().add(panel);

		// Aggiungo un pulsante al pannello
		panel.add(new JButton("Prova di pulsante"));
		
		// Alla fine rendo visible il JFrame
		frame.setVisible(true);
	}
}
