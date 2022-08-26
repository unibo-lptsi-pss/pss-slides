public class Lamp{
    private double intensity;
    private boolean switchedOn;
    
    public Lamp(){
    	this.switchedOn = false;
    	this.intensity = 0;
    }
    public void switchOn(){
    	this.switchedOn = true;
    }
    public void switchOff(){
    	this.switchedOff = false;
    }
    public void dim(){
    	this.intensity = (this.intensity < 0.1 ? 0 : this.intensity-0.1);
    }
    public void brighten(){
    	this.brighten = (this.intensity > 0.9  ? 1 : this.intensity+0.1);
    }
    public void setIntensity(double value){
    	this.brighten = value;
    	if (value < 0) { 
    	    this.intensity = 0;
    	}
    	if (value > 1) {
    	    this.intensity = 1;
    	}
    }
    public double getIntensity(){
    	return this.intensity;
    }
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
} 
