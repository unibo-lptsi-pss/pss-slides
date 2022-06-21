package it.unibo.apice.oop.p06interfaces.domo;

public class DomusController {

	/* Compongo n oggetti che implementano Device */
	private final Device[] devices;

	public DomusController(final int size) {
		this.devices = new Device[size];
	}

	/* Aggiungo un device */
	public void installDevice(final int position, final Device dev) {
		this.devices[position] = dev;
	}

	/* Rimuovo un device */
	public void removeDevice(final int position) {
		this.devices[position] = null;
	}

	public Device getDevice(final int position) {
		return this.devices[position];
	}

	/* Spengo/accendo tutti i device */
	public void switchAll(final boolean on) {
		for (Device dev : this.devices) {
			if (dev != null) { // Prevengo il NullPointerException
				if (on) {
					dev.switchOn();
				} else {
					dev.switchOff();
				}
			}
		}
	}

	/* Verifico se sono tutti accesi */
	public boolean isCompletelySwitchedOn() {
		for (Device dev : this.devices) {
			if (dev != null && !dev.isSwitchedOn()) {
				return false;
			}
		}
		return true;
	}
}
