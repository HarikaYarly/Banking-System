/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    JLabel additionalDetails,name,fname,dob,gender,email,state,pincode,marital,pan,aadhar;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        additionalDetails=new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        name=new JLabel("Religion:");
        name.setFont(new Font("Railway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        

       


        fname=new JLabel("Category: ");
        fname.setFont(new Font("Railway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

       
        
        dob=new JLabel("Income: ");
        dob.setFont(new Font("Railway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[]={"Null","<1,50,000","<2,50,0000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        gender=new JLabel("Educational: ");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        
        email=new JLabel("Qualification: ");
        email.setFont(new Font("Railway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);

        String educationValues[]={"Non-Graduation","Graduate","post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
       
        marital=new JLabel("Occupation: ");
        marital.setFont(new Font("Railway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);

        String OccupationValues[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation=new JComboBox(OccupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
     
        pan=new JLabel("PAN Number: ");
        pan.setFont(new Font("Railway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Railway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        aadhar=new JLabel("Aadhar: ");
        aadhar.setFont(new Font("Railway",Font.BOLD,22));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Railway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        state=new JLabel("Senior Citizen: ");
        state.setFont(new Font("Railway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
       syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
       
        
        pincode=new JLabel("Existing Account: ");
        pincode.setFont(new Font("Railway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
       
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
        seniorcitizen="Yes";
}
else if (sno.isSelected()){
    seniorcitizen="No";
}
        String existingaccount=null;
        if(eyes.isSelected()){
        existingaccount="Yes";
        }
        else if(eno.isSelected()){
        existingaccount="No";
        }
        String span= panTextField.getText();
        String saadhar=aadharTextField.getText();
        try{
       
            Conn c=new Conn();
            //String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"dob"', '"gender"', '"+email+"', '"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
           String query= "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        
        }catch (Exception e){
        System.out.println(e);
        }
        
    }
   
    public static void main(String args[]){
        new SignupTwo("").setVisible(true);

    }
}





