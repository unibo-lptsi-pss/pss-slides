package it.unibo.apice.oop.p21patterns.tmethod;

public abstract class BankAccount {
	private int amount;
	
	public BankAccount(int amount){
		this.amount = amount;
	}
	
	public abstract int operationFee(); // costo bancario operazione
	
	public int getAmount(){
		return this.amount;
	}
	
	public void withdraw(int n){	// template method
		this.amount = this.amount - n - this.operationFee();
	}
	// main di prova
	public static void main(String[] args){
		final BankAccount b = new BankAccount(100){
			public int operationFee(){ return 1; }
		};
		b.withdraw(20);
		System.out.println(b.getAmount());// 79
	}
}
