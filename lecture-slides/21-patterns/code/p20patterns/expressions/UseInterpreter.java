package it.unibo.apice.oop.p18patterns.expressions;

import java.util.*;

public class UseInterpreter {

	public static void main(String[] args) {
		// (1.1 * x) + (5.2 * y)
		Expression exp = new Expression.BinOp(Expression.Operation.SUM, 
				new Expression.BinOp(Expression.Operation.MUL,
						new Expression.Value(1.1),
						new Expression.Variable("x")
				),
				new Expression.BinOp(Expression.Operation.DIV,
						new Expression.Value(5.2),
						new Expression.Variable("y")
				));
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
