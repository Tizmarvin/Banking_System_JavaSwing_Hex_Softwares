package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalState extends JFrame implements ActionListener {
    String code;

    JLabel label1, label2, label3, label4;
    JButton exit;
    BalState(String code){
        this.code = code;

        //Bank logo
        ImageIcon img1 = new ImageIcon(ClassLoader .getSystemResource("icons/banklogo.png"));
        Image img2 = img1.getImage() .getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(150, 7, 95, 110);
        add(image);

        getContentPane().setBackground(new Color(49, 138, 173));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        label2 = new JLabel("Yinile Bank");
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(150,100,200,20);
        add(label2);

        label3 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD,15));
        label3.setBounds(20,130,300,20);
        add(label3);

        label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Conn conn1 = new Conn();
            ResultSet resultSet = conn1.statement.executeQuery("select * from signin where passcode = '"+code+"'");
            while (resultSet.next()){
                label3.setText("Account Number:  "+ resultSet.getString("account_no").substring(0,4) + "XXXXXXXX"+ resultSet.getString("account_no").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Conn conn1 = new Conn();
            ResultSet resultSet = conn1.statement.executeQuery("select * from bank where passcode = '"+code+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is R "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        exit = new JButton("Exit");
        exit.setBounds(20,500,100,25);
        exit.addActionListener(this);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.BLACK);
        add(exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new BalState("");
    }
}
