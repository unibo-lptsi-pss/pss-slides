class DeviceUtilities{
    
    /* Senza interfacce, non resta altro che... */
    
    public static void switchOnIfCurrentlyOff(Lamp lamp){
    	if (!lamp.isSwitchedOn()){
    	    lamp.switchOn();
    	}
    }
    
    public static void switchOnIfCurrentlyOff(TV tv){
    	if (!tv.isSwitchedOn()){
    	    tv.switchOn();
    	}
    }
    
    public static void switchOnIfCurrentlyOff(Radio radio){
    	if (!radio.isSwitchedOn()){
    	    radio.switchOn();
    	}
    }
    ..
}

