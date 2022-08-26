public interface Device {

    void off();					// Spegne
    
    void on() throws DeviceIsOverException;	// Accende
    
    boolean isOn();				// E' spento?
    
    boolean isOver();				// E' esaurito?
}
