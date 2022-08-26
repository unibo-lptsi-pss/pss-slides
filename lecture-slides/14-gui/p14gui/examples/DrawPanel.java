package it.unibo.apice.oop.p15gui.examples;

import java.awt.*;
import javax.swing.*;
import java.util.*;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {

	private static final int RADIUS = 30;
	private static final Random RND = new Random();
	private java.util.List<Pair<Point,Color>> circles = new ArrayList<>();

	@Override // override del metodo di disegno  
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Pair<Point,Color> p : this.circles) {
			g.setColor(p.getSecond());
			g.fillOval(p.getFirst().x, p.getFirst().y, RADIUS, RADIUS);
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
		Color c = new Color(RND.nextInt(256),RND.nextInt(256),RND.nextInt(256));
		this.circles.add(new Pair<>(new Point(x-RADIUS/2,y-RADIUS/2),c));
	}

}
