package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseIOGUI{
	public static void main(String[] args){
		// Campi finali per essere accessibili dalla classe anonima
		final JTextField tf = new JTextField(10);
		final JLabel lb = new JLabel("Result: 0");
		
		JButton bt = new JButton("Multiply by 2");
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lb.setText("Result :"+Integer.parseInt(tf.getText())*2);
			}
		});
		
		FlowLayout lay = new FlowLayout(FlowLayout.CENTER,10,10); 
		MyFrame frame = new MyFrame("I/O Example",lay);
		frame.getMainPanel().add(tf);
		frame.getMainPanel().add(lb);
		frame.getMainPanel().add(bt);
		frame.setVisible(true);
	}
}
