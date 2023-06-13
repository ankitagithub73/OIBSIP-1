package OnlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup extends JFrame implements ActionListener {
    JButton next;
    JTextField User, MobileNumber, EmailAddress ,Ans ;
    JPasswordField Password;
    JComboBox security;
    signup()
    {
        setTitle("Online Reservation System");
        setLayout(null);
        JLabel jLabel = new JLabel("Account Setup");
        jLabel.setFont(new Font ("Osward",Font.BOLD, 25));
        jLabel.setBounds(90, 40, 200,30);
        add(jLabel);

        JLabel user = new JLabel("Create UserId");
        user.setFont(new Font ("Osward",Font.BOLD, 16));
        user.setBounds(120, 90, 200,30);
        add(user);
        User = new JTextField();
        User.setBounds(120,130,230,30);
        User.setFont(new Font ("Osward",Font.BOLD, 14));
        add(User);

        JLabel Mobile = new JLabel("Enter Your Mobile Number");
        Mobile.setFont(new Font ("Osward",Font.BOLD, 16));
        Mobile.setBounds(120, 180, 200,30);
        add(Mobile);
        MobileNumber = new JTextField();
        MobileNumber.setBounds(120,220,230,30);
        MobileNumber.setFont(new Font ("Osward",Font.BOLD, 14));
        add(MobileNumber);

        JLabel Security = new JLabel("Select Your security question");
        Security.setFont(new Font ("Osward",Font.BOLD, 16));
        Security.setBounds(120, 260, 250,30);
        add(Security);
        String[] valsecurity = {"what is primary school name?", "what is your favourate pet name?"};
        security = new JComboBox<>(valsecurity);
        security.setBounds(120,300,230,30);
        security.setFont(new Font ("Osward",Font.BOLD, 13));
        security.setBackground(Color.white);
        add(security);

        JLabel Email = new JLabel("Enter Your Email Address");
        Email.setFont(new Font ("Osward",Font.BOLD, 16));
        Email.setBounds(420, 90, 250,30);
        add(Email);
        EmailAddress = new JTextField();
        EmailAddress.setBounds(420,130,230,30);
        EmailAddress.setFont(new Font ("Osward",Font.BOLD, 14));
        add(EmailAddress);

        JLabel Pin= new JLabel("Enter Your Password");
        Pin.setFont(new Font ("Osward",Font.BOLD, 16));
        Pin.setBounds(420, 180, 250,30);
        add(Pin);
        Password = new JPasswordField();
        Password.setBounds(420,220,230,30);
        Password.setFont(new Font ("Osward",Font.BOLD, 14));
        add(Password);

        JLabel securityAns = new JLabel("Enter a security answer");
        securityAns.setFont(new Font ("Osward",Font.BOLD, 16));
        securityAns.setBounds(420, 260, 250,30);
        add(securityAns);
        Ans = new JTextField();
        Ans.setBounds(420,300,230,30);
        Ans.setFont(new Font ("Osward",Font.BOLD, 14));
        add(Ans);
/*
        back = new JButton("Back");
        back.setBounds(380,380,100,40);
        back.setFont(new Font ("Osward",Font.BOLD, 18));
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
*/
        next = new JButton("Next");
        next.setBounds(520,380,100,40);
        next.setFont(new Font ("Osward",Font.BOLD, 18));
        next.addActionListener(this);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 600);
        setVisible(true);
        setLocation(280, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String user = User.getText();
         String Mobile = MobileNumber.getText();
         String Email = EmailAddress.getText();
         String securityAns = Ans.getText();
         String Pin = Password.getText();
         String Security = (String) security.getSelectedItem();
         try{
             Conn c = new Conn();
             String query ="insert into signup values('"+user+"' ,'"+Mobile+"', '"+Email+"', '"+Pin+"', '"+Security+"' ,'"+securityAns+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Successfully inserted");
             setVisible(false);
             new personalinfo().setVisible(true);



         }
         catch(Exception ae)
         {
             System.out.println(ae);
         }
    }
}
