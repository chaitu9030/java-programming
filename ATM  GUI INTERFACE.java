import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Money Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Money Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal!");
        }
    }
}

public class ATMGUI {
    private BankAccount account;

    public ATMGUI(BankAccount account) {
        this.account = account;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("ATM");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("ATM Menu:");
        label.setBounds(160, 20, 100, 25);
        frame.add(label);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(100, 60, 200, 30);
        frame.add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit Cash");
        depositButton.setBounds(100, 100, 200, 30);
        frame.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw Cash");
        withdrawButton.setBounds(100, 140, 200, 30);
        frame.add(withdrawButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 180, 200, 30);
        frame.add(exitButton);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(100, 220, 200, 30);
        frame.add(balanceLabel);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceLabel.setText("Current Balance: " + account.getBalance());
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    account.deposit(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered!");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    account.withdraw(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered!");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        new ATMGUI(account);
    }
}
