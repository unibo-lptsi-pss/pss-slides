package it.unibo.apice.oop.p05encapsulation;

public class LampString {

	/* Costanti luminosità */
	private final static int LEVELS = 10;
	private final static double DELTA = 0.1;

	/* Campi della classe */
	private int intensity;
	private boolean switchedOn;

	/* Costruttore */
	public LampString() {
		this.switchedOn = false;
		this.intensity = 0;
	}

	/* Gestione switching */
	public void switchOn() {
		this.switchedOn = true;
	}

	public void switchOff() {
		this.switchedOn = false;
	}
	
	public boolean isSwitchedOn() {
		return this.switchedOn;
	}

	/* Gestione intensita' */
	private void correctIntensity() { // A solo uso interno
		if (this.intensity < 0) {
			this.intensity = 0;
		} else if (this.intensity > LEVELS) {
			this.intensity = LEVELS;
		}
	}

	public void setIntensity(double value) {
		this.intensity = Math.round((float) (value / DELTA));
		this.correctIntensity();
	}

	public void dim() {
		this.intensity--;
		this.correctIntensity();
	}

	public void brighten() {
		this.intensity++;
		this.correctIntensity();
	}

	public double getIntensity() {
		return this.intensity * DELTA;
	}
    
    public String toString(){
    	return "Acceso: "+this.isSwitchedOn()+
    	    ", Intensità: "+this.getIntensity();
    }
} 
