/**
    This program demonstrates the SavingsAccount which extends BankAccount.
	It allows for mutliple savings accounts for each individual, identified 
	by the number following the dash (-#) including incrementing that number.
	It will also perform a monthly deposit based on an annual interest rate.
	
*/

public class SavingsAccount extends BankAccount
{
    private double rate = .025; //sets the annual 2.5% interest rate. 
   
    //starts the savings number at 0 for the each user to have several 
	//seperate accounts
    private int savingsNumber = 0;
	
    //sets up the account number to hide from the superclass
    private String accountNumber; 
   
    /**
	
		This Constructor sets the name of the owner's and the amount of 
		the bank account. It then concatenates the savingsNumber for each
		of a specific user's number.
		@param name The owner of the account.
		@param amount The balance in account.
		
		
	*/
    public SavingsAccount(String name, double amount)
    {
	
		super(name, amount);
		 
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
		
    }
   
    /**
		
		This Class sets the name of the owner's and the amount of 
		the bank account. It then concatenates the savingsNumber for each
		of a specific user's account and increments it.
		@param oldAccount is the old savings account of an owner
		@param amount The balance in the account.
		
	*/
   
    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
       
        super(oldAccount, amount);
		
        savingsNumber++;
		
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	    
		
    }
	
	/**
		
		The post interest method will calculate one month's 
		worth of interest on the balance and deposit it into the account.
		
	*/
    
    public void postInterest()
    {
		
        double balance = super.getBalance();
		
        super.deposit(((balance * rate) * 1/12.0));
    
    }
    
	/**
	
		This method overrides the account number in the superclass.
		
	*/
   
    @Override
    public String getAccountNumber()
    {
	    
	return accountNumber;
	   
    }
   
   
  

}

