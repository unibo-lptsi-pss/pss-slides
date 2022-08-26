package it.unibo.apice.oop.p21patterns.tmethod.aula;

public class BankAccountFixedTax extends AbstractBankAccount {

    public BankAccountFixedTax(int currentAmount) {
        super(currentAmount);
    }

    @Override
    protected int getTax(int currentAmount) {
        return 1;
    }

}
