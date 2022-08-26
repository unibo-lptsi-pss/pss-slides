package it.unibo.apice.oop.p18patterns.expressions;

import java.util.*;

/* 
 * Visitor che interpreta e produce un risultato per la espressione
 * Accetta la mappa variabile->valore, e torna il risultato finale
 */

public class InterpreterVisitor 
			implements Expression.Visitor<Map<String,Double>,Double>{
	
	@Override
	public Double visit(Expression exp, Map<String, Double> arg) {
		return exp.accept(this,arg);
	}
	@Override
	public Double visit(Expression.BinOp exp, Map<String, Double> arg) {
		double d1 = visit(exp.getLeft(), arg);
		double d2 = visit(exp.getRight(),arg);
		switch (exp.getOperation()){
			case SUM: return d1+d2;
			case SUB: return d1-d2;
			case MUL: return d1*d2;
			default: return d1/d2;
		}
	}
	@Override
	public Double visit(Expression.Value exp, Map<String, Double> arg) {
		return exp.getValue();
	}
	@Override
	public Double visit(Expression.Variable exp, Map<String, Double> arg) {
		return arg.get(exp.getVariable());
	}
}
