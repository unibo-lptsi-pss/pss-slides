/* Su Lamp effettuo le usuali operazioni */
Lamp lamp = new Lamp();    
lamp.switchOn();		
boolean b = lamp.isSwitchedOn(); 

/* Una variabile di tipo Device può contenere 
   un Lamp, e su essa posso eseguire le 
   operazioni definite da Device */
Device dev;	  // creo la variabile
dev = new Lamp(); // assegnamento ok	
dev.switchOn();	  // operazione di Device
boolean b2 = dev.isSwitchedOn();  // operazioni di Device 

Device dev2 = new Lamp();  // Altro assegnamento

/* Attenzione, le interfacce non sono istanziabili */
// Device dev3 = new Device(); NO!!!! 

