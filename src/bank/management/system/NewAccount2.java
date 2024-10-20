package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class NewAccount2 extends JFrame implements ActionListener{

    JComboBox comboAccType, comboAccPurpose;

    JLabel labelAppRef, labelAppRef2, labelPg2, labelBank, labelAcc,labelAccType, labelPurpose, labelIncome, labelAccno, labelPass, labelCode, labelServices, labelExisting;
    JRadioButton buttonExist1, buttonExist2;
    String Appref;

    JCheckBox checkATM, checkInternet, checkMobile,checkEmail, checkSms, checkDeclare;
    JButton submit, cancel;

    NewAccount2( String first){

        super("New Account Application Form");

        //Bank logo
        ImageIcon img1 = new ImageIcon(ClassLoader .getSystemResource("icons/banklogo.png"));
        Image img2 = img1.getImage() .getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(400, 10, 95, 110);
        add(image);

        //Application Reference
        this.Appref = first;

        labelAppRef = new JLabel("Application Ref: ");
        labelAppRef.setFont(new Font("SansSerif", Font.BOLD, 15));
        labelAppRef.setBounds(660, 30, 650, 40);
        add(labelAppRef);

        labelAppRef2 = new JLabel(first);
        labelAppRef2.setFont(new Font("SansSerif", Font.BOLD, 15));
        labelAppRef2.setBounds(790, 30, 650, 40);
        add(labelAppRef2);


        //Page 2
        labelPg2 = new JLabel("Page 2");
        labelPg2.setFont(new Font("Arial", Font.BOLD, 12));
        labelPg2.setBounds(820, 3, 450, 40);
        add(labelPg2);

        //Bank title
        labelBank = new JLabel("YINILE BANK");
        labelBank.setForeground(Color.BLACK);
        labelBank.setFont(new Font("SansSerif", Font.BOLD, 29));
        labelBank.setBounds(350, 125, 450, 40);
        add(labelBank);

        //Account Details
        labelAcc = new JLabel("ACCOUNT DETAILS: ");
        labelAcc.setFont(new Font("Arial", Font.BOLD, 20));
        labelAcc.setBounds(350, 180, 450, 40);
        add(labelAcc);

        //Account Type
        labelAccType = new JLabel("Account Type: ");
        labelAccType.setFont(new Font("Arial", Font.BOLD, 18));
        labelAccType.setBounds(100, 220, 450, 35);
        add(labelAccType);

        String[] AccTypeStatusOptions = {"","Savings", "Business", "Current/Cheque", "Transmission"};
        comboAccType = new JComboBox<>(AccTypeStatusOptions);
        comboAccType.setFont(new Font("Arial", Font.PLAIN, 18));
        comboAccType.setBounds(240, 220, 450, 35);
        add(comboAccType);


        //Account Purpose
        labelPurpose = new JLabel("Purpose: ");
        labelPurpose.setFont(new Font("Arial", Font.BOLD, 18));
        labelPurpose.setBounds(100, 260, 450, 35);
        add(labelPurpose);

        String[] AccPurposeStatusOptions = {"","Personal", "Business", "Investment", "Other"};
        comboAccPurpose = new JComboBox<>(AccPurposeStatusOptions);
        comboAccPurpose.setFont(new Font("Arial", Font.PLAIN, 18));
        comboAccPurpose.setBounds(240, 260, 450, 35);
        add(comboAccPurpose);

        //Account Number
        labelIncome = new JLabel("Account Number: ");
        labelIncome.setFont(new Font("Arial", Font.BOLD, 18));
        labelIncome.setBounds(100, 300, 450, 35);
        add(labelIncome);

        labelAccno = new JLabel("12-Digit Account Number will be generated after sign up");
        labelAccno.setFont(new Font("Arial", Font.PLAIN, 18));
        labelAccno.setBounds(280, 300, 450, 35);
        add(labelAccno);

        //Passcode
        labelPass = new JLabel("Passcode: ");
        labelPass.setFont(new Font("Arial", Font.BOLD, 18));
        labelPass.setBounds(100, 340, 450, 35);
        add(labelPass);

        labelCode = new JLabel("4-Digit Passcode will be generated after sign up");
        labelCode.setFont(new Font("Arial", Font.PLAIN, 18));
        labelCode.setBounds(280, 340, 450, 35);
        add(labelCode);

        //Preferred Services
        labelServices = new JLabel("Preferred Services: ");
        labelServices.setFont(new Font("Arial", Font.BOLD, 18));
        labelServices.setBounds(100, 380, 200, 35);
        add(labelServices);

        checkATM = new JCheckBox("ATM Card");
        checkATM.setFont(new Font("Arial", Font.PLAIN, 16));
        checkATM.setBounds(100, 420, 200, 35);
        add(checkATM);

        checkInternet = new JCheckBox("Internet Banking");
        checkInternet.setFont(new Font("Arial", Font.PLAIN, 16));
        checkInternet.setBounds(300, 420, 200, 35);
        add(checkInternet);

        checkMobile = new JCheckBox("Mobile Banking");
        checkMobile.setFont(new Font("Arial", Font.PLAIN, 16));
        checkMobile.setBounds(100, 460, 200, 35);
        add(checkMobile);

        checkEmail = new JCheckBox("Email alerts");
        checkEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        checkEmail.setBounds(300, 460, 200, 35);
        add(checkEmail);

        checkSms = new JCheckBox("SMS alerts");
        checkSms.setFont(new Font("Arial", Font.PLAIN, 16));
        checkSms.setBounds(500, 420, 200, 35);
        add(checkSms);


        //Existing Account
        labelExisting = new JLabel("Existing Yinile Account: ");
        labelExisting.setFont(new Font("Arial", Font.BOLD, 18));
        labelExisting.setBounds(100, 510, 450, 35);
        add(labelExisting);

        buttonExist1 = new JRadioButton("Yes");
        buttonExist1.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonExist1.setBounds(360, 510, 100, 35);
        add(buttonExist1);

        buttonExist2 = new JRadioButton("No");
        buttonExist2.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonExist2.setBounds(500, 510, 100, 35);
        add(buttonExist2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonExist1);
        buttonGroup.add(buttonExist2);

        //Declaration
        checkDeclare = new JCheckBox("I hereby declare that the bank account application information provided is accurate and belongs to me.");
        checkDeclare.setFont(new Font("Arial", Font.PLAIN, 16));
        checkDeclare.setBounds(90, 560, 800, 60);
        add(checkDeclare);



        //Submit button
        submit = new JButton("SUBMIT APPLICATION");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.GRAY);
        submit.setBounds(250, 650, 190, 40);
        submit.addActionListener(this);
        add(submit);

        //Cancel button
        cancel = new JButton("CANCEL APPLICATION");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.GRAY);
        cancel.setBounds(450, 650, 190, 40);
        cancel.addActionListener(this);
        add(cancel);





        //Content Pane
        getContentPane().setBackground (new Color(200, 240, 226));
        setLayout(null);
        setSize(900, 750);
        setLocation(380, 60);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String acctype = (String) comboAccType.getSelectedItem();
        String accpurp = (String) comboAccPurpose.getSelectedItem();

        Random random = new Random();
        long first12 = 100000000000L + (Math.abs(random.nextLong()) % 900000000000L);
        String accno = "" + Math.abs(first12);

        int first4 = 1000 + random.nextInt(9000);
        String code = String.valueOf(first4);

        String serv = "";

        if (checkATM.isSelected()) {
            serv += "ATM Card, ";
        }if (checkInternet.isSelected()) {
            serv += "Internet Banking, ";
        }if (checkMobile.isSelected()) {
            serv += "Mobile Banking, ";
        }if (checkEmail.isSelected()) {
            serv += "Email Alerts, ";
        }if (checkSms.isSelected()) {
            serv += "SMS Alerts, ";
        }

        String existing = "";
        if (buttonExist1.isSelected()) {
            existing = "Yes";
        } else if (buttonExist2.isSelected()) {
            existing = "No";
        }

        String decl = (String) comboAccPurpose.getSelectedItem();

        try{
            if (acctype.isEmpty() || accpurp.isEmpty() || accno.isEmpty() || serv.isEmpty() || existing.isEmpty() || decl.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill in all fields");
            }else {
                Conn conn1 = new Conn();
                String u = "insert into signup2 values('"+Appref+"', '"+acctype+"', '"+accpurp+"', '"+accno+"','"+code+"', '"+serv+"', '"+existing+"', '"+decl+"')";
                String u2 = "insert into signin values('"+Appref+"', '"+accno+"', '"+code+"')";
                conn1.statement.executeUpdate(u);
                conn1.statement.executeUpdate(u2);
                JOptionPane.showMessageDialog(null, "Account Number: "+ accno + "\n Passcode: " + code);
                new Deposit(code);
                setVisible(false);
            }
            if (e.getSource()==cancel){
                System.exit(0);

            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NewAccount2("");
    }
}


