public interface Expression {
	public static interface Visitor<X,Y>{
		Y visit(Expression exp,X arg);
		Y visit(BinOp exp,X arg);
		Y visit(Value exp,X arg);
		Y visit(Variable exp,X arg);
	}
	<X,Y> Y accept(Visitor<X,Y> v, X arg);
	
	public static class BinOp implements Expression{
		...
		public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg); // imposizione del dispatch
		}
	}
	public static class Value implements Expression{
	    ...
	    public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg); // imposizione del dispatch
		}
	}
	public static class Variable implements Expression{
	    ...		
	    public <X,Y> Y accept(Visitor<X,Y> v,X arg){
			return v.visit(this,arg); // imposizione del dispatch
		}
	}
}
 
