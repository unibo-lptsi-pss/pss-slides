package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class UseCanvas{
	
	public static void main(String[] args){
		final DrawPanel pCenter = new DrawPanel();
		pCenter.setBorder(new TitledBorder("Circles here.."));
		// Intercetto i click del mouse!
		// L'Adapter già implementa banalmente i metodi, quindi basta fare un override
		pCenter.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				pCenter.addPoint(e.getX(), e.getY());
				pCenter.repaint();
			}
		});
		// Intercetto il click sul pulsante
		JPanel pEast = new JPanel(new FlowLayout());
		JButton bt = new JButton("Draw");
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				pCenter.addRandomPoint();
				pCenter.repaint();
			}
		});
		pEast.add(bt);
		
		MyFrame frame = new MyFrame("Canvas Example",new BorderLayout());
		frame.getMainPanel().add(pCenter,BorderLayout.CENTER);
		frame.getMainPanel().add(pEast,BorderLayout.EAST);
		frame.setResizable(false); // non estendibile!!
		frame.setVisible(true);
	}
}
