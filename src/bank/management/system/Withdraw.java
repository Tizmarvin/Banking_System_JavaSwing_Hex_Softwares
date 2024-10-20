
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    String code;
    TextField textWithdraw;

    JLabel labelMax, labelAmount;
    JButton buttonWithdraw, buttonBack;
    Withdraw(String code){

        this.code = code;

        labelMax = new JLabel("Note: Maximum withdrawal amount is R15 000");
        labelMax.setForeground(Color.RED);
        labelMax.setFont(new Font("System", Font.BOLD, 13));
        labelMax.setBounds(180,220,700,35);
        add(labelMax);

        labelAmount = new JLabel("PLEASE ENTER WITHDRAWAL AMOUNT:");
        labelAmount.setForeground(Color.BLACK);
        labelAmount.setFont(new Font("System", Font.BOLD, 16));
        labelAmount.setBounds(180,250,400,35);
        add(labelAmount);

        labelMax = new JLabel("(Multiples of R50)");
        labelMax.setForeground(Color.GRAY);
        labelMax.setFont(new Font("System", Font.BOLD, 13));
        labelMax.setBounds(270,265,700,35);
        add(labelMax);


        textWithdraw = new TextField();
        textWithdraw.setFont(new Font("SansSerif", Font.BOLD, 22));
        textWithdraw.setBounds(193, 300, 300, 30);
        add(textWithdraw);

        buttonWithdraw = new JButton("WITHDRAW");
        buttonWithdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonWithdraw.setBackground(Color.GRAY);
        buttonWithdraw.setBounds(79, 430, 120, 40);
        buttonWithdraw.addActionListener(this);
        add(buttonWithdraw);

        buttonBack = new JButton("BACK");
        buttonBack.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonBack.setBackground(Color.GRAY);
        buttonBack.setBounds(500, 430, 120, 40);
        buttonBack.addActionListener(this);
        add(buttonBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/withdrawal.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 700, 700);
        add(img);


        getContentPane().setBackground(new Color(200, 240, 226));
        setLayout(null);
        setSize(700, 700);
        setLocation(380, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonWithdraw) {
            try {
                String amount = textWithdraw.getText();
                Date date = new Date();
                if (textWithdraw.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Conn conn1 = new Conn();
                    ResultSet resultSet = conn1.statement.executeQuery("select * from bank where passcode = '" +code+ "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "You have Insufficient Funds");
                        return;
                    }

                    conn1.statement.executeUpdate("insert into bank values('" +code+ "', '" +date+ "', 'Withdrawal', '" +amount+ "' )");
                    JOptionPane.showMessageDialog(null, "R " +amount+ " Debited Successfully");
                    setVisible(false);
                    new main_Class(code);

                }
            } catch (Exception E) {

            }
        } else if (e.getSource()==buttonBack) {
            setVisible(false);
            new main_Class(code);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
