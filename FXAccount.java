public class FXAccount extends BankAccount {
    
    float exchangeRate;
    
    public FXAccount(String id,float balance,float exchangeRate){
        super(id,balance);
        this.exchangeRate = exchangeRate;
    }
    
    @Override
    public void deposit(float amount) throws BankException {
        
        super.deposit(amount * exchangeRate);
    }
    
    @Override
    public void withdraw(float amount) throws BankException {
        
        super.withdraw(amount * exchangeRate);
    }
}