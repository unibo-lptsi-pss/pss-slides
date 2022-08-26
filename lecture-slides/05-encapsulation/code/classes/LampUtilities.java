public class LampUtilities{

    /* Costruisco una fila di lampadine */
    public static Lamp[] buildLampRow(int size){
    	Lamp[] array = new Lamp[size];
    	for (int index = 0; index < size; index++){
    	    array[index] = new Lamp();
    	}
    	return array;
    }
    
    /* Accendo/spengo una file di lampadine */
    public static void switchAll(boolean switchedOn, Lamp[] array){
    	for (Lamp l : array){
    	    if (switchedOn){
    	    	l.switchOn();
    	    } else {
    	    	l.switchOff();
    	    }
    	}	
    }
}
