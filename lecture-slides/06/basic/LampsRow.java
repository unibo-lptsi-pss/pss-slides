
public class LampsRow{
    
    private Lamp[] row; // Campo
    
    public LampsRow(int size){
    	this.row = new Lamp[size]; // Tutti i valori a null
    }
    public void installLamp(int position, Lamp lamp){
    	this.row[position] = lamp;
    }
    public void removeLamp(int position){
    	this.row[position] = null;
    }
    public void switchAll(boolean on){
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
    public Lamp getLamp(int position){ // Selettore
    	return this.row[position];
    }
    public boolean isInstalled(int position){ // Selettore
    	return this.row[position] != null;
    } 
}
