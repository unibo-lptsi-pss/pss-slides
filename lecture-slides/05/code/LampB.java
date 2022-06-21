    /* Gestione intensità */
    private void correctIntensity(){ // A solo uso interno
    	if (this.intensity < MIN_VAL) { 
    	    this.intensity = MIN_VAL; 
    	}
    	if (this.intensity > MAX_VAL) { 
    	    this.intensity = MAX_VAL; 
    	}
    }
    public void dim(){
    	this.setIntensity(this.intensity - DELTA_VAL);
    }
    public void brighten(){
    	this.setIntensity(this.intensity + DELTA_VAL);
    }
    public void setIntensity(double value){
    	this.intensity = value;
    	this.correctIntensity();
    }
