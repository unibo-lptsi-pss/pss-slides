package it.unibo.apice.oop.p12exceptions.safedevices;

import java.util.*;

public class DeviceRow {

	/**
	 * Default countdown for devices 
	 */
	private static final int COUNTDOWN = 3;

	/**
	 * The row of devices as a java.util.List, deferring actual implementation 
	 */
	private final List<Device> list;

	/**
	 * This constructor creates and initializes a list of CountdownDevice
	 * 
	 * @param size is the number of devices to use
	 * @throws an IllegalArgumentException if size < 0
	 *             
	 */
	public DeviceRow(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		this.list = new ArrayList<>();
		for (int i=0; i<size; i++) {
			this.list.add(new CountdownDevice(COUNTDOWN));
		}
	}

	/**
	 * @param index is the position of the device to get
	 * @return the device
	 */
	public Device getDevice(final int index) {
		return this.list.get(index);
	}

	/**
	 * @return the number of devices
	 */
	public int getSize() {
		return this.list.size();
	}

	/**
	 * Switches all devices off
	 */
	public void allOff() {
		for (final Device d : this.list) {
			d.off();
		}
	}

	/**
	 * Switches all devices on, no matter whether one fails.
	 * 
	 * @throws the last DeviceIsOverException raised, if any
	 */
	public void allOn() throws DeviceIsOverException {
		DeviceIsOverException e = null;
		for (final Device d : this.list) {
			try {
				d.on();
			} catch (DeviceIsOverException de) {
				e = de;
			}
		}
		if (e != null) {
			throw e;
		}
	}

	public String toString() {
		return "DeviceRow " + list;
	}

}
