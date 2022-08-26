package it.unibo.apice.oop.p21patterns.builder;

import java.util.Arrays;
import java.util.List;

/*
 * StringBuilder is an optimised builder of (immutable) strings
 * StringBuffer is to be used if thread safety is needed
 */

public class UseStringBuilder {

	public static void main(String[] args) {
	    
	    List<Integer> l = Arrays.asList(10,20,30,40,50,60);
	    String s = "[";
	    for (int i: l){
	        s = s + i + ";";
	    }
	    s = s + "]";
	    System.out.println(s);
	    
		
		final StringBuilder sb = new StringBuilder();
		sb.append("Costruzione di stringa :");
		sb.append(10);
		sb.append(20);
		sb.append(30);
		sb.append(40);
		sb.append(50);
        String s2 = sb.toString();			 
		System.out.println(s2);
	}

}
