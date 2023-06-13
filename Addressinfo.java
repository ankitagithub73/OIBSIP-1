package OnlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addressinfo  extends JFrame implements ActionListener {
       JButton back , createAcc;
       JTextField address,contact, pin ;
       JComboBox countryResidence;
      Addressinfo()
      {
          setTitle("Online Reservation System");
          setLayout(null);
          JLabel jLabel = new JLabel("Address Info");
          jLabel.setFont(new Font ("Osward",Font.BOLD, 25));
          jLabel.setBounds(90, 40, 260,30);
          add(jLabel);

          JLabel Address = new JLabel("Enter your residential address");
          Address.setFont(new Font ("Osward",Font.BOLD, 16));
          Address.setBounds(120, 90, 250,30);
          add(Address);
          address = new JTextField();
          address.setBounds(120,130,230,30);
          address.setFont(new Font ("Osward",Font.BOLD, 14));
          add(address);

          JLabel ContactNo = new JLabel("Alternate contact number");
          ContactNo.setFont(new Font ("Osward",Font.BOLD, 16));
          ContactNo.setBounds(420, 90, 250,30);
          add(ContactNo);
          contact = new JTextField();
          contact.setBounds(420,130,230,30);
          contact.setFont(new Font ("Osward",Font.BOLD, 14));
          add(contact);

          JLabel Country = new JLabel("Select your country of residence");
          Country.setFont(new Font ("Osward",Font.BOLD, 16));
          Country.setBounds(120, 180, 250,30);
          add(Country);
          String[] valcountry = {"India", "America", "Bhutan", "Bangladesh","Madhya pradesh"};
          countryResidence = new JComboBox<>(valcountry);
          countryResidence.setBounds(120,220,230,30);
          countryResidence.setFont(new Font ("Osward",Font.BOLD, 14));
          countryResidence.setBackground(Color.white);
          add(countryResidence);

          JLabel Pincode = new JLabel("Enter your pincode");
          Pincode.setFont(new Font ("Osward",Font.BOLD, 16));
          Pincode.setBounds(420, 180, 250,30);
          add(Pincode);
          pin = new JTextField();
          pin.setBounds(420,220,230,30);
          pin.setFont(new Font ("Osward",Font.BOLD, 14));
          add(pin);

          createAcc = new JButton("CREATE ACCOUNT");
          createAcc.setBounds(140,340,250,40);
          createAcc.addActionListener(this);
          createAcc.setBackground(Color.BLACK);
          createAcc.setForeground(Color.white);
          add(createAcc);
/*
          back = new JButton("BACK");
          back.setBounds(470,340,160,40);
          back.addActionListener(this);
          back.setBackground(Color.BLACK);
          back.setForeground(Color.white);
          add(back);
*/
          getContentPane().setBackground(Color.WHITE);

          setSize(800, 600);
          setVisible(true);
          setLocation(280, 80);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    public static void main(String[] args)
    {
        new Addressinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String Address = address.getText();
      String ContactNo = contact.getText();
      String Pincode = pin.getText();
      String Country = (String) countryResidence.getSelectedItem();

      try{
          Conn c = new Conn();
          String query = "insert into Addressinfo values('"+Address+"' , '"+ContactNo+"', '"+Pincode+"', '"+Country+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Account is created successfully!");
          setVisible(false);
          new Login().setVisible(true);
      }catch(Exception e1)
      {
          System.out.println(e1);
      }
    }
}
