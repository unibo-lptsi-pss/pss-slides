

/**
 * @author Mirko Viroli
 * 
 * The interface over the View as of MVC
 *
 */
public interface View {
	
	/**
	 * @param s is the String representing the model status
	 */
	void setRowStatus(String s);
	
	/**
	 * @param s is the String representing a message from the controller
	 */
	void setLogString(String s);
	
	/**
	 * Updates the view
	 */
	void redraw();
	
	/**
	 * @param question is a message sent to the user
	 * @return the provided reply
	 */
	String ask(String question);
}
