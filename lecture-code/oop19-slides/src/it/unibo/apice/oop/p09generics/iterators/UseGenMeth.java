package it.unibo.apice.oop.p09generics.iterators;

public class UseGenMeth{
    public static void main(String[] s){
    	Vector<String> vs = new Vector<>();
    	vs.addElement("prova");
    	vs.addElement("di");
    	vs.addElement("vettore");
    	Vector<Pair<String,Integer>> vp = vs.<Integer>genVectorPair(101);
    	Vector<Pair<String,Integer>> vp2 = vs.genVectorPair(101); // inferenza
    	System.out.println(""+vp);
    }
}
