package it.unibo.apice.oop.p18patterns.composite;

import static it.unibo.apice.oop.p18patterns.composite.Expression.Operation.*; 

public class UseExpression {

	public static void main(String[] args) {
		// (1.1 * x) + (5.2 * y)
		Expression exp = new Expression.BinOp(SUM, 
				new Expression.BinOp(MUL,
						new Expression.Value(1.1),
						new Expression.Variable("x")
				),
				new Expression.BinOp(DIV,
						new Expression.Value(5.2),
						new Expression.Variable("y")
				));
		System.out.println(exp);
	}

}
