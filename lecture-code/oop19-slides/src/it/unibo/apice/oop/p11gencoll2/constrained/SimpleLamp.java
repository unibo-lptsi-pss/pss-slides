package it.unibo.apice.oop.p11gencoll2.constrained;

public class SimpleLamp{
    
    private boolean switchedOn;
    
    public SimpleLamp(){
    	this.switchedOn = false;
    }
    
    public void switchOn(){
    	this.switchedOn = true;
    }
    
    public void switchOff(){
    	this.switchedOn = false;
    }
    
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
} 
