public abstract class Bank {
 
 public Bank(){

  }

  public boolean transfer(BankAccount sender,
                        BankAccount recipient,
                        float amount)throws BankException{
    
      sender.withdraw(amount);
      recipient.deposit(amount);
      
      return true;
  }

  public String toString(){
    return "represented by x bank";
  }
}