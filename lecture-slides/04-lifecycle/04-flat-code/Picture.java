

import java.awt.image.*;
import java.awt.*;
import javax.swing.*;

public class Picture {
	
	BufferedImage bi = null;
	JFrame jf = null;
	
	Picture(int width, int height){
		jf = new JFrame("Mandelbrot Set"){
			@Override
		    public void paint(Graphics g) {
		        g.drawImage(bi, 0, 0, this);
		    }
		};
        jf.setSize(width, height);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bi = new BufferedImage(jf.getWidth(), jf.getHeight(), BufferedImage.TYPE_INT_RGB);
        jf.setVisible(true);
	}
	
	void drawPixel(int x, int y, int color){
		bi.setRGB(x, y, color);
		jf.repaint();
	}

}
