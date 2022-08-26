package it.unibo.apice.oop.p18patterns.expressions;

import static it.unibo.apice.oop.p18patterns.expressions.Expression.Operation.*;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Ha il compito di produrre un token alla volta, consentendo
 * di osservarlo senza consumarlo
 */
class Tokenizer{
	
	static final private String[] strOps = new String[]{"+","-","*","/"};
	static final private Expression.Operation[] ops = new Expression.Operation[]{SUM,SUB,MUL,DIV};
	static final private Pattern PATT_OP = Pattern.compile("\\"+strOps[0]+"|\\"+strOps[1]+"|\\"+strOps[2]+"*|\\"+strOps[3]);
	static final private Pattern PATT_LPAR = Pattern.compile("\\(");
	static final private Pattern PATT_RPAR = Pattern.compile("\\)");
	static final private Pattern PATT_VAR = Pattern.compile("\\w*");
	
	private final Scanner scanner;
	private Token nextToken;
	
	public Tokenizer(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Token readNextToken() throws TokenizingException{
		if (this.nextToken == null){
			this.scanNextToken();
		}
		return this.nextToken;
	}
	
	public Token consumeNextToken() throws TokenizingException{
		Token t = this.readNextToken();
		this.nextToken = null;
		return t;
	}
	
	private void scanNextToken() throws TokenizingException {
		if (!scanner.hasNext()){
			this.nextToken = null;
		} else if (scanner.hasNext(PATT_LPAR)){
			this.nextToken = new Token(Token.Type.TLPAR,scanner.next(PATT_LPAR));
		} else if (scanner.hasNext(PATT_RPAR)){
			this.nextToken = new Token(Token.Type.TRPAR,scanner.next(PATT_RPAR));
		} else if (scanner.hasNext(PATT_OP)){
			this.nextToken = new Token(Token.Type.TOP,scanner.next(PATT_OP));
		} else if (scanner.hasNextDouble()){
			this.nextToken = new Token(Token.Type.TVAL,scanner.next());
		} else if (scanner.hasNext(PATT_VAR)){
			this.nextToken = new Token(Token.Type.TVAR,scanner.next(PATT_VAR));
		} else {
			throw new TokenizingException("Token "+scanner.next()+" unrecognised");
		}
	}
	
	public Expression.Operation getOperationFromSymbol(String s){
		for (int i=0; i<strOps.length; i++){
			if (strOps[i].equals(s)){
				return ops[i];
			}
		}
		return null;
		
	}
}
