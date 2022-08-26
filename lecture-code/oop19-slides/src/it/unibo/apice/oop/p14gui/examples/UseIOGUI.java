package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UseIOGUI{
	public static void main(String[] args){
		final JTextField tf = new JTextField(10);
		final JLabel lb = new JLabel("Result: 0");
		final JButton bt = new JButton("Multiply by 2");
		
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String s = tf.getText(); // "21"
				int n = Integer.parseInt(s); // 21
				lb.setText("Result :"+n*2);
			}
		});
		
		final FlowLayout lay = new FlowLayout(FlowLayout.CENTER,10,10); 
		final MyFrame frame = new MyFrame("I/O Example",lay);
		frame.getMainPanel().add(tf);
		frame.getMainPanel().add(lb);
		frame.getMainPanel().add(bt);
		frame.setVisible(true);
	}
}
