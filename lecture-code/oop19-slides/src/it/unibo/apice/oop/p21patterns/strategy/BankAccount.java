package it.unibo.apice.oop.p21patterns.strategy;

public class BankAccount {

	private final BankOperationFees fees;
	private int amount;

	public BankAccount(BankOperationFees fees, int amount) {
		this.fees = fees;
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public void withdraw(int n) { 
		this.amount = this.amount - n - this.fees.fee(n);
	}

	// main di prova
	public static void main(String[] args) {
		final BankOperationFees f = new StandardBankOperationFees();
		final BankAccount b = new BankAccount(f, 100);
		//final BankAccount b = new BankAccount(f, a -> a < 1000 ? 1 : 2);
		b.withdraw(20);
		System.out.println(b.getAmount());// 79
	}
}
