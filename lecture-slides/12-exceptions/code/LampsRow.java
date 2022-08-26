public class LampsRow{
    
    private SimpleLamp[] row;
    
    public LampsRow(int size){
    	this.row = new SimpleLamp[size];
    }
    public void addLamp(int position, SimpleLamp lamp){
    	this.row[position] = lamp;
    }
    public SimpleLamp getLamp(int position){
    	return this.row[position];
    }
    ..
}

// Codice cliente
LampsRow lr = LampsRow(3);
lr.addLamp(0,new CountdownLamp(10));
lr.addLamp(1,new CountdownLamp(10));
lr.addLamp(2,new SimpleLamp());
...
CountdownLamp cl = (CountdownLamp)lr.getLamp(2); // Exception


