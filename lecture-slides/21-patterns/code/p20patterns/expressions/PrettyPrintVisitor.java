package it.unibo.apice.oop.p18patterns.expressions;
import static it.unibo.apice.oop.p18patterns.expressions.Expression.Operation.*;

/* 
 * Visitor che crea una stringa dall'espressione, con
 * parentesi per disambiguare
 */

public class PrettyPrintVisitor 
			implements Expression.Visitor<Object,String>{
	@Override 
	public String visit(Expression exp, Object arg) {
		return exp.accept(this,arg);
	}
	@Override 
	public String visit(Expression.BinOp exp, Object arg) {
		return "("+visit(exp.getLeft(),arg) +
				(	exp.getOperation() == MUL ? "*" :
						exp.getOperation() == DIV ? "/" :
							exp.getOperation() == SUM ? "+" :
								exp.getOperation() == SUB ? "-" : "null"
				) +
				visit(exp.getRight(),arg)+")";
	}
	@Override 
	public String visit(Expression.Value exp, Object arg) {
		return ""+exp.getValue();
	}
	@Override 
	public String visit(Expression.Variable exp, Object arg) {
		return exp.getVariable();
	}
}
