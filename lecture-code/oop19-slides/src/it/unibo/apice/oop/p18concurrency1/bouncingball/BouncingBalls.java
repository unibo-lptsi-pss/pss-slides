package it.unibo.apice.oop.p18concurrency1.bouncingball;

/**
 * SISOP 08/09
 *
 * @author Alessandro Ricci 
 */
public class BouncingBalls {

    public static void main(String[] args) {
        
        Context ctx = new Context();
        
        Visualiser viewer = new Visualiser(ctx);
        viewer.start();
      
        ControlPanel control = new ControlPanel(ctx);
        control.setVisible(true);
    }
}
