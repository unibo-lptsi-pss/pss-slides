public class DomusController{
    
    /* Compongo n oggetti che implementano Device */
    private Device[] devices;
    
    public DomusController(int size){
    	this.devices = new Device[size];
    }
    
    /* Aggiungo un device */
    public void installDevice(int position, Device dev){
    	this.devices[position] = dev;
    }
    
    /* Rimuovo un device */
    public void removeDevice(int position){
    	this.devices[position] = null;
    }
    
    public Device getDevice(int position){
    	return this.devices[position];
    }
