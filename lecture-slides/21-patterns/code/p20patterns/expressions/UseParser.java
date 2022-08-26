package it.unibo.apice.oop.p18patterns.expressions;

import java.util.*;

public class UseParser {

	public static void main(String[] args) throws ParsingException{	
		Parser parser = new Parser("( 5 + x  * 3 + 5 )");
		Expression exp = parser.parse();
		Map<String,Double> map = new HashMap<>();
		map.put("x",10.0);
		map.put("y",5.0);
		PrettyPrintVisitor pp = new PrettyPrintVisitor();
		InterpreterVisitor in = new InterpreterVisitor();
		
		System.out.println("Exp: "+pp.visit(exp,null));
		System.out.println("Env: "+map);
		System.out.println("Res: "+in.visit(exp, map));
	}
}
/*
Exp: ((5.0+2.0)*(3.0+5.0))
Env: {y=5.0, x=10.0}
Res: 56.0
*/

