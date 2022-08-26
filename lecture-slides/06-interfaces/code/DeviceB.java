public class Lamp implements Device{
    ...  // Nessun cambiamento necessario rispetto a prima!
    private boolean switchedOn;
    
    public void switchOn(){
    	this.switchedOn = true;
    }
    public void switchOff(){
    	this.switchedOn = false;
    }
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
    ...
}

public class TV implements Device{
    ... // Nessun cambiamento necessario rispetto a prima!
}

public class Radio implements Device{
    ... // Nessun cambiamento necessario rispetto a prima!
}
