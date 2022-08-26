package it.unibo.apice.oop.p21patterns.adapter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame{

	private static final long serialVersionUID = 2298666777798069846L;
	
	public GUI(){
		this.setSize(320,200);
		final JButton jb = new JButton("Action!");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(jb);
		jb.addActionListener(new HandlerAdapter());
		this.setVisible(true);
	}
	
	// metodo in GUI da adattare a ActionListener
	private void handlingButtonAction(){
		System.exit(0);
	}
	
	private class HandlerAdapter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			GUI.this.handlingButtonAction();
		}		
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
