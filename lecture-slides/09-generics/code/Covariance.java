void addAString(Vector<Object> vector){
    vector.addElement("warning!");
}
...
Vector<Integer> vec=new Vector<>(); // Inferenza
vec.addElement(new Integer(0));
vec.addElement(new Integer(1));
vec.addElement(new Integer(2));
addAString(vec); 	// ATTENZIONE!!
int n = vec.getElementAt(3).intValue(); // break!
