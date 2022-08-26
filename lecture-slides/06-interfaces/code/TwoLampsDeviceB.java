    /* Altri metodi che lavorano sulla "composizione" */
    public void switchOnBoth(){
    	this.l1.switchOn();  // Nota la concatenazione di "."
    	this.l2.switchOn();  // .. è tipico della composizione
    }
    
    public void switchOffBoth(){
    	this.l1.switchOff();
    	this.l2.switchOff();
    }
    
    public void ecoMode(){
    	this.l1.switchOff();
    	this.l2.switchOn();
    	this.l2.setIntensity(0.5);
    }
} 
