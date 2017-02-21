// Reece Yang
//
// This is a driver class for the BankAccount class.

package U7A2;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class u7a2 extends JFrame
{
    JTextArea out = new JTextArea();
    ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public u7a2()
    {
        BuildList();
        PrintList();

        Deposit("103s", 500);
        Withdraw("110s", 304.52);
        InsertNewAcct("105c", 300);
        DeleteDormantAccts();
        CorrectError("107s", 1113.88);
        ApplyInterest();
        InsertNewAcct("111s", 100);
        FileUpDated();
    }

    public void BuildList()
    {
        try
        {
            Scanner reader = new Scanner(new File("src/U7A2/myCreditUnion.txt"));
            while (reader.hasNext())
            {
                String inputLine = reader.nextLine();
                StringTokenizer st = new StringTokenizer(inputLine);
                String accountNumber = st.nextToken();
                double initialBalance = Double.parseDouble(st.nextToken());
                bankAccounts.add(new BankAccount(accountNumber, initialBalance));
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }

    public void PrintList()
    {
        out.append("Account#\tBalance\n");
        int size = bankAccounts.size();
        for (int i = 0; i < size; i++)
        {
            out.append(bankAccounts.get(i).getAccountNumber()
            	+ "\t"
            	+ String.format("$ %.2f", bankAccounts.get(i).getBalance())
            	+ "\n");
        }
        out.append("\n");
        Container container = getContentPane();
        container.add(out);
    }

    public void Deposit(String acctNum, double dep)
    {
        BankAccount bankAccount;
        try
        {
            bankAccount = getBankAccount(acctNum);
            bankAccount.deposit(dep);
        }
        catch (RuntimeException e)
        {
            out.append("Deposit Rejected\n");
        }
        out.append("Deposit Accepted\n");
    }

    public void Withdraw(String acctNum, double with)
    {
        BankAccount bankAccount;
        try
        {
            bankAccount = getBankAccount(acctNum);
            bankAccount.withdraw(with);
        }
        catch (RuntimeException e)
        {
            out.append("Withdrawal Rejected\n");
        }
        out.append("Withdrawal Accepted\n");
    }

    public BankAccount getBankAccount(String acctNum)
    {
        try
        {
            return bankAccounts.get(getBankAccountIndex(acctNum));
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException(e.toString());
        }
    }

    public int getBankAccountIndex(String acctNum)
    {
        int size = bankAccounts.size();
        for (int i = 0; i < size; i++)
        {
            if (bankAccounts.get(i).getAccountNumber().equals(acctNum))
            {
                return i;
            }
        }
        throw new RuntimeException("BankAccount not found\n");
    }

    public void InsertNewAcct(String acctNum, double initdep)
    {
        BankAccount newAccount = new BankAccount(acctNum, initdep);
        if (newAccount.getAccountType().equals("s"))
        {
            bankAccounts.add(newAccount);
            out.append("New Account Added\n");
        }
        else
        {
            try
            {
                int index = getBankAccountIndex(newAccount.getAccountNumber().replace("c", "s"));
                bankAccounts.add(index + 1, newAccount);
                out.append("New Account Added\n");
            }
            catch (RuntimeException e)
            {
                out.append("New Account Not Added\n");
            }
        }
    }

    public void DeleteDormantAccts()
    {
        int removedAccounts = 0;
        int size = bankAccounts.size();
        for (int i = 0; i < size; i++)
        {
            if (bankAccounts.get(i).getBalance() == 0)
            {
                bankAccounts.remove(i);
                removedAccounts++;
                i--;
                size--;
            }
        }
        out.append(removedAccounts + " Account(s) Removed\n");
    }

    public void CorrectError(String acctNum, double bal)
    {
        BankAccount bankAccount = getBankAccount(acctNum);
        bankAccount.withdraw(bankAccount.getBalance());
        bankAccount.deposit(bal);
        out.append("Correction Completed\n");
    }

    public void ApplyInterest()
    {
        int size = bankAccounts.size();
        for (int i = 0; i < size; i++)
        {
            bankAccounts.get(i).calculateInterest();
        }
        out.append("Interest Applied to all Savings Accounts\n");
    }

    public void FileUpDated()
    {
        try
        {
            FileWriter writer = new FileWriter("src/U7A2/temp.txt");
            PrintWriter out = new PrintWriter(writer);

            int size = bankAccounts.size();
            for (int i = 0; i < size; i++)
            {
                out.append(bankAccounts.get(i).getAccountNumber()
                	+ " "
                	+ String.format("%.2f", bankAccounts.get(i).getBalance())
                	+ "\n");
            }

            out.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
        out.append("File Updated");
    }

    public static void main(String[] args)
    {
        u7a2 u7A2 = new u7a2();
        u7A2.setSize(500, 500);
        u7A2.setVisible(true);
        u7A2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
