package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;

public class UseBorderLayout2{
	public static void main(String[] args){
		final MyFrame frame = 
				new MyFrame("BorderLayout Example",new BorderLayout());	   
		
		frame.getMainPanel().add(new JButton("North"),BorderLayout.NORTH);
		frame.getMainPanel().add(new JButton("South"),BorderLayout.SOUTH);
		frame.getMainPanel().add(new JButton("Center"),BorderLayout.CENTER);
		frame.getMainPanel().add(new JButton("East"),BorderLayout.EAST);
		frame.getMainPanel().add(new JButton("West"),BorderLayout.WEST);
		
		frame.setVisible(true);
	}
	/* Note sul BorderLayout:
	 * - In NORTH e SOUTH usa l'altezza preferita del componente 
	 * - In EAST e WEST usa la larghezza preferita del componente
	 * - Altrove no.. 
	 */
}
