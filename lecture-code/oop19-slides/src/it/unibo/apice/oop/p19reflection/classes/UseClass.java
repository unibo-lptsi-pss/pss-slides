package it.unibo.apice.oop.p19reflection.classes;

public class UseClass {
	public static void main(String[] args) throws ClassNotFoundException {
		final Class<String> c = String.class;
		System.out.println(c.getName()+" "+c.getCanonicalName());
		//java.lang.String java.lang.String
		final Class<Integer> ci = (Class<Integer>)new Integer(5).getClass();
		System.out.println(ci.getName()+" "+ci.getCanonicalName());
		//java.lang.Integer java.lang.Integer
		final Class<?> ca = new int[20].getClass();
		System.out.println(ca.getName()+" "+ca.getCanonicalName());
		//[I int[]
		final Class<?> cint = ca.getComponentType();
		System.out.println(cint.getName()+" "+cint.getCanonicalName());
		//int int
		final Class<?> cl = Class.forName("java.util.List");
		System.out.println(cl.getName()+" "+cl.getCanonicalName());
		//java.util.List java.util.List
		final Class<?> can = new Object(){
			public String toString(){ return "none";}
		}.getClass();
		System.out.println(can.getName()+" "+can.getCanonicalName());
		//it.unibo.apice.oop.p19reflection.UseClass$1 null	
	}
}
