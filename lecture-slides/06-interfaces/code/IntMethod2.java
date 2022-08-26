class DeviceUtilities{
    
    /* Grazie alle interfacce, fattorizzo in un solo metodo */
    
    public static void switchOnIfCurrentlyOff(Device device){
    	if (!device.isSwitchedOn()){
    	    device.switchOn();
    	}
    }
}

/* Codice cliente */
Lamp lamp = new Lamp();
TV tv = new TV();
Radio radio = new Radio();

switchOnIfCurrentlyOff(lamp); // OK, un Lamp è un Device 
switchOnIfCurrentlyOff(tv); // OK, una TV è un Device
switchOnIfCurrentlyOff(radio); // OK, una Radio è un Device

