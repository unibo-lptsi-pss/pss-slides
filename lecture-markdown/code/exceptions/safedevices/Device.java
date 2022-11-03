/**
 *  Not copyrighted
 */


/**
 * @author Mirko Viroli
 * 
 */
public interface Device {

	/**
	 * Switches Off the Device. It does nothing if it is already switched off.
	 */
	void off();

	/**
	 * Switches On the Device. It does nothing if it is already switched on. If
	 * already over or becoming over it goes over and off
	 * 
	 * @throws DeviceIsOverException
	 *             if it ends up off
	 */
	void on() throws DeviceIsOverException;

	/**
	 * @return whether it is on
	 */
	boolean isOn();

	/**
	 * @return whether it is over
	 */
	boolean isOver();
}
