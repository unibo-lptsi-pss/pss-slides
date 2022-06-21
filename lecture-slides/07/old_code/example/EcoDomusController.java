public class EcoDomusController{
    
    /* Compongo n LimitedLamp */
    private LimitedLamp[] lamps;
    
    public EcoDomusController(int size, int lampsLimit){
    	this.lamps = new LimitedLamp[size];
    	for (int i=0;i<size;i++){
    	    this.lamps[i] = new LimitedLamp(lampsLimit);
    	}
    }
    
    public LimitedLamp getLamp(int position){
    	return this.lamps[position];
    }
    
    private LimitedLamp toBeUsedNext(){
    	LimitedLamp best = this.lamps[0]; // Intercettare se this.lamps.length == 0
    	for (LimitedLamp lamp: this.lamps){
    	    if (!lamp.isSwitchedOn() && 
    	    	      lamp.getRemainingLifeTime() > 
    	    	      best.getRemainingLifeTime()){
    	    	best = lamp;
    	    }
    	} 
    	return best;
    }
    
    /* Accendo una lampadina spenta, scegliendola in modo economico */ 
    public void switchOnOne(){
    	LimitedLamp lamp=this.toBeUsedNext();
    	if (lamp!=null){
    	    lamp.switchOn();
    	}
    }
    
    /* Verifico se sono tutti accesi */
    public boolean allOver(){
    	for (LimitedLamp lamp : this.lamps){
    	    if (!lamp.isOver()){
    	    	return false;
    	    }
    	}
    	return true;
    }
    
    public String toString(){
    	String s="";
    	for (LimitedLamp lamp : this.lamps){
    	    s += (lamp.isSwitchedOn()?"on":"off");
    	    s += "(" + lamp.getRemainingLifeTime()+")" + " | ";
    	}
    	return s;
    }
}
