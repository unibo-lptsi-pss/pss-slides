package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseButtonEvents2{
	public static void main(String[] args){
		JButton b1 = new JButton("Say Hello");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello!!");
			}
		}); // Uso una inner class anonima..
		
		JButton b2 = new JButton("Quit");
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quitting.."); 
				System.exit(0);
			}
		}); // Uso una inner class anonima..
		
		MyFrame frame = new MyFrame("Events Example",new FlowLayout());
		frame.getMainPanel().add(b1);
		frame.getMainPanel().add(b2);
		frame.setVisible(true);
	}
}
