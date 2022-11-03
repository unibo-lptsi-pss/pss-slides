

public class CountdownDevice extends AbstractDevice{
    
    private int countdown;
    
    public CountdownDevice(int countdown){
    	super();
    	if (countdown < 1){
    		throw new IllegalArgumentException();
    	}
    	this.countdown = countdown;
    }
    
    protected boolean onFails(){
    	if (this.countdown == 0){
    		return true;
    	}
    	this.countdown--;
    	return false;
    }
    
    public String toString(){
    	return super.toString() + "." + this.countdown;
    }
} 