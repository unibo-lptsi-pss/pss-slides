

/**
 * @author mirko
 * A simple wrapper implementing the model
 */
public class DeviceRowModel implements Model {
	private DeviceRow row;
	
	public DeviceRowModel(DeviceRow row){
		this.row = row;
	}
	
	public DeviceRow getDeviceRow(){
		return this.row;
	}
	
}
