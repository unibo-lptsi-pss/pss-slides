class A{
    protected int i = 1;
    int getI(){ return this.i;}
}
class B extends A{
    protected double d = 0.3;
    double getD(){ return this.d;}
}
class C extends B{
    protected String s = "prova";
    String getS(){ return this.s;}
} 
public class ObjLayout{
    public static void main(String[] s){
    	A a = new A(); 
    	B b = new B(); // b,c usabili come se fossero di B
    	C c = new C(); // a,b,c usabili come se fossero di A
    	int v = a.getI() + b.getI() + c.getI(); // 3
    	double w = b.getD() + c.getD(); 	// 0.6
    	A a2 = b; // assegnamenti consentiti
    	A a3 = c; // assegnamenti consentiti
    	int v2 = a.getI() + a2.getI() + a3.getI(); // 3
    	System.out.println(v+" "+w+" "+v2);
    	Object o = new Object();
    	Object o2 = a; // everything is an Object
    }
}
