package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseNoLayout {
	public static void main(String[] args){
		final JFrame frame = new JFrame();	   
		frame.setTitle("AbsoluteLayout Example"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // o true..
		frame.setSize(320,200);
		
		final JPanel panel = new JPanel();
		panel.setLayout(null); // Nessun layout
		frame.getContentPane().add(panel);

		final JButton b1 = new JButton("Button 1");
		final JButton b2 = new JButton("Button 2");
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
