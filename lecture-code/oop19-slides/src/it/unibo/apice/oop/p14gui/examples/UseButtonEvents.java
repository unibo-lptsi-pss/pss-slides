package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UseButtonEvents{
	public static void main(String[] args){
		final MyFrame frame = new MyFrame("Events Example",new FlowLayout());
		
		final ActionListener listener = new MyActionListener();
		
		final JButton b1 = new JButton("Say Hello");
		b1.setActionCommand("hello");  // nome comando
		b1.addActionListener(listener);// registro il listener
		
		final JButton b2 = new JButton("Quit");
		b2.setActionCommand("quit");
		b2.addActionListener(listener);
		
		final JButton b3 = new JButton("Looping..");
		b3.setActionCommand("loop");
		b3.addActionListener(listener);
		
		frame.getMainPanel().add(b1);
		frame.getMainPanel().add(b2);
		frame.getMainPanel().add(b3);
		frame.setVisible(true);
	}
}
