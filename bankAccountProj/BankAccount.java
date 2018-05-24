/**
   The BankAccount class has accesors and mutators for the SavingsDemo and 
   SavingsAccount to work with to be able to update the balance of a bank 
   account. It keeps track of the balance, number of deposits and withdrawals, 
   while also calculating the interest and monthly service charges.
*/

public class BankAccount
{
   
   
    private double balance; // Current balance in the account
	private int numDeposits; // number of deposits
	private int numWithdrawals; //number of withdrawals from account
	private double interestRate; //interest Rate for account
	private double monthlyServiceCharge; //monthly service charge
  

   /**
        Default constructor to recieve starting values passed as arguments.
		@param bal The starting balance of the account
		@param intRate The account's interest rate.
		@param mon The service charge per month getting charged to the account.
     */

   public BankAccount(double bal, double intRate, double mon)
   {
		balance = bal; 
		interestRate = intRate;
		monthlyServiceCharge = mon;
		//should initialize all of the fields
   } 

   /**
        Deposit adds money to the account. Increments the numDeposits
		counter to keep track of the amount of deposits.
        @param amount The amount to deposit in the account.
	*/

   public void deposit(double amount)
   {
        balance = balance + amount;
		numDeposits++;
   }
 
    /**
        Withdraw takes money out of the account. Increments the numWithdrawals
		counter to keep track of the amount of withdrawals.
        @param amount The amount to withdrawal from the account.
   */
    public void withdraw(double amount)
    {
        
        balance = balance - amount;
		numWithdrawals++;
       
    }
	
	/**
        calcInterest calculates the monthly interest earned by the account and
		adds it to the account balance.
    */

    private void calcInterest()
    {
		
		double monthlyInterestRate =(interestRate/12);//
		double monthlyInterest = balance*monthlyInterestRate;
		balance = balance + monthlyInterest; 
		
    }
	
	/**
        Monthly Process subtracts the monthly service charges from the balance.
		It calls the calcInterest method, and set the number of withdrawals,
		deposits, and monthly service charges all to 0.
    */

    public void monthlyProcess()
    {
		
		balance = balance - monthlyServiceCharge;
		calcInterest();
		numWithdrawals = 0;//resets number of withdrawals to 0.
		numDeposits = 0;//resets number of deposits to 0.
		monthlyServiceCharge = 0;//resets number of withdrawals to 0
		
    }
	
	/**
        Set Monthly service charge sets the amount to the amount
		to be charged.
		@param amount The amount of the monthly service charge.
     */

    public void setMonthlyServiceCharges(double amount)
    {
		
		monthlyServiceCharge = amount;
		
    }
	
    /**
        The getBalance method returns the account's balance.
        @return The value in the balance field.
     */

    public double getBalance()
    {
       return balance;
    }
	
	/**
        The getNumDeposits method returns number of deposits made into the 
		account.
        @return The number of deposits made.
    */

    public int getNumDeposits()
    { 
       return numDeposits;
    }
    
	/**
        The getNumWithdrawals method returns the number of withdrawals from the 
		account. 
        @return The number of withdrawals made.
    */

    public int getNumWithdrawals()
    { 
       return numWithdrawals;
    }
    
	/**
        The getInterestRate method returns the account's interest rate.
        @return The account's interest rate.
    */

    public double getInterestRate()
    { 
       return interestRate;
    }
	
	/**
        The getMonthlyServiceCharges method returns the monthly service charges 
		the account has.
        @return The account's monthly service charge.
    */

    public double getMonthlyServiceCharges()
    { 
       return monthlyServiceCharge;
    }
	
}