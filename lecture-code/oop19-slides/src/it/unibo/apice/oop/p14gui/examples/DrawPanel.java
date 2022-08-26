package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;
import java.util.*;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	private static final int RADIUS = 30;
	private static final Random RND = new Random();
	private final Map<Point,Color> circles = new HashMap<>();

	// override del metodo di disegno  
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Map.Entry<Point,Color> e : this.circles.entrySet()) {
			g.setColor(e.getValue());
			g.fillOval(e.getKey().x, e.getKey().y, RADIUS, RADIUS);
		}
	}
	
	// Metodo per aggiungere nuovi cerchi in posizione random
	public void addRandomPoint(){
		int x = RND.nextInt(this.getWidth());
		int y = RND.nextInt(this.getHeight());
		this.addPoint(x,y);
	}
	
	// Metodo per aggiungere nuovi cerchi
	public void addPoint(int x, int y){
		final Color c = new Color(RND.nextInt(256),RND.nextInt(256),RND.nextInt(256));
		this.circles.put(new Point(x-RADIUS/2,y-RADIUS/2),c);
	}
}
