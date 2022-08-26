public interface Device{ 	
    void switchOn(); 		
    void switchOff();		
    boolean isSwitchedOn();	
}
public interface Luminous{     	
    void dim();			
    void bright();		
}

/* Interfaccia per dispositivi luminosi */
public interface LuminousDevice extends Device, Luminous{
    // non si aggiungono ulteriori metodi 
}

public class Lamp implements LuminousDevice{
    ...  
    public void switchOn(){ ... }
    public void switchOff(){ ... }
    public boolean isSwitchedOn(){ ... }
    public void dim(){ ... }
    public void bright(){ ... }
}
