package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String code;

    JLabel labelamnt;
    JTextField amnt;

    JButton depo, back;

    Deposit(String code) {
        this.code = code;

        labelamnt = new JLabel("ENTER DEPOSIT AMOUNT");
        labelamnt.setFont(new Font("SansSerif", Font.BOLD, 22));
        labelamnt.setBounds(200, 250, 650, 40);
        add(labelamnt);

        amnt = new JTextField();
        amnt.setFont(new Font("SansSerif", Font.BOLD, 22));
        amnt.setBounds(193, 300, 300, 30);
        add(amnt);

        //Deposit button
        depo = new JButton("DEPOSIT");
        depo.setFont(new Font("Raleway", Font.BOLD, 14));
        depo.setBackground(Color.GRAY);
        depo.setBounds(79, 430, 120, 40);
        depo.addActionListener(this);
        add(depo);


        //Cancel
        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBackground(Color.GRAY);
        back.setBounds(500, 430, 120, 40);
        back.addActionListener(this);
        add(back);


        //ATM background
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
        String amount = amnt.getText();
        Date date = new Date();

        try {
            if (e.getSource() == depo){
                if (amnt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount to deposit");
                }else{
                    Conn conn1 = new Conn();
                    conn1.statement.executeUpdate("insert into bank values('" + code + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "You have successfully deposited R" + amount + " into your account.");
                    setVisible(true);
                 }
            } else if (e.getSource() == back) {
                new main_Class(code);
                setVisible(false);
            }

        } catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Deposit("");
    }
}