package it.unibo.apice.oop.p16lambda.first;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class UseButtonEvents{
	
	public static void main(String[] args){
		final JButton b1 = new JButton("Say Hello");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello!! "+e);
			}
		}); // Uso una inner class anonima..
		
		final JButton b2 = new JButton("Quit");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quitting.."+e); 
				System.exit(0);
			}
		}); // Uso una inner class anonima..
		
		final JFrame frame = new JFrame("Events Example");
		frame.setSize(320, 200);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.setVisible(true);
	}
}
