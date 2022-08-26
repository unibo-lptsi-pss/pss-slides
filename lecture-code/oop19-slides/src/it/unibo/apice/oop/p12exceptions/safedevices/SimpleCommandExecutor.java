package it.unibo.apice.oop.p12exceptions.safedevices;


/**
 * @author mirko
 * Implements a CommandExecutor, encapsulating all corresponding design choices  
 */
public class SimpleCommandExecutor implements CommandExecutor{
	
	private static final String ON = "+"; 
	private static final String OFF = "-";
	private static final String EXIT = "exit";
	private static final String OFFALL = "-all";
	private static final String ONALL = "+all";
	private static final String ERROR_UNRECOGNISED = "Unrecognised string";
	private static final String ERROR_OUTOFRANGE = "Out of range";

	private DeviceRow row;
	
	public SimpleCommandExecutor(){
	}
	
	public void setDeviceRow(DeviceRow row) {
		this.row = row;
	}
	
	/**
	 * @param s is the String command to interpret and execute
	 * @throws ExitCommandException
	 * @throws CommandNotRecognisedException
	 * @throws DeviceIsOverException
	 */
	public void exec(final String s) throws ExitCommandException, 
	                                  CommandNotRecognisedException, 
	                                  DeviceIsOverException {
		if (!processExit(s) &&
			!processOffAll(s) &&
			!processOnAll(s) && 
			!processOn(s) &&
			!processOff(s)){
				throw new CommandNotRecognisedException(ERROR_UNRECOGNISED+" '"+s+"'");
		}
	}
	
	private boolean processExit(final String s) throws ExitCommandException {
		if (s.equals(EXIT)){
			throw new ExitCommandException();
		}
		return false;
	}
	
	private boolean processOffAll(final String s){
		if (s.equals(OFFALL)){
			this.row.allOff();
			return true;
		}
		return false;
	}
	
	private boolean processOnAll(final String s) throws DeviceIsOverException{
		if (s.equals(ONALL)){
			this.row.allOn();
			return true;
		}
		return false;
	}
	
	private boolean processOn(final String s) 
			throws CommandNotRecognisedException,
			       DeviceIsOverException {
		if (s.startsWith(ON)){
			final int index = Integer.parseInt(s.substring(ON.length()));
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).on();
			return true;
		}
		return false;
	}
	// Some cut-and-past that could be resolved
	private boolean processOff(String s) throws 
			CommandNotRecognisedException {
		if (s.startsWith(OFF)){
			final int index = Integer.parseInt(s.substring(OFF.length()));
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).off();
			return true;
		}
		return false;
	}	
 	
}
