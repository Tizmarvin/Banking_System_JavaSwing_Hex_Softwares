package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;


public class Signin extends JFrame implements ActionListener {

    JLabel labelWel, labelAcc, labelPcode;
    JTextField textAcc;
    JPasswordField pcodefield;
    JButton button1, buttonOpen, buttonReent;

    Signin() {
        super("Banking System");

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        // Welcome Label
        labelWel = new JLabel("YINILE BANK WELCOMES YOU");
        labelWel.setForeground(Color.BLACK);
        labelWel.setFont(new Font("SansSerif", Font.BOLD, 29));
        labelWel.setBounds(200, 125, 450, 40);
        add(labelWel);

        // Account Number Label
        labelAcc = new JLabel("Account No: ");
        labelAcc.setForeground(Color.BLACK);
        labelAcc.setFont(new Font("AvantGarde", Font.BOLD, 19));
        labelAcc.setBounds(220, 200, 450, 40);
        add(labelAcc);

        // Account Number Field
        textAcc = new JTextField(11);
        textAcc.setForeground(Color.BLACK);
        textAcc.setFont(new Font("AvantGarde", Font.PLAIN, 19));
        textAcc.setBounds(340, 200, 280, 35);
        add(textAcc);

        // Passcode Label
        labelPcode = new JLabel("Passcode: ");
        labelPcode.setForeground(Color.BLACK);
        labelPcode.setFont(new Font("AvantGarde", Font.BOLD, 19));
        labelPcode.setBounds(220, 250, 280, 35);
        add(labelPcode);

        // Passcode Field
        pcodefield = new JPasswordField(11);
        pcodefield.setForeground(Color.BLACK);
        pcodefield.setFont(new Font("AvantGarde", Font.PLAIN, 19));
        pcodefield.setBounds(340, 250, 280, 35);
        add(pcodefield);

        // Sign In Button
        button1 = new JButton("Sign In");
        button1.setForeground(Color.BLACK);
        button1.setFont(new Font("AvantGarde", Font.BOLD, 15));
        button1.setBounds(280, 300, 120, 40);
        button1.setBackground(Color.DARK_GRAY);
        button1.addActionListener(this);
        add(button1);

        // Open New Account Button
        buttonOpen = new JButton("Open New Account");
        buttonOpen.setForeground(Color.BLACK);
        buttonOpen.setFont(new Font("AvantGarde", Font.BOLD, 15));
        buttonOpen.setBounds(310, 350, 190, 40);
        buttonOpen.setBackground(Color.DARK_GRAY);
        buttonOpen.addActionListener(this);
        add(buttonOpen);

        // Re-enter Button
        buttonReent = new JButton("Re-enter");
        buttonReent.setForeground(Color.BLACK);
        buttonReent.setFont(new Font("AvantGarde", Font.BOLD, 15));
        buttonReent.setBounds(410, 300, 120, 40);
        buttonReent.setBackground(Color.DARK_GRAY);
        buttonReent.addActionListener(this);
        add(buttonReent);

        // Background Image
        ImageIcon imgg1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginbackground.png"));
        Image imgg2 = imgg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon imgg3 = new ImageIcon(imgg2);
        JLabel background = new JLabel(imgg3);
        background.setBounds(0, 0, 850, 480);
        add(background);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {

                String accno = textAcc.getText();
                String code = new String(pcodefield.getPassword());

                if (accno.isEmpty() || code.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Account Number and Passcode.");
                    return;
                }

                Conn conn1 = new Conn();

                String query = "SELECT * FROM signin WHERE account_no =? AND passcode =?";
                PreparedStatement pstmt = conn1.getConnection().prepareStatement(query);
                pstmt.setString(1, accno);
                pstmt.setString(2, code);

                ResultSet resultSet = pstmt.executeQuery();


                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(code);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Account Number or PIN");
                }

            } else if (e.getSource() == buttonOpen) {
                new NewAccount();
                setVisible(false);
            } else if (e.getSource() == buttonReent) {
                textAcc.setText("");
                pcodefield.setText("");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Signin();
    }
}
