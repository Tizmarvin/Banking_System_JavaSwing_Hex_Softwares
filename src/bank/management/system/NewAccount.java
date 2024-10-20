package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
public class NewAccount extends JFrame implements ActionListener {

    JTextField textName, textSurname, textIdNum, textAddress, textCity, textPostal, textEmail, textCell, textTax;

    JDateChooser dateChooser;

    JComboBox<String> comboGender, comboMarital,comboIncome, comboEmploy;

    JLabel labelRef, labelBank, labelPg1, labelDetails, labelName, labelSurname, labelDOB, labelIdNum, labelGender, labelMarital, labelAddress , labelCity, labelPostal, labelEmail, labelCell, labelEmploy, labelIncome, labelTax;
    JButton next;
    Random ref = new Random();
    long first7 = (ref.nextLong() % 10000000L) + 2000000L;
    String first = String.valueOf(Math.abs(first7));
    NewAccount(){

        super("New Account Application Form");

        //Bank logo
        ImageIcon img1 = new ImageIcon(ClassLoader .getSystemResource("icons/banklogo.png"));
        Image img2 = img1.getImage() .getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(400, 10, 95, 110);
        add(image);

        //Application reference
        labelRef = new JLabel("Application Ref: " + first);
        labelRef.setForeground(Color.BLACK);
        labelRef.setFont(new Font("SansSerif", Font.BOLD, 15));
        labelRef.setBounds(660, 30, 650, 40);
        add(labelRef);

        //Bank title
        labelBank = new JLabel("YINILE BANK");
        labelBank.setForeground(Color.BLACK);
        labelBank.setFont(new Font("SansSerif", Font.BOLD, 29));
        labelBank.setBounds(350, 125, 450, 40);
        add(labelBank);

        //Page 1
        labelPg1 = new JLabel("Page 1");
        labelPg1.setFont(new Font("Arial", Font.BOLD, 12));
        labelPg1.setBounds(820, 3, 450, 40);
        add(labelPg1);

        //details heading
        labelDetails = new JLabel("PERSONAL DETAILS");
        labelDetails.setFont(new Font("Arial", Font.BOLD, 20));
        labelDetails.setBounds(350, 180, 450, 40);
        add(labelDetails);

        //First Name
        labelName = new JLabel("First Name(s): ");
        labelName.setFont(new Font("Arial", Font.BOLD, 18));
        labelName.setBounds(100, 220, 450, 35);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Arial", Font.PLAIN, 18));
        textName.setBounds(240, 220, 450, 35);
        add(textName);

        //Surname
        labelSurname = new JLabel("Surname: ");
        labelSurname.setFont(new Font("Arial", Font.BOLD, 18));
        labelSurname.setBounds(100, 260, 450, 35);
        add(labelSurname);

        textSurname = new JTextField();
        textSurname.setFont(new Font("Arial", Font.PLAIN, 18));
        textSurname.setBounds(240, 260, 450, 35);
        add(textSurname);

        //DOB
        labelDOB = new JLabel("Date of birth: ");
        labelDOB.setFont(new Font("Arial", Font.BOLD, 18));
        labelDOB.setBounds(100, 300, 450, 35);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
        dateChooser.setForeground(Color.DARK_GRAY);
        dateChooser.setBounds(240, 300, 450, 35);
        add(dateChooser);



        //ID No
        labelIdNum = new JLabel("ID Number: ");
        labelIdNum.setFont(new Font("Arial", Font.BOLD, 18));
        labelIdNum.setBounds(100, 340, 450, 35);
        add(labelIdNum);

        textIdNum = new JTextField();
        textIdNum.setFont(new Font("Arial", Font.PLAIN, 18));
        textIdNum.setBounds(240, 340, 450, 35);
        add(textIdNum);

        //Gender
        labelGender = new JLabel("Gender: ");
        labelGender.setFont(new Font("Arial", Font.BOLD, 18));
        labelGender.setBounds(100, 380, 450, 35);
        add(labelGender);

        String[] genderOptions = {"", "Male", "Female", "Other"};
        comboGender = new JComboBox<>(genderOptions);
        comboGender.setFont(new Font("Arial", Font.PLAIN, 18));
        comboGender.setBounds(240, 380, 450, 35);
        add(comboGender);

        //Marital Status
        labelMarital = new JLabel("Marital Status: ");
        labelMarital.setFont(new Font("Arial", Font.BOLD, 18));
        labelMarital.setBounds(100, 420, 450, 40);
        add(labelMarital);

        String[] maritalStatusOptions = {"","Single", "Married", "Divorced", "Widowed"};
        comboMarital = new JComboBox<>(maritalStatusOptions);
        comboMarital.setFont(new Font("Arial", Font.PLAIN, 18));
        comboMarital.setBounds(240, 420, 450, 40);
        add(comboMarital);

        //Address
        labelAddress = new JLabel("Home Address: ");
        labelAddress.setFont(new Font("Arial", Font.BOLD, 18));
        labelAddress.setBounds(100, 460, 450, 35);
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Arial", Font.PLAIN, 18));
        textAddress.setBounds(240, 460, 450, 35);
        add(textAddress);


        labelCity = new JLabel("City/Town: ");
        labelCity.setFont(new Font("Arial", Font.BOLD, 18));
        labelCity.setBounds(100, 500, 450, 35);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Arial", Font.PLAIN, 18));
        textCity.setBounds(240, 500, 450, 35);
        add(textCity);

        labelPostal = new JLabel("Postal Code: ");
        labelPostal.setFont(new Font("Arial", Font.BOLD, 18));
        labelPostal.setBounds(100, 540, 450, 35);
        add(labelPostal);

        textPostal = new JTextField();
        textPostal.setFont(new Font("Arial", Font.PLAIN, 18));
        textPostal.setBounds(240, 540, 450, 35);
        add(textPostal);


        //Email
        labelEmail = new JLabel("Email: ");
        labelEmail.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmail.setBounds(100, 580, 450, 35);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        textEmail.setBounds(240, 580, 450, 35);
        add(textEmail);

        //Phone
        labelCell = new JLabel("Phone Number: ");
        labelCell.setFont(new Font("Arial", Font.BOLD, 18));
        labelCell.setBounds(100, 620, 450, 35);
        add(labelCell);

        textCell = new JTextField();
        textCell.setFont(new Font("Arial", Font.PLAIN, 18));
        textCell.setBounds(240, 620, 450, 35);
        add(textCell);

        //Employment Status
        labelEmploy = new JLabel("Employment: ");
        labelEmploy.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmploy.setBounds(100, 650, 450, 40);
        add(labelEmploy);

        String[] employStatusOptions = {"","Employed", "Self Employed", "Unemployed", "Pensioner"};
        comboEmploy = new JComboBox<>( employStatusOptions);
        comboEmploy.setFont(new Font("Arial", Font.PLAIN, 18));
        comboEmploy.setBounds(240, 655, 450, 35);
        add(comboEmploy);

        //Monthly income
        labelIncome = new JLabel("Monthly Income: ");
        labelIncome.setFont(new Font("Arial", Font.BOLD, 18));
        labelIncome.setBounds(100, 680, 450, 40);
        add(labelIncome);

        String[] IncomeStatusOptions = {"","0 - R10 000", "R10 001 - R25 000", "R25 0001 - R50 000", "Above R50 000"};
        comboIncome = new JComboBox<>(IncomeStatusOptions);
        comboIncome.setFont(new Font("Arial", Font.PLAIN, 18));
        comboIncome.setBounds(240, 683, 450, 40);
        add(comboIncome);


        //Tax no.
        labelTax = new JLabel("Tax Number: ");
        labelTax.setFont(new Font("Arial", Font.BOLD, 18));
        labelTax.setBounds(100, 720, 450, 40);
        add(labelTax);

        textTax = new JTextField();
        textTax.setFont(new Font("Arial", Font.PLAIN, 18));
        textTax.setBounds(240, 720, 450, 40);
        add(textTax);

        //Next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.GRAY);
        next.setBounds(385, 760, 120, 40);
        next.addActionListener(this);
        add(next);


        //Content Pane
        getContentPane().setBackground (new Color(200, 240, 226));
        setLayout(null);
        setSize(900, 950);
        setLocation(380, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Appref = first;
        String name = textName.getText();
        String sName = textSurname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String idNo = textIdNum.getText();
        String gender = (String) comboGender.getSelectedItem();
        String marital = (String) comboMarital.getSelectedItem();
        String address = textAddress.getText();
        String city = textCity.getText();
        String code = textPostal.getText();
        String email = textEmail.getText();
        String phoneNo = textCell.getText();
        String employment = (String) comboEmploy.getSelectedItem();
        String income = (String) comboIncome.getSelectedItem();
        String taxNo = textTax.getText();

        try{
            if (name.isEmpty() || sName.isEmpty() || dob.isEmpty() || idNo.isEmpty() || gender == null || marital == null || address.isEmpty() || city.isEmpty() || code.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || employment == null || income == null || taxNo == null){
                JOptionPane.showMessageDialog(null,"Please fill in all fields");
            }else {
                Conn conn1 = new Conn();
                String u = "insert into signup values('"+Appref+"', '"+name+"', '"+sName+"', '"+dob+"', '"+idNo+"', '"+gender+"', '"+marital+"', '"+address+"', '"+city+"', '"+code+"', '"+email+"', '"+phoneNo+"', '"+employment+"', '"+income+"', '"+taxNo+"')";
                conn1.statement.executeUpdate(u);
                new NewAccount2(Appref);
                setVisible(false);
            }


        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args){
        new NewAccount();
    }
}
