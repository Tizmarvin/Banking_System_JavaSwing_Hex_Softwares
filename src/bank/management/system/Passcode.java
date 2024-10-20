package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passcode extends JFrame implements ActionListener {
    JButton change, back;

    JLabel labelChange, labelNew, labelReent;
    JPasswordField pcode1, pcode2;
    String code;
    Passcode(String code){
        this.code = code;

        //ATM background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/withdrawal.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 700, 700);
        add(img);

        //Change Passcode
        labelChange = new JLabel("CHANGE YOUR PASSCODE");
        labelChange.setForeground(Color.BLACK);
        labelChange.setFont(new Font("SansSerif", Font.BOLD, 22));
        labelChange.setBounds(200, 230, 650, 40);
        img.add(labelChange);

        labelNew = new JLabel("New PASSCODE: ");
        labelNew.setForeground(Color.BLACK);
        labelNew.setFont(new Font("System", Font.BOLD, 16));
        labelNew.setBounds(120,300,150,35);
        img.add(labelNew);



        pcode1 = new JPasswordField();
        pcode1.setForeground(Color.BLACK);
        pcode1.setBounds(340,300,180,25);
        pcode1.setFont(new Font("Raleway", Font.BOLD,22));
        img.add(pcode1);

        labelReent = new JLabel("Re-Enter New PASSCODE: ");
        labelReent.setForeground(Color.BLACK);
        labelReent.setFont(new Font("System", Font.BOLD, 16));
        labelReent.setBounds(120,350,400,35);
        img.add(labelReent);

        pcode2 = new JPasswordField();
        pcode2.setForeground(Color.BLACK);
        pcode2.setBounds(340,350,180,25);
        pcode2.setFont(new Font("Raleway", Font.BOLD,22));
        img.add(pcode2);



        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.setBounds(79, 430, 120, 40);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        img.add(change);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(500, 430, 120, 40);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        img.add(back);



        getContentPane().setBackground(new Color(200, 240, 226));
        setLayout(null);
        setSize(700, 700);
        setLocation(380, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String code1 = pcode1.getText();
            String code2 = pcode2.getText();

            if (!code1.equals(code2)){
                JOptionPane.showMessageDialog(null,"Your entered Passcodes do not match");
                return;
            }
            if (e.getSource()==change){
                if (pcode1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New Passcode");
                    return;
                }
                if (pcode2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New Passcode");
                    return;
                }

                Conn conn1 = new Conn();
                String q1 = "update bank set passcode = '"+code1+"' where passcode = '"+code+"'";
                String q2 = "update signin set passcode = '"+code1+"' where passcode = '"+code+"'";
                String q3 = "update signup2 set passcode = '"+code1+"' where passcode = '"+code+"'";

                conn1.statement.executeUpdate(q1);
                conn1.statement.executeUpdate(q2);
                conn1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Passcode changed successfully");
                setVisible(false);
                new main_Class(code);

            } else if (e.getSource()==back) {
                new main_Class(code);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new Passcode("");
    }
}
