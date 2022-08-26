package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UseDynamicLayout{
	public static void main(String[] args){
		
		final FlowLayout lay = new FlowLayout(FlowLayout.CENTER,10,10); 
		final MyFrame frame = new MyFrame("Adding Buttons",lay);
		final JPanel panel = frame.getMainPanel();
		
		final JButton bt = new JButton("Add a Button");
		bt.addActionListener(new ActionListener(){
			int count = 0;
			public void actionPerformed(ActionEvent e) {
				panel.add(new JButton("Button"+count++));
				panel.validate(); // forza il ricalcolo del layout!
			}
		});
		panel.add(bt);
		frame.setVisible(true);
	}
}
