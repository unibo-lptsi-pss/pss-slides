package it.unibo.apice.oop.p18patterns.composite;

/* Expression è una interfaccia, che ha la enum Operation
 * e le le sottoclassi come proprietà inner statiche
 */
public interface Expression {
	
	// enumerazione dei tipi di operazioni binarie
	public static enum Operation {	
		SUM,SUB,MUL,DIV;
	}

	/* Inizio sotto-classi di expression */

	// Caso E ::= E bin-op E
	public static class BinOp implements Expression{
		final private Expression left;
		final private Expression right;
		final private Operation op;
		public BinOp(Operation op, Expression left, Expression right) {
			super();
			this.op = op;
			this.left = left;
			this.right = right;
		}
		public Operation getOperation(){
			return op;
		}
		public Expression getLeft() {
			return left;
		}
		public Expression getRight() {
			return right;
		}
		@Override
		public String toString() {
			return "BinOp [op=" + op + ", left=" + left + ", right=" + right
					+ "]";
		}
		
	}
	
	// Caso E ::= value
	public static class Value implements Expression{
		final private double value;

		public Value(double value) {
			super();
			this.value = value;
		}
		public double getValue() {
			return value;
		}
		@Override
		public String toString() {
			return "Value [value=" + value + "]";
		}	
	}	
	// Caso E ::= variable
	public static class Variable implements Expression{
		final private String variable;

		public Variable(String variable) {
			super();
			this.variable = variable;
		}
		public String getVariable() {
			return variable;
		}
		@Override
		public String toString() {
			return "Variable [variable=" + variable + "]";
		}
	}
}
