package safedevices;

public class AdvancedCommandExecutor implements CommandExecutor{
	
	private DeviceRow row;
	private Parser parser;
	private Exec exec;
	
	public AdvancedCommandExecutor(){
		this.parser = new Parser();
		this.exec = new Exec();
	}
	
	public void setDeviceRow(DeviceRow row) {
		this.row = row;
	}

	
	/**
	 * @param s is the String command to interpret and execute
	 * @throws ExitCommandException
	 * @throws CommandNotRecognisedException
	 * @throws DeviceIsOverException
	 * 
	 */
	public void exec(String s) throws ExitCommandException, CommandNotRecognisedException, DeviceIsOverException {
		try {
			Command c = this.parser.parse(s);
			if (c.isCommandExit()){
				throw new ExitCommandException();
			}
			c.visit(this.exec);
		} catch (ExitCommandException e){
			throw e;
		} catch (CommandNotRecognisedException e){
			throw e;
		} catch (DeviceIsOverException e){
			throw e;
		} catch (Exception e){
			throw new RuntimeException(e);		
		}
	}
	
	class Exec implements Command.Visitor {
		
		public void visit(Command.Exit cmd) throws Exception {		
		}

		public void visit(Command.OffAll cmd) throws Exception {
			AdvancedCommandExecutor.this.row.allOff();		
		}

		public void visit(Command.OnAll cmd) throws Exception {
			AdvancedCommandExecutor.this.row.allOn();		
		}

		public void visit(Command.On cmd) throws Exception {
			AdvancedCommandExecutor.this.row.getDevice(cmd.getIndex()).on();
		}

		public void visit(Command.Off cmd) throws Exception {
			AdvancedCommandExecutor.this.row.getDevice(cmd.getIndex()).off();
		}
	}
	
	private class Parser {
		
		final private static String ON = "+"; 
		final private static String OFF = "-";
		final private static String EXIT = "exit";
		final private static String OFFALL = "-all";
		final private static String ONALL = "+all";
		final private static String ERROR_UNRECOGNISED = "Unrecognised string";
		final private static String ERROR_OUTOFRANGE = "Out of range";
		
		private Command generated;
		
		public Parser(){
			this.generated = null;
		}
		
		public Command parse(String s) throws CommandNotRecognisedException{
			int size = AdvancedCommandExecutor.this.row.getSize();
			try{
				if (processExit(s,size) ||
					processOffAll(s,size) ||
					processOnAll(s,size) || 
				    processOn(s,size) ||
				    processOff(s,size)){
						return this.generated;
				} 
			} catch (Exception e) {
					throw new CommandNotRecognisedException(e.toString());
			} 
			throw new CommandNotRecognisedException(ERROR_UNRECOGNISED+" '"+s+"'");
		}
		
		private boolean processExit(String s, int size){
			if (s.equals(EXIT)){			
				this.generated = new Command.Exit();
				return true;
			}
			return false;
		}
		
		private boolean processOffAll(String s, int size){
			if (s.equals(OFFALL)){
				this.generated = new Command.OffAll();
				return true;
			}
			return false;
		}
		
		private boolean processOnAll(String s, int size){
			if (s.equals(ONALL)){
				this.generated = new Command.OnAll();
				return true;
			}
			return false;
		}
		
		private boolean processOn(String s, int size) throws CommandNotRecognisedException {
			if (s.startsWith(ON)){
				int index = Integer.parseInt(s.substring(ON.length()));
				if (index < 0 || index >= size){
					throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
				}
				this.generated = new Command.On(index);
				return true;
			}
			return false;
		}
		
		private boolean processOff(String s, int size) throws CommandNotRecognisedException {
			if (s.startsWith(OFF)){
				int index = Integer.parseInt(s.substring(OFF.length()));
				if (index < 0 || index >= size){
					throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
				}
				this.generated = new Command.Off(index);
				return true;
			}
			return false;
		}	
	}

}
