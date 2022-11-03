import java.io.*;

public class ConsoleView implements View {

	final private static String CLEAR_CONSOLE = "\033[2J\033[;H";
	
	private Console console;
	private String rowString;
	private String logString;
	
	
	public ConsoleView() {
		super();
		this.console = System.console();
	}

	private void redraw() {
		console.writer().print(CLEAR_CONSOLE);
		console.writer().println(this.rowString);
		console.writer().println(this.logString);	
	}

	public void setRowStatus(DeviceRow row) {
		this.rowString = row.toString();
		redraw();
	}

	public void setLogString(String s) {
		this.logString = s;
		redraw();
	}

	public String ask(String question){
		console.writer().print(question); // Asking message
		console.writer().flush();	 // Make sure it is written
		return this.console.readLine();
	}

}
