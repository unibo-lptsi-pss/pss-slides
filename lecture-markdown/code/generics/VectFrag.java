public class Vector<X>{
    ...
    public void addAllFrom(Vector<? extends X> vect){
    	for (int i=0;i<vect.getLength();i++){
    	    this.addElement(vect.getElementAt(i));
    	}
    }
}
