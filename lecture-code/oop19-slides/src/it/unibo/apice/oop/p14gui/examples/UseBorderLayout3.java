package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseBorderLayout3{
	public static void main(String[] args){
		final BorderLayout b = new BorderLayout();
		b.setHgap(10); // Parametri addizionali del lay-man
		b.setVgap(10);
		final MyFrame frame = new MyFrame("BorderLayout Example Bis",b);	   
		
		final JButton button = new JButton("North");
		final Dimension d = button.getPreferredSize(); // imposto le dim..
		button.setPreferredSize(new Dimension(d.width,d.height*2));
		frame.getMainPanel().add(button,BorderLayout.NORTH);
		frame.getMainPanel().add(new JButton("South"),BorderLayout.SOUTH);
		frame.getMainPanel().add(new JButton("Center"),BorderLayout.CENTER);
		frame.getMainPanel().add(new JButton("East"),BorderLayout.EAST);
		// nota l'effetto di una stringa più lunga qui
		frame.getMainPanel().add(new JButton("WestWest"),BorderLayout.WEST);
		
		frame.setVisible(true);
	}
}
