package it.unibo.apice.oop.p18patterns.expressions;

import java.util.*;
import static it.unibo.apice.oop.p18patterns.expressions.Expression.Operation.*;

/*
 * Ha il compito di creare l'albero Expression a partire dalla stringa in ingresso
 * Utilizza uno scanner per dividire la stringa in pezzi, e un tokenizer per riottenere
 * i token.
 */

public class Parser {

	final private Scanner scanner;
	final private Tokenizer tokenizer;

	public Parser(String s) {
		this.scanner = new Scanner(s);
		this.tokenizer = new Tokenizer(this.scanner);
	}

	// Exp ::= AddExp
	public Expression parse() throws ParsingException {
		Expression exp = parseAdditive();
		try{
			Token t = this.tokenizer.readNextToken();
			if (t!=null){
				throw new ParsingException("Parsing over before string ended");
			}
			return exp;
		} catch (TokenizingException e){
			throw new ParsingException("Parsing over before string ended");
		}
	}

	// AddExp ::= MulExp { +|- MulExp }
	public Expression parseAdditive() throws ParsingException {
		try{
			Expression exp = parseMultiplicative();
			Token t = this.tokenizer.readNextToken();
			while (t!=null && t.getType() == Token.Type.TOP){
				Expression.Operation op = this.tokenizer.getOperationFromSymbol(t.getContent());
				if (op != SUM && op != SUB){
					break;
				}
				this.tokenizer.consumeNextToken();
				exp = ExpressionMaker.getMaker().makeBinOp(op,exp,parseMultiplicative());
				t = this.tokenizer.readNextToken();
			}
			return exp;
		} catch (Exception e){
			throw new ParsingException(e.getMessage());
		}
	}
	
	// MulExp ::= AtomicExp { *|/ AtomicExp }
	public Expression parseMultiplicative() throws ParsingException {
		try{
			Expression exp = parseAtomic();
			Token t = this.tokenizer.readNextToken();
			while (t!=null && t.getType() == Token.Type.TOP){
				Expression.Operation op = this.tokenizer.getOperationFromSymbol(t.getContent());
				if (op != MUL && op != DIV){
					break;
				}
				this.tokenizer.consumeNextToken();
				exp = ExpressionMaker.getMaker().makeBinOp(op,exp,parseAtomic());
				t = this.tokenizer.readNextToken();
			}
			return exp;
		} catch (Exception e){
			throw new ParsingException(e.getMessage());		}
	}

	// AtomicExp ::= Val | Var | (Exp)
	public Expression parseAtomic() throws ParsingException {
		try {
			Token t = this.tokenizer.readNextToken();
			switch (t.getType()) {
			case TLPAR:
				this.tokenizer.consumeNextToken();
				Expression exp = parseAdditive();
				if (this.tokenizer.readNextToken().getType()!= Token.Type.TRPAR){
					throw new ParsingException("Expected ')' instead of "+t.getContent());
				}
				this.tokenizer.consumeNextToken();
				return exp;
			case TVAL:
				return ExpressionMaker.getMaker().makeValue(
						this.tokenizer.consumeNextToken().getContent());
			case TVAR:
				return ExpressionMaker.getMaker().makeVariable(
						this.tokenizer.consumeNextToken().getContent());
			default:
				throw new ParsingException("Expected value or variable instead of "+t.getContent());
			}
		} catch (Exception e) {
			throw new ParsingException(e.getMessage());		}
	}
}
