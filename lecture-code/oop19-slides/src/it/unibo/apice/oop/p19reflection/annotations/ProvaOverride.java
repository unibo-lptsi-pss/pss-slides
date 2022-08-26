package it.unibo.apice.oop.p19reflection.annotations;

import java.io.Serializable;

class A {
	public void esempioDiMetodo() {}
}

class B extends A {
	
	@Override
	public void esempioDiMetodo() {
		System.out.println("OK");
	}
}

@SuppressWarnings("serial")
public class ProvaOverride implements Serializable {

    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		int a = 10;
        new A().esempioDiMetodo();
    }

}
