public interface View {
	
	void setRowStatus(DeviceRow row);

	void setLogString(String s);

	String ask(String question);
}
