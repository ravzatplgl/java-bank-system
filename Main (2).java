import java.util.Random;

public class Main
{
	public static void main(String[] args) {
	    
	    Random rand = new Random();
	    BankAccount[] accounts = new BankAccount[20];
	    
	    for(int i=0; i < accounts.length; i++){
	        int type = rand.nextInt(3);
	        
	        if(type == 0){
	            accounts[i] = new  CheckingAccount("c" + 1,0,500);
	        }
	        else if(type == 1){
	            accounts[i] = new FXAccount("F"+1,0,0.6f);
	        }
	        else{
	            accounts[i] = new CheckingAccount("C"+1,0,300);
	        }
	    }
	    
	    for(int i = 0; i < accounts.length ; i++){
	        try {
	            int amount = rand.nextInt(401) + 100;
	            accounts[i].deposit(amount);
	        } catch (BankException e){
	            System.out.println(e);
	        }
	    }
	    
	    Bank[] banks = new Bank[3];
	    
	    banks[0] = new Bank() {
        public void transfer(BankAccount from, BankAccount to, int amount) throws BankException {
        from.withdraw(amount);
        to.deposit(amount);
        }
        
        @Override
        public String toString() {
        return "BasicBank";
        }
        };
        
	    banks[1] = new ComissionBank(0.1f);
	    banks[2] = new MinComissionBank(0.05f,20);
	    
	    for(int i = 0; i<100;i++){
	        int sender = rand.nextInt(20);
	        int receiver = rand.nextInt(20);
	        int bankIndex = rand.nextInt(3);
	        int amount = rand.nextInt(31) + 20;
	        
	        if(sender == receiver){
	            i--;
	            continue;
	        }
	        try {
	            banks[bankIndex].transfer(accounts[sender],accounts[receiver],amount);
	        }
	        catch (BankException e){
	            System.out.println(e);
	          }
	        }
	    
	    System.out.println("\n--- ACCOUNTS ---");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
        
        System.out.println("\n--- BANKS ---");
        for (Bank bank : banks) {
            System.out.println(bank);
        }
	}
}