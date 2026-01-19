public class ComissionBank extends Bank {
    
    float comissionRate;
    float balance;
    
  public ComissionBank(float comissionRate){
    this.comissionRate = comissionRate;
    this.balance = 0;
  }
  
  @Override  
  public boolean transfer(BankAccount sender,
                        BankAccount recipient,
                        float amount)throws BankException{
                            
    float comission = amount * comissionRate;
    
    sender.withdraw(amount + comission);
    recipient.deposit(amount);
    balance = balance + comission;
    
    return true;
  }    
  
  @Override  
  public String toString(){
    return "bank has comissionRate of " + comissionRate + " balance of bank " + balance;
    }
}