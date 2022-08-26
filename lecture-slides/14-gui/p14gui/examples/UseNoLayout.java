package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseNoLayout {
	public static void main(String[] args){
		JFrame frame = new JFrame();	   
		frame.setTitle("AbsoluteLayout Example"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320,200);
		
		JPanel panel = new JPanel();
		panel.setLayout(null); // Nessun layout
		frame.getContentPane().add(panel);

		// Creo e aggiungi i Button
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		panel.add(b1);
		panel.add(b2);
		
		// Imposto dimensione e posizione
		Dimension size = b1.getPreferredSize();
		b1.setBounds(25, 5, size.width, size.height);
		size = b2.getPreferredSize();
		b2.setBounds(55, 40, size.width*3, size.height*3);
		
		frame.setVisible(true);
	}
}
