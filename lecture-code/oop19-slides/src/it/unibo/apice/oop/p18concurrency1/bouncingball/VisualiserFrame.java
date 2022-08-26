package it.unibo.apice.oop.p18concurrency1.bouncingball;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.*;

public class VisualiserFrame extends JFrame {
    
    private VisualiserPanel panel;
    
    public VisualiserFrame(Context ctx){
        setTitle("Bouncing Balls");
        setSize(420,420);
        setResizable(false);
        panel = new VisualiserPanel();
        getContentPane().add(panel);
        addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(WindowEvent ev){
				System.exit(-1);
			}
		});
    }
    
    public void updatePosition(P2d[] pos){
        panel.updatePositions(pos);
    }
        
    public static class VisualiserPanel extends JPanel {
        private P2d[] positions;
        
        public VisualiserPanel(){
            setSize(400,400);
        }

        public void paint(Graphics g){
            g.clearRect(0,0,400,400);
            synchronized (this){
	            if (positions!=null){
	                for (int i=0; i<positions.length; i++){
		                P2d p = positions[i];
		                int x0 = (int)(180+p.x*180);
		                int y0 = (int)(180-p.y*180);
		                g.drawOval(x0,y0,20,20);
		            }
	            }
            }
        }
        
        public void updatePositions(P2d[] pos){
            synchronized(this){
                positions = pos;
            }
            repaint();
        }
    }
}
