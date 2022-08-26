package it.unibo.apice.oop.p18patterns.expressions;

class Token{
	
	public static enum Type { TVAL, TVAR, TOP, TLPAR, TRPAR};
	
	private final Type type;
	private final String content;
	
	public Token(Type type, String content) {
		super();
		this.type = type;
		this.content = content;
	}
	
	public Type getType() {
		return type;
	}
	public String getContent() {
		return content;
	}
}
