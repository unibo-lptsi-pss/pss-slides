package it.unibo.apice.oop.p14gui.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import it.unibo.apice.oop.p14gui.mvc.model.DrawResult;

public class DrawNumberViewImpl implements DrawNumberView {
	
	private static final String FRAME_NAME = "Draw Number App";
	private static final String QUIT = "Quit";
	private static final String RESET = "Reset";
	private static final String GO = "Go";
	private static final Dimension WINDOW_DIMENSION = new Dimension(320,200);
	
	private static final Map<DrawResult,String> messages = new HashMap<>();
	static{ // inizializzatore statico
	    messages.put(DrawResult.YOURS_IS_HIGHER,"Your number is too high");
	    messages.put(DrawResult.YOURS_IS_LOWER,"Your number is too low");
	    messages.put(DrawResult.YOU_WON,"You won the game!!");
	}
	
	private DrawNumberViewObserver observer;
	private JFrame frame = new JFrame(FRAME_NAME);

	public DrawNumberViewImpl() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WINDOW_DIMENSION);
		frame.getContentPane().add(new JPanel(new BorderLayout()));
		final JPanel pNorth = new JPanel(new FlowLayout());
		final JTextField tNumber = new JTextField(10);
		final JButton bGo = new JButton(GO); 
		pNorth.add(tNumber);
		pNorth.add(bGo);
		final JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		final JButton bReset = new JButton(RESET);
		final JButton bQuit = new JButton(QUIT);
		pSouth.add(bReset);
		pSouth.add(bQuit);
		frame.getContentPane().add(pNorth,BorderLayout.NORTH);
		frame.getContentPane().add(pSouth,BorderLayout.SOUTH);
		bGo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					observer.newAttempt(Integer.parseInt(tNumber.getText()));
				} catch (NumberFormatException exception){
					JOptionPane.showMessageDialog(frame, "An integer please..");
				}
			}});
		bQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (confirmDialog("Confirm quitting?","Quit")){
					observer.quit();
				}
			}});
		bReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (confirmDialog("Confirm resetting?","Reset")){
					observer.resetGame();
				}
			}});
	}
	
	public void start(){
		this.frame.setVisible(true);
	}
	
	private boolean confirmDialog(String question, String name){
		return JOptionPane.showConfirmDialog(frame,question,name,JOptionPane.YES_NO_OPTION) 
				== JOptionPane.YES_OPTION;
	}
	
	public void setObserver(DrawNumberViewObserver observer){
		this.observer = observer;
	}

	public void numberIncorrect() {
		JOptionPane.showMessageDialog(frame, "Incorrect Number.. try again", 
				"Incorrect Number", JOptionPane.ERROR_MESSAGE);
	}

	public void limitsReached() {
		JOptionPane.showMessageDialog(frame, "You lost.. a new game starts", 
				"Lost", JOptionPane.WARNING_MESSAGE);
	}

	public void result(DrawResult res) {
	    JOptionPane.showMessageDialog(frame, messages.get(res),
	                                  "Result",JOptionPane.PLAIN_MESSAGE);
	}
}
