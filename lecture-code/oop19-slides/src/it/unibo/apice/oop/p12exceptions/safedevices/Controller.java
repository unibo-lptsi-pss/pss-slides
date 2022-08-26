package it.unibo.apice.oop.p12exceptions.safedevices;

/**
 * @author Mirko Viroli
 * 
 * The Logics class as of MVC
 *
 */
public class Controller{

	private static final String START = "Sistema inizializzato";
	private static final String EXIT = "Comando di uscita... bye bye";
	private static final String CMD_ERROR = "Comando errato.. reinserire";
	private static final String DEVICE_OVER = "Device esaurito!";
	private static final String CMD_OK = "Comando eseguito";
	private static final String ASK = "Inserisci il comando (exit, +N, -N, +all, -all): ";

	private final Model model;
	private final View view;
	private final CommandExecutor executor;

	private Controller(int size) {
		this.model = new DeviceRowModel(size);
		this.view = new ConsoleView();
		this.executor = new SimpleCommandExecutor();
		this.executor.setDeviceRow(this.model.getDeviceRow());
	}

	/**
	 * This method implements the main loop of the program 
	 */
	public void start() {
		this.view.setLogString(START);
		while (true) {
			try {
				this.view.setRowStatus(this.model.getDeviceRow().toString());
				this.view.redraw();
				final String command = this.view.ask(ASK);
				this.executor.exec(command);
				this.view.setLogString(CMD_OK);
			} catch (final DeviceIsOverException e) {
				this.view.setLogString(DEVICE_OVER);
			} catch (final CommandNotRecognisedException e) {
				this.view.setLogString(CMD_ERROR + " (" + e.getMessage() + ")");
			} catch (final ExitCommandException e){
				this.view.setLogString(EXIT);
				System.exit(0);
			} 
		}
	}
	
	public static void main(String[] args) {
		new Controller(5).start();
	}
}
