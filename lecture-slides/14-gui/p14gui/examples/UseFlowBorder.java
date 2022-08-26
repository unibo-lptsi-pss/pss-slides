package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseFlowBorder{
	public static void main(String[] args){
		MyFrame frame = 
				new MyFrame("Flow and Border",new BorderLayout());
		
		// Creo un sotto-pannello per la parte NORTH
		JPanel pNorth = new JPanel(new FlowLayout());
		pNorth.add(new JButton("North 1"));
		pNorth.add(new JButton("North 2"));
		
		// Creo un sotto-pannello per la parte SOUTH
		JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pSouth.add(new JButton("OK"));
		pSouth.add(new JButton("Quit"));
		
		// Grazie al polimorfismo, aggiungo pannelli
		frame.getMainPanel().add(pNorth,BorderLayout.NORTH);
		frame.getMainPanel().add(pSouth,BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
}
