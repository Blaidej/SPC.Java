/**
    This program demonstrates the SavingsAccount which extends BankAccount.
	It keeps track of the status of the account, whether it's active or 
	inactive. If the balance drops below $25, no more withdrawals may be made.
	It runs these methods along with a method to deduct a dollar each time 
	the withdrawals for the month have exceeded 4.
	
*/

public class SavingsAccount extends BankAccount
{
    
	private boolean status; // status of account being active or inactive
	//

	public SavingsAccount(double bal, double intRate, double mon)
    {
		
		super(bal, intRate, mon); //calling the super constructor
		//set status with an if or else statement
	}
	/**
        The withdraw method determines whether the account is inactive before a 
	    withdrawal is made. No withdrawals will be made if the account is 
		inactive. If criteria is met, It calls the superclass's withdrawal
		method.
        @param amount The amount to subtract from the balance field.
   */
	public void withdraw(double amount)
    {
		if(super.getBalance() < 25)
		{
			status = false;
			
		}else{
			super.withdraw(amount);
			status = true;
		}
		
    }
	/**
        The deposit method determines whether the account is inactive before a 
	    deposit is made. It calls the superclass to make a deposit into the 
		account.
        @param amount The amount to add to the balance field.
   */
	public void deposit(double amount)
    {
		if(super.getBalance() > 25)
		{	
			super.deposit(amount);
			
			if(super.getBalance() > 25){
				status = true;
			}
		}else{
			
			status = false;
		}
		
    }
	/**
        
		The monthlyprocess calls the superclass's getNumWithdrawals method to
		make sure there is a fee for more than 4 withdrawals. It then checks
		to see if the the account falls below $25 therefore becoming inactive.
        
   */
	
	public void monthlyprocess()
    {
		if (getNumWithdrawals() > 4){
			
			setMonthlyServiceCharges(getMonthlyServiceCharges() + 
			((getNumWithdrawals() - 4) *1));
	
		}if(getBalance() < 25){
			status = false;
		}
		
		
		
    }
	

}

