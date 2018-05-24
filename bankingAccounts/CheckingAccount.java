/**
    This program demonstrates the CheckingAccount which extends BankAccount 
    and derived classes. It will add a checking clearing FEE of .15 by 
	overiding the superclass's withdraw method. It will also 
    concatenate the account number for appropriate display of the account
    number. 
*/

public class CheckingAccount extends BankAccount
{
    //sets the FEE of clearing a check
	private final static double FEE = .15;
   
    /**
		This Constructor sets the name of the owner's and the amount of 
		the bank account. All account numbers end with a "-10" so it is 
		concatenated with-in this method.
		@param name The owner of the account.
		@param amount The beginning balance.
	*/
    public CheckingAccount(String name, double amount)
    {
	   
	    super (name, amount);
		String acN = (getAccountNumber() + "-10");
	    
	   
    }
    /**
		The withdraw method overides the superclass withdraw method so 
		that the amount withdrawn gets a fee added to also be withdrawn.
		@param amount the balance
		@return the amount withdrawn including the checking clearing FEE.
	*/
	
    @Override
    public boolean withdraw(double amount)
    {
		
        return super.withdraw(amount + FEE);
    
    }
}
