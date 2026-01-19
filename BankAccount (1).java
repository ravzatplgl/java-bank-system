public abstract class BankAccount {
    
    String id;
    float balance;

    public BankAccount(String id, float balance){
        this.id = id;
        this.balance = balance;
    }
    
    public void deposit(float amount) throws BankException {
        if(amount <= 0){
            throw new BankException(
                this.getClass().getSimpleName(),
               " you can not deposit, amount is negative "
                );
        }
        balance = balance + amount ;
    }
    
    public void withdraw(float amount) throws BankException {
        if(amount <= 0){
            throw new BankException(
                this.getClass().getSimpleName(),
                "you can not withdraw money because amount is negative "
                );
        }
        
        if(!canWithdraw(amount)){
            throw new BankException(
                this.getClass().getSimpleName(),
                "you can not withdraw money because insufficient balance"
                );
        }
        balance = balance - amount ;
    }
    
    public boolean canWithdraw(float amount){
        return balance >= amount ;
    }
    
    public String toString(){
        return  id + " : has a balance of " + balance ;
    }
    
}