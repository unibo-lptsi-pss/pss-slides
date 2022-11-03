public class LampsRow{
    private SimpleLamp[] row;
    public LampsRow(int size){
    	if (size<0) {throw ???;} // lancio eccezione
    	this.row = new SimpleLamp[size];
    }
    ..
