package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JLabel transact;
    JButton pcode, balance, depo, withdraw, statement, exit;
    String code;

    main_Class(String code) {
        this.code = code;

        setTitle("YINILE BANK - MAIN MENU");

        transact = new JLabel("What would you like to do?");
        transact.setFont(new Font("SansSerif", Font.BOLD, 24));
        transact.setBounds(180, 140, 350, 40);
        add(transact);

        // Deposit button
        depo = new JButton("DEPOSIT");
        depo.setFont(new Font("Raleway", Font.BOLD, 14));
        depo.setBackground(Color.GRAY);
        depo.setBounds(79, 284, 170, 40);
        depo.addActionListener(this);
        add(depo);

        // Withdraw button
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBackground(Color.GRAY);
        withdraw.setBounds(450, 284, 170, 40);
        withdraw.addActionListener(this);
        add(withdraw);

        // Change Passcode button
        pcode = new JButton("CHANGE PASSCODE");
        pcode.setFont(new Font("Raleway", Font.BOLD, 14));
        pcode.setBackground(Color.GRAY);
        pcode.setBounds(79, 360, 170, 40);
        pcode.addActionListener(this);
        add(pcode);

        // Balance button
        balance = new JButton("CHECK BALANCE");
        balance.setFont(new Font("Raleway", Font.BOLD, 14));
        balance.setBackground(Color.GRAY);
        balance.setBounds(450, 360, 170, 40);
        balance.addActionListener(this);
        add(balance);

        // Statement button
        statement = new JButton("GET STATEMENT");
        statement.setFont(new Font("Raleway", Font.BOLD, 14));
        statement.setBackground(Color.GRAY);
        statement.setBounds(79, 430, 170, 40);
        statement.addActionListener(this);
        add(statement);

        // Exit button
        exit = new JButton("EXIT");
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setBackground(Color.GRAY);
        exit.setBounds(450, 430, 170, 40);
        exit.addActionListener(this);
        add(exit);

        // ATM background
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
        if (e.getSource()==depo){
            new Deposit(code);
            setVisible(false);
        }else if (e.getSource()==exit){
            System.exit(0);
            setVisible(false);
        }else if (e.getSource()==withdraw) {
            new Withdraw(code);
            setVisible(false);
        }else if (e.getSource()==balance) {
            new Balance(code);
            setVisible(false);
        } else if (e.getSource()==pcode) {
            new Passcode(code);
            setVisible(false);
        } else if (e.getSource()==statement){
            new BalState(code);
        }

        }

    public static void main(String[] args) {
        new main_Class("");
    }
}
