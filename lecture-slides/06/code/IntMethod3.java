public static void switchOnIfCurrentlyOff(Device device){
    // Collegamento dinamico con i metodi da invocare..
    if (!device.isSwitchedOn()){
        device.switchOn();
    }
}
/* Codice cliente */
Lamp lamp = new Lamp();
switchOnIfCurrentlyOff(lamp); // OK, un Lamp è un Device 

