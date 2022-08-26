package it.unibo.apice.oop.p21patterns.strategy;

@FunctionalInterface
public interface BankOperationFees {
	
	int fee(int operationAmount);
}
