/*
	This program shows a threaded application for a bank account so operations
	don't happen where they would conflict with money being depositted or 
	withdrawn at the wrong time.
*/
public class ThreadedAccountDemo
{
	public static void main(String args[]) 
	{
		Account account = new Account();
		
		Deposit moneyIn =  new Deposit(account);
		
		Withdrawal moneyOut = new Withdrawal(account);
		try 
		{
			moneyIn.thrd.join();
			moneyOut.thrd.join();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Main thread Interrupted");
		}
		
	}
}

class Account 
{
	int balance;
	boolean flag = false;

	synchronized int withdraw() 
	{
		while(!flag)
		{
			try 
			{
				//System.out.println("withdraw waiting");
				wait();

			} 
			catch(InterruptedException e) 
			{
				System.out.println("InterruptedException caught");
			}
		}
		System.out.println("withdrawal: " + balance);
		flag = false;
		notify();
		return balance;
	}

	synchronized void deposit(int balance) 
	{
		while(flag)
		{
			try 
			{
				//System.out.println ("deposit waiting");
				wait();
			} 
			catch(InterruptedException e) 
			{
				System.out.println("InterruptedException caught");
			}
		}
		this.balance = balance;
		flag = true;
		System.out.println("deposit: " + balance);
		notify();
	}
}

class Deposit implements Runnable 
{
	Account account;
	Thread thrd;
	
	Deposit(Account account) 
	{
		this.account = account;
		thrd = new Thread(this, "Deposit");
		thrd.start();
	}

	public void run() 
	{
		int i = 0;

		while(i <= 10) 
		{
			account.deposit(i++);
		}
	}
}

class Withdrawal implements Runnable 
{
	Account account;
	Thread thrd;
	
	Withdrawal(Account account) 
	{
		this.account = account;
		thrd = new Thread(this, "Withdrawal");
		thrd.start();
	}

	public void run() 
	{
		int i = 0;
		while(i <= 10) 
		{
			account.withdraw();
			i++;
		}
	}
}
