public class CheckingAccount extends BankAccount {
    
    float overdraftLimit;
    
     public CheckingAccount(String id,float balance,float overdraftLimit){
    super(id,balance);
    this.overdraftLimit = overdraftLimit;
  }
  
  @Override
  public boolean canWithdraw(float amount){
    return balance - amount >= -overdraftLimit;
  }

}