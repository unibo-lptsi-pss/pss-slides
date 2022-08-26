/* Interfaccia per dispositivi */
public interface Device{ 	// Contratto:
    void switchOn(); 		// - si può accendere
    void switchOff();		// - si può spegnere
    boolean isSwitchedOn();	// - si può verificare se acceso/spento
}

/* Interfaccia per entità luminose */
public interface Luminous{     	// Contratto:
    void dim();			// - si può ridurre la luminosità
    void bright();		// - si può aumentare la luminosità
}

public class Lamp implements Device, Luminous{
    ...  
    public void switchOn(){ ... }
    public void switchOff(){ ... }
    public boolean isSwitchedOn(){ ... }
    public void dim(){ ... }
    public void bright(){ ... }
}
