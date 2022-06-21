public class DomusController{
    
    private Lamp[] lamps;
    private TV[] tvs;
    private AirConditioner[] airs;
    private Radio[] radios;
    
    ...
    public void switchAll(boolean on){
    	for (Lamp lamp: this.lamps){
    	    if (lamp != null){
    	    	if (on){
    	    	    lamp.switchOn();
    	    	} else {
    	    	    lamp.switchOff();
    	    	}
    	    }
    	}
    	for (TV tv: this.tvs){
    	    if (tv != null){ 
    	    	if (on){
    	    	    tv.switchOn();
    	    	} else {
    	    	    tv.switchOff();
    	    	}
    	    }
    	}
    	... // e così via per tutti i dispositivi
    }
 
}
