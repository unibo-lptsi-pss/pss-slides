package it.unibo.apice.oop.p06interfaces.domo;

public class TV implements Device {

	/* Campi della classe */
	private boolean switchedOn;

	/* Costruttore */
	public TV() {
		this.switchedOn = false;
	}

	/* Metodi per accendere e spegnere */
	public void switchOn() {
		this.switchedOn = true;
	}

	public void switchOff() {
		this.switchedOn = false;
	}

	public boolean isSwitchedOn() {
		return this.switchedOn;
	}

	public String toString() {
		return "I'm a TV..";
	}
}
