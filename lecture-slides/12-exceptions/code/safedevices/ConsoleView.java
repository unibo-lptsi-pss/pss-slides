

import java.io.*;

/**
 * @author mirko
 * This class provides an implementation of the View simply using the console
 */
public class ConsoleView implements View {

	final private static String CLEAR_CONSOLE = "\033[2J\033[;H";
	final private static BufferedReader KBD = new BufferedReader(new InputStreamReader(System.in));
	
	private String rowString;
	private String logString;
	
	public ConsoleView() {
		super();
		this.rowString = "";
		this.logString = "";
	}

	public void redraw() {
		//System.out.println(""); 
		System.out.print("\033[2J\033[;H");
		System.out.println(this.rowString);
		System.out.println(this.logString);
	}

	public void setRowStatus(String s) {
		this.rowString = s;
	}

	public void setLogString(String s) {
		this.logString = s;
	}

	public String ask(String question){
		System.out.print(question); // Asking message
		String s ="";
		try{
			s = KBD.readLine();
		} catch (IOException e){}
		return s;
	}

}
