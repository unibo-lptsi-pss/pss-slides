package it.unibo.apice.oop.p14gui.gui;

import java.awt.*;
import javax.swing.*;

import it.unibo.apice.oop.p14gui.examples.MyFrame;

public class UserInterfaceImpl implements UserInterface {

	private final MyFrame frame;
	
	public UserInterfaceImpl() {
		this.frame = new MyFrame("Flow and Border", new BorderLayout());
		final JPanel pNorth = new JPanel(new FlowLayout());
		pNorth.add(new JButton("North 1"));
		final JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pSouth.add(new JButton("OK"));
		this.frame.getMainPanel().add(pNorth, BorderLayout.NORTH);
		this.frame.getMainPanel().add(pSouth, BorderLayout.SOUTH);
	}
	
	public void show(){
		this.frame.setVisible(true);
	}

	public void setDimensions(int x, int y) {
		this.frame.setSize(x,y);
	}
}
