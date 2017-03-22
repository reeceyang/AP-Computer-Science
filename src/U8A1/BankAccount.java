// Reece Yang
//
// This class models a bank account.

package U8A1;

public class BankAccount implements Measurable
{
    private double balance;
    private String accountNumber;
    private String accountType;
    private static final double interestRate = 0.04;

    public BankAccount(String accountNum, double initialBalance)
    {
        balance = initialBalance;
        accountNumber = accountNum;
        setAccountType();
    }

    private void setAccountType()
    {
        accountType = accountNumber.substring(3);
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

    public void calculateInterest()
    {
        if (accountType.equals("s"))
        {
            balance = balance * (1 + interestRate);
        }
    }

    public String getAccountType()
    {
        return accountType;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getMeasure()
    {
        return balance;
    }

    public static double getInterestRate()
    {
        return interestRate;
    }
}
