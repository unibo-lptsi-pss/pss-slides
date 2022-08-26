package it.unibo.apice.oop.p18patterns.expressions;

/* Incapsula la creazione degli elementi del linguaggio
 * Pattern: singleton + method factory + facade
 * Facade: una classe (spesso singleton) che fornisce
 * una interfaccia "semplificativa" per una molteplicità
 * di classi e oggetti sottostanti
 */
class ExpressionMaker{
	// singleton
	private static final ExpressionMaker ONE = new ExpressionMaker();
	private ExpressionMaker(){}
	public static ExpressionMaker getMaker(){
		return ONE;
	}
	// factory methods + facade
	Expression makeValue(String s){
		return new Expression.Value(Double.parseDouble(s));
	}
	
	Expression makeVariable(String s){
		return new Expression.Variable(s);
	}
		
	Expression.BinOp makeBinOp(Expression.Operation op, Expression left, Expression right){
		return new Expression.BinOp(op,left,right);
	}
	
}
