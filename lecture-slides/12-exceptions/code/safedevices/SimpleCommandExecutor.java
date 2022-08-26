

/**
 * @author mirko
 * Implements a CommandExecutor, encapsulating all corresponding design choices  
 */
public class SimpleCommandExecutor implements CommandExecutor{
	
	final private static String ON = "+"; 
	final private static String OFF = "-";
	final private static String EXIT = "exit";
	final private static String OFFALL = "-all";
	final private static String ONALL = "+all";
	final private static String ERROR_UNRECOGNISED = "Unrecognised string";
	final private static String ERROR_OUTOFRANGE = "Out of range";

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
	public void exec(String s) throws ExitCommandException, CommandNotRecognisedException, DeviceIsOverException {
		if (!processExit(s) &&
				!processOffAll(s) &&
				!processOnAll(s) && 
				!processOn(s) &&
				!processOff(s)){
					throw new CommandNotRecognisedException(ERROR_UNRECOGNISED+" '"+s+"'");
		}
	}
	
	private boolean processExit(String s) throws ExitCommandException {
		if (s.equals(EXIT)){
			throw new ExitCommandException();
		}
		return false;
	}
	
	private boolean processOffAll(String s){
		if (s.equals(OFFALL)){
			this.row.allOff();
			return true;
		}
		return false;
	}
	
	private boolean processOnAll(String s) throws DeviceIsOverException {
		if (s.equals(ONALL)){
			this.row.allOn();
			return true;
		}
		return false;
	}
	
	private boolean processOn(String s) throws CommandNotRecognisedException, DeviceIsOverException {
		if (s.startsWith(ON)){
			int index = Integer.parseInt(s.substring(ON.length()));
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).on();
			return true;
		}
		return false;
	}
	
	private boolean processOff(String s) throws CommandNotRecognisedException {
		if (s.startsWith(OFF)){
			int index = Integer.parseInt(s.substring(OFF.length()));
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).off();
			return true;
		}
		return false;
	}	
 	
}
