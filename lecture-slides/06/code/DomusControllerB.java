    /* Spengo/accendo tutti i device */ 
    public void switchAll(boolean on){
    	for (Device dev : this.devices){
    	    if (dev != null) {  // Prevengo il NullPointerException
    	    	if (on){
    	    	    dev.switchOn();
    	    	} else {
    	    	    dev.switchOff();
    	    	}
    	    }
    	}
    }
    
    /* Verifico se sono tutti accesi */
    public boolean isCompletelySwitchedOn(){
    	for (Device dev : this.devices){
    	    if (dev != null && !dev.isSwitchedOn()){
    	    	return false;
    	    }
    	}
    	return true;
    }
}
