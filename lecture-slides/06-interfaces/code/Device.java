/* Interfaccia per dispositivi
   Definisce un contratto:
   - si può accendere
   - si può spegnere
   - si può verificare se acceso/spento 
   
   Nota: nessuna indicazione 
         public/private nei metodi!
*/
   
public interface Device{ 	
    void switchOn();       
    void switchOff();	   
    boolean isSwitchedOn();
}
