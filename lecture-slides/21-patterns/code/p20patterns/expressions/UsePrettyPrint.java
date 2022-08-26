package it.unibo.apice.oop.p18patterns.expressions;

public class UsePrettyPrint {

	public static void main(String[] args) {
		
		Expression exp = new Expression.BinOp(Expression.Operation.SUM, 
				new Expression.BinOp(Expression.Operation.MUL,
						new Expression.Value(1.1),
						new Expression.Variable("x")
				),
				new Expression.BinOp(Expression.Operation.DIV,
						new Expression.Value(5.2),
						new Expression.Variable("y")
				));
		System.out.println(exp.accept(new PrettyPrintVisitor(),null));

	}

}
