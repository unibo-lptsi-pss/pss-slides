package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class UseMixedLayouts{
	
	public static void main(String[] args){
		final JTextArea textArea = new JTextArea(); // Area di testo
		textArea.setLineWrap(true);
		final JScrollPane scroll = new JScrollPane(textArea); // Pannello con barra
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		final JPanel pEastInternal = new JPanel(new GridBagLayout()); // Griglia flessibile
		pEastInternal.setBorder(new TitledBorder("GridBagLayout"));
		final GridBagConstraints cnst = new GridBagConstraints();
		cnst.gridy = 0;								  // 1-a riga
		cnst.insets = new Insets(3,3,3,3);			  // spazio attorno al comp.
		cnst.fill = GridBagConstraints.HORIZONTAL; 	  // estensione in orizzont.
		pEastInternal.add(new JButton("LOAD"),cnst);
		cnst.gridy++;								  // prossima riga
		pEastInternal.add(new JButton("SAVE"),cnst);
		cnst.gridy++;
		pEastInternal.add(new JButton("CLEAR"),cnst);
		cnst.gridy++;
		pEastInternal.add(new JButton("QUIT"),cnst);
		
		final JPanel pEast = new JPanel(new FlowLayout());
		pEast.setBorder(new TitledBorder("FlowLayout"));
		pEast.add(pEastInternal);
		
		final MyFrame frame = new MyFrame("MixedLayouts Example",new BorderLayout(5,5));
		frame.getMainPanel().add(scroll,BorderLayout.CENTER);
		frame.getMainPanel().add(pEast,BorderLayout.EAST);
		frame.getMainPanel().setBorder(new TitledBorder("BorderLayout"));
		frame.setVisible(true);
	}
}
