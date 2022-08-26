package it.unibo.apice.oop.p21patterns.tmethod.aula;

public abstract class AbstractBankAccount implements BankAccount {
    
    private int currentAmount;
    
    public AbstractBankAccount(int currentAmount) {
        super();
        this.currentAmount = currentAmount;
    }

    
    @Override
    public void withdraw(int n) {
        int newAmount = this.currentAmount - n - this.getTax(this.currentAmount);
        if (newAmount<0){
            throw new IllegalStateException();
        }
        this.currentAmount = newAmount;
    }
    
    protected abstract int getTax(int currentAmount);
}
