public interface CommandExecutor {
	
	void exec(String s) throws ExitCommandException, 
	                           CommandNotRecognisedException, 
	                           DeviceIsOverException;
	                           
	void setDeviceRow(DeviceRow row);
}
