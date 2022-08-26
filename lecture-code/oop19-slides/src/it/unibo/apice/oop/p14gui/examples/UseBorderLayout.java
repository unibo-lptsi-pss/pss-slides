package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseBorderLayout {
	public static void main(String[] args){
		final JFrame frame = new JFrame();	   
		frame.setTitle("BorderLayout Example"); 
		frame.setSize(320,200);
		
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout()); // Imposto il layout
		frame.getContentPane().add(panel);

		// Nota l'argomento aggiuntivo di tipo int
		// Nota che i pulsanti non usano la loro dim. preferita!
		panel.add(new JButton("North"),BorderLayout.NORTH);
		panel.add(new JButton("South"),BorderLayout.SOUTH);
		panel.add(new JButton("Center"),BorderLayout.CENTER);
		panel.add(new JButton("East"),BorderLayout.EAST);
		panel.add(new JButton("West"),BorderLayout.WEST);
		
		frame.setVisible(true);
	}
}
