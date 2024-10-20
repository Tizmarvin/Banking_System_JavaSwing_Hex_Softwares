package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {

    String code;
    JLabel labelCurrent, labelAmnt;
    JButton back;
    Balance(String code){
        this.code = code;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/withdrawal.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 700, 700);
        add(img);

        labelCurrent = new JLabel("Your Current Balance is ");
        labelCurrent.setForeground(Color.BLACK);
        labelCurrent.setFont(new Font("System", Font.BOLD, 20));
        labelCurrent.setBounds(250,220,700,35);
        img.add(labelCurrent);

        labelAmnt = new JLabel();
        labelAmnt.setForeground(Color.BLACK);
        labelAmnt.setFont(new Font("System", Font.BOLD, 20));
        labelAmnt.setBounds(340,280,400,35);
        img.add(labelAmnt);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBackground(Color.GRAY);
        back.setBounds(500, 430, 120, 40);
        back.addActionListener(this);
        img.add(back);

        int balance =0;
        try{
            Conn conn1 = new Conn();
            ResultSet resultSet = conn1.statement.executeQuery("Select * from bank where passcode = '"+code+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        labelAmnt.setText("R "+balance);

        getContentPane().setBackground(new Color(200, 240, 226));
        setLayout(null);
        setSize(700, 700);
        setLocation(380, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(code);
    }

    public static void main(String[] args) {
        new Balance("");
    }
}
