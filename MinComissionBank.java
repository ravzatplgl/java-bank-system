public class MinComissionBank extends Bank {
    
    float comissionRate;
    float minComission;
    float balance;
    
    public MinComissionBank(float comissionRate,float minComission){
        this.comissionRate = comissionRate;
        this.minComission = minComission;
        this.balance = 0;
    }
    
  @Override  
  public boolean transfer(BankAccount sender,
                        BankAccount recipient,
                        float amount)throws BankException{
    float comission = amount * comissionRate;
    if(comission < minComission){
        comission = minComission;
    }
    sender.withdraw(amount + comission);
    recipient.deposit(amount);
    balance = balance + comission;
    
    return true;
  }
    
    @Override
    public String toString(){
        return "bank has e comissionRate of " + comissionRate + " and has a minComission" + 
        minComission + " and has a balance of " + balance;
    }
}