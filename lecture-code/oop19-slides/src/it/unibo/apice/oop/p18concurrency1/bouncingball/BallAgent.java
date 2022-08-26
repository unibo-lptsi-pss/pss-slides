package it.unibo.apice.oop.p18concurrency1.bouncingball;

import java.util.*;

public class BallAgent extends Thread {
    
    private P2d pos;
    private V2d vel;
    private boolean stop;
    private double speed;
    private Boundary bounds;
    private long lastUpdate;
    
    public BallAgent(Context ctx){
        pos = new P2d(0,0);
        Random rand = new Random(System.currentTimeMillis());
        double dx = rand.nextDouble();
        vel = new V2d(dx,Math.sqrt(1-dx*dx));
        speed = rand.nextDouble()*3;
        bounds = ctx.getBounds();
        stop = false;
    }

    public void run() {
        try {
            lastUpdate = System.currentTimeMillis();
            while (!stop){
	            updatePos();
            	//Thread.sleep(20);	
	        }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void terminate(){
        stop = true;
    }
    
    private synchronized void updatePos(){
        long time = System.currentTimeMillis();
        long dt = time - lastUpdate;
        lastUpdate = time;
        pos = pos.sum(vel.mul(speed*dt*0.001));
        applyConstraints();
    }

    private void applyConstraints(){
        if (pos.x > bounds.getX1()){
            pos.x = bounds.getX1();
            vel.x = -vel.x;
        } else if (pos.x < bounds.getX0()){
            pos.x = bounds.getX0();
            vel.x = -vel.x;
        } else if (pos.y > bounds.getY1()){
            pos.y = bounds.getY1();
            vel.y = -vel.y;
        } else if (pos.y < bounds.getY0()){
            pos.y = bounds.getY0();
            vel.y = -vel.y;
        }
    }
    
    public synchronized P2d getPos(){
        return new P2d(pos.x,pos.y);
    }
    
    private void log(String msg){
        System.out.println("[BALL] "+msg);
    }

}
