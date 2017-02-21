// Reece Yang
//
// This is a client program for the BankAccount1 class.

package U7A1;

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;

public class U7A1 extends JApplet
{
    public void init()
    {
        setSize(500, 400);

        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.BOLD, 16));

        out.append("Account Information\n");
        out.append("-------------------\n");
        out.append("\n");

        BankAccount1 account1 = new BankAccount1();
        BankAccount1 account2 = new BankAccount1(1500);
        out.append("Initial Balance for Account "
                + account1.getAccountNumber()
                + " = "
                + String.format("$ %.2f", account1.getBalance())
                + "\n");
        out.append("Initial Balance for Account "
                + account2.getAccountNumber()
                + " = "
                + String.format("$ %.2f", account2.getBalance())
                + "\n");
        out.append("\n");

        out.append(account1.deposit(300) + "\n");
        out.append(account2.deposit(200) + "\n");
        out.append(account1.withdraw(250) + "\n");
        out.append(account2.withdraw(125) + "\n");

        account1.deposit(account1.calculateInterest() - account1.getBalance());
        account2.deposit(account2.calculateInterest() - account2.getBalance());

        String transferText = account1.withdraw(550);
        out.append(transferText + "\n");
        if (transferText.equals("Withdrawal Accepted"))
        {
            out.append(account2.deposit(550) + "\n");
        }
        else
        {
            out.append("Deposit Rejected\n");
        }

        account1.deposit(account1.calculateInterest() - account1.getBalance());
        account2.deposit(account2.calculateInterest() - account2.getBalance());

        out.append("\n");
        out.append("Final Balance for Account "
                + account1.getAccountNumber()
                + " = "
                + String.format("$ %.2f", account1.getBalance())
                + "\n");
        out.append("Final Balance for Account "
                + account2.getAccountNumber()
                + " = "
                + String.format("$ %.2f", account2.getBalance())
                + "\n");
        out.append("\n");

        out.append("Interest Rate = " + account1.getInterestRate() * 100 + " %");
        Container container = getContentPane();
        container.add(out);
    }
}
