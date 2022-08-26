package it.unibo.apice.oop.p12exceptions.safedevices;

public abstract class AbstractDevice implements Device {

	private boolean on;
	private boolean over; // over implies not on

	/**
	 * Setting the lamp as working and off
	 */
	public AbstractDevice() {
		this.on = false;
		this.over = false;
	}

	final public boolean isOn() {
		return this.on; // getter
	}

	final public boolean isOver() { // getter
		return this.over;
	}

	final public void off() {
		this.on = false; // setter
	}

	/*
	 * It makes sure we call onFails() properly, and over and off are
	 * consistently changed.
	 * 
	 * @see safedevices.Device#on()
	 */
	final public void on() throws DeviceIsOverException {
		if (!this.on) { // is this a real switch-on?
			this.over = this.onFails(); // is it over?
			this.on = !this.over; // correspondingly switch
		}
		if (!this.on) { // could I switch?
			throw new DeviceIsOverException(this); // raise exception
		}
	}

	/**
	 * Implement the strategy to recognise whether it is over
	 * 
	 * @return whether should become over
	 */
	protected abstract boolean onFails();

	public String toString() {
		return this.over ? "over" : this.on ? "on " : "off";
	}
}
