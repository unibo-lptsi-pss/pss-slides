/* Interfaccia per dispositivi */
public interface Device{ 
    void switchOn(); 	// si può accendere
    void switchOff();	// si può spegnere
    boolean isSwitchedOn();	// si può verificare se acceso/spento
}
