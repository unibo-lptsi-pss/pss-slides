public class LampsRow<L extends SimpleLamp> {
    
    private Vector<L> lamps;
    
    public LampsRow(){
    	this.lamps = new Vector<>(); // inferenza
    }
    
    public L getLamp(int position){
    	return this.lamps.getElementAt(position);
    }
    
    public void addLamp(L lamp){
    	this.lamps.addElement(lamp);
    }
    
    public void switchOffAll(){
    	for (int i=0;i<lamps.getLength();i++){
    	    this.getLamp(i).switchOff();
    	}
    }
    
    public String toString(){
    	return this.lamps.toString();
    }
}
