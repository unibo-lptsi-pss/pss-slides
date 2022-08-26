package it.unibo.apice.oop.p12exceptions.safedevices;

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	private final Device device;

	/**
	 * Reported for clarity, not really needed
	 */
	public DeviceIsOverException(final Device device) {
		this.device = device;
	}

	public Device getDevice() {
		return this.device;
	}
}