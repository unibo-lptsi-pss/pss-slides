package it.unibo.apice.oop.p06interfaces;

public class LampsRow{
    
    private final Lamp[] row; // Campo
    
    public LampsRow(final int size){
    	this.row = new Lamp[size]; // Tutti i valori a null
    }
    public void installLamp(final int position, final Lamp lamp){
    	this.row[position] = lamp;
    }
    public void removeLamp(final int position){
    	this.row[position] = null;
    }
    public void switchAll(final boolean on){
    	for (Lamp lamp: this.row){
    	    if (lamp != null){ // Previene il NullPointException
    	    	if (on){
    	    	    lamp.switchOn();
    	    	} else {
    	    	    lamp.switchOff();
    	    	}
    	    }
    	}
    }
    public Lamp getLamp(final int position){ // Selettore
    	return this.row[position];
    }
    public boolean isInstalled(final int position){ // Selettore
    	return this.row[position] != null;
   }
}
