package OnlineReservationSystem;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JTextField Card ;
    JPasswordField  Pin;
    JButton login , signup, clear;

    Login(){

        setTitle("ONLINE RESERVATION SYSTEM");
        setLayout(null);

        JLabel label1 = new JLabel("Welcome To ");
        label1.setFont(new Font ("Osward",Font.BOLD, 32));
        label1.setBounds(260, 40, 400, 30);
        add(label1);

        JLabel label2 = new JLabel(" Online Reservation System");
        label2.setFont(new Font ("Osward",Font.BOLD, 30));
        label2.setForeground(Color.BLUE);
        label2.setBounds(160, 70, 400, 30);
        add(label2);

        JLabel UserId = new JLabel("User Id: ");
        UserId.setFont(new Font ("Osward",Font.BOLD, 20));
        UserId.setBounds(160,150,100, 30);
        add(UserId);
        Card = new JTextField();
        Card.setBounds(280, 150, 220, 30);
        add(Card);

        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font ("Osward",Font.BOLD, 20));
        pin.setBounds(160,200,100, 30);
        add(pin);

        Pin = new JPasswordField();
        Pin.setBounds(280, 200, 220, 30);
        add(Pin);

        login = new JButton("LOGIN");
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(280, 280, 100, 30);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.setBounds(400, 280, 100, 30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.setBounds(280, 340, 220, 30);
        signup.addActionListener(this);
        add(signup);



        getContentPane().setBackground(Color.WHITE);

        setSize(700, 480);
        setVisible(true);
        setLocation(280, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed( ActionEvent ae) {
        if(ae.getSource()== clear) {
            Card.setText("");
            Pin.setText("");
        }
        else if (ae.getSource()==login)
        {
          String UserId = Card.getText();
          String pin = Pin.getText();
          try{
              Conn c = new Conn();
              String query = "Select userId, pin from signup where userID = '"+UserId+"' and Pin ='"+pin+"'";
             try{
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new TicketBooking().setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "incorrect userid or pin");
               }

             }catch (Exception ae1)
             {
                 System.out.println(ae1);
             }

          }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new signup().setVisible(true);
        }

    }

    public static void main(String[] args) {

        new Login();
    }


}