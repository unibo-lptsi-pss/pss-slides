

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	private Device device;

	/**
	 * Reported for clarity, not really needed-
	 */
	public DeviceIsOverException(Device device) {
		this.device = device;
	}

	public Device getDevice() {
		return this.device;
	}
}