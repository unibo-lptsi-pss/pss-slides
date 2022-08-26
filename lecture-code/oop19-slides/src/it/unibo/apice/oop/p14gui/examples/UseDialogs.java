package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseDialogs{
	public static void main(String[] args){
		final FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
		final MyFrame frame = new MyFrame("Dialogs Example",fl);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(frame,
					    "Do you really want to quit?",
					    "Quitting..", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		final JTextField tf = new JTextField(10);
		final JLabel lb = new JLabel("Result: 0");
		final JButton bt = new JButton("Multiply by 2");
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					lb.setText("Result :"+Integer.parseInt(tf.getText())*2);
				} catch (Exception ex){
					JOptionPane.showMessageDialog(frame, "An integer please..");
				}
			}
		});		
		frame.getMainPanel().add(tf);
		frame.getMainPanel().add(lb);
		frame.getMainPanel().add(bt);
		frame.setVisible(true);
	}
}
