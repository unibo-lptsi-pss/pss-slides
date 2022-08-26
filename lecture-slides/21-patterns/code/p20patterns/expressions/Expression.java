package it.unibo.apice.oop.p18patterns.expressions;

public interface Expression {
	
	/* 
	 * Interfaccia visitor per le espressioni:
	 * X è il tipo in input della funzione di visita
	 * Y è il tipo di ritorno della funzione di visita
	 */
	public static interface Visitor<X,Y>{
		Y visit(Expression exp,X arg); // Entry-point della visita
		Y visit(BinOp exp,X arg);
		Y visit(Value exp,X arg);
		Y visit(Variable exp,X arg);
	}
	
	/* 
	 * Metodo di accettazione del visitor:
	 * ogni expression lo deve implementare in modo
	 * da "accettare" la visita.
	 */
	<X,Y> Y accept(Visitor<X,Y> v, X arg);
	
	// enumerazione dei tipi di operazioni binarie
	enum Operation {
		
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
		public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg);
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
		public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg);
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
		public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg);
		}
	}

	
}
