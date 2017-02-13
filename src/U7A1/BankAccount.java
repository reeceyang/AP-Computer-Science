// Reece Yang
//
// This class models a bank account.

package U7A1;

public class BankAccount
{
    private double balance;
    private int accountNumber;
    private static final double interestRate = 0.04;
    private static int lastAssignedAccountNumber = 100;

    public BankAccount()
    {
        balance = Math.random() * 1000;
        setAccountNumber();
    }

    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
        setAccountNumber();
    }

    private void setAccountNumber()
    {
        lastAssignedAccountNumber++;
        accountNumber = lastAssignedAccountNumber;
    }

    public String deposit(double amount)
    {
        if (amount <= 0)
        {
            return "Deposit Rejected";
        }
        balance += amount;
        return "Deposit Accepted";
    }

    public String withdraw(double amount)
    {
        if (amount > balance)
        {
            return "Withdrawal Denied - Insufficient Funds";
        }
        balance -= amount;
        return "Withdrawal Accepted";
    }

    public double calculateInterest()
    {
        return balance * (1 + interestRate);
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public static double getInterestRate()
    {
        return interestRate;
    }
}
