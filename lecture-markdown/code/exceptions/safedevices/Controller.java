

import java.io.*;

/**
 * @author Mirko Viroli
 * 
 * The Controller class as of MVC
 *
 */
public class Controller{

	final private static String START = "Sistema inizializzato";
	final private static String EXIT = "Comando di uscita... bye bye";
	final private static String CMD_ERROR = "Comando errato.. reinserire";
	final private static String DEVICE_OVER = "Device esaurito!";
	final private static String CMD_OK = "Comando eseguito";
	final private static String ASK = "Inserisci il comando (exit, +N, -N, +all, -all): ";

	private DeviceRow row;
	private View view;
	private CommandExecutor executor;

	public Controller(int size, Console console) {
		super();
		this.row = new DeviceRow(size);
		this.view = new ConsoleView();
		this.executor = new SimpleCommandExecutor();
		this.executor.setDeviceRow(this.row);
	}

	/**
	 * This method implements the main loop of the program 
	 */
	public void start() {
		this.view.setLogString(START);
		while (true) {
			try {
				this.view.setRowStatus(this.row.toString());
				this.view.redraw();
				this.executor.exec(this.view.ask(ASK));
				this.view.setLogString(CMD_OK);
			} catch (DeviceIsOverException e) {
				this.view.setLogString(DEVICE_OVER);
			} catch (CommandNotRecognisedException e) {
				this.view.setLogString(CMD_ERROR + " (" + e.getMessage() + ")");
			} catch (ExitCommandException e){
				this.view.setLogString(EXIT);
				System.exit(1);
			} 
		}
	}
	
	public static void main(String[] args) {
		Controller c = new Controller(5, System.console());
		c.start();
	}
}
