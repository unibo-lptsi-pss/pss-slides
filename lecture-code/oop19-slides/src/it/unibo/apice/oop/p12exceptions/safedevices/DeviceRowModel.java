package it.unibo.apice.oop.p12exceptions.safedevices;

/**
 * @author mirko
 * A simple wrapper implementing the model
 */
public class DeviceRowModel implements Model {
	
	private final DeviceRow row;
	
	public DeviceRowModel(final int size){
		this.row = new DeviceRow(size);
	}
	
	public DeviceRow getDeviceRow(){
		return this.row;
	}
	
}
