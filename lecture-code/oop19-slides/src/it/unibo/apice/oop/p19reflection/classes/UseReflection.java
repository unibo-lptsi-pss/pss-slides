package it.unibo.apice.oop.p19reflection.classes;

public class UseReflection {
	
	private static Object callGetter(Object receiver, String getterName) throws Exception {
		return receiver.getClass().getMethod(getterName).invoke(receiver);	
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(callGetter("prova","isEmpty"));
		System.out.println(callGetter(new java.util.Date(),"getDate"));
		System.out.println(callGetter(new Object(),"hashCode"));
		
		class A{
			public void createDialog() { 
				javax.swing.JOptionPane.showMessageDialog(null, "It worked!");
			}
		}
		System.out.println(callGetter(new A(),"createDialog"));
		//System.out.println(callGetter(new A(),"createDial"));
	}
}
