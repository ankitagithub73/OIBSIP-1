package OnlineReservationSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TickatCancel extends JFrame implements ActionListener {
    JTextField name, number, amount;
    JDateChooser date;
    JButton submit, cancel, back;
    TickatCancel()
    {
        setTitle("Reservation cancel Form");
        setLayout(null);
        JLabel label = new JLabel("Ticket Cancel Form");
        label.setBounds(200, 30, 300,30);
        label.setFont(new Font("Osward", Font.BOLD , 22));
        add(label);

        JLabel PNRNumber = new JLabel("Enter PNR Number");
        PNRNumber.setBounds(120,100,230,30);
        PNRNumber.setFont(new Font("Osward", Font.BOLD, 14));
        add(PNRNumber);
        number = new JTextField();
        number.setBounds(280,100,200,30);
        number.setFont(new Font("Osward", Font.BOLD, 14));
        add(number);

        JLabel PassengerName = new JLabel("Passenger Name");
        PassengerName.setBounds(120,150,230,30);
        PassengerName.setFont(new Font("Osward", Font.BOLD, 14));
        add(PassengerName);
        name = new JTextField();
        name.setFont(new Font("Osward", Font.BOLD, 14));
        name.setBounds(280,150,200,30);
        add(name);

        JLabel Date = new JLabel("Date");
        Date.setFont(new Font("Osward", Font.BOLD, 14));
        Date.setBounds(120, 200, 230, 30);
        add(Date);
        date = new JDateChooser();
        date.setBounds(280,200, 200, 30);
        add(date);

        JLabel Amount = new JLabel("Amount");
        Amount.setBounds(120,250,230,30);
        Amount.setFont(new Font("Osward", Font.BOLD, 14));
        add(Amount);
        amount = new JTextField();
        amount.setBounds(280, 250,100,30);
        add(amount);

        submit = new JButton("Submit");
        submit.setFont(new Font("Osward", Font.BOLD, 14));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(120, 320,100,40);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Osward", Font.BOLD, 14));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setBounds(250, 320,100,40);
        add(cancel);

        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 14));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(380, 320,100,40);
        add(back);



        getContentPane().setBackground(Color.WHITE);

        setSize(600, 480);
        setVisible(true);
        setLocation(280, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new TickatCancel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit) {
            String PassengerName = name.getText();
            String PNRNumber = number.getText();
            String Amount = amount.getText();
            String Date = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            try{
                Conn c = new Conn();
                String query = "insert into TicketCancel values('"+PassengerName+"', '"+PNRNumber+"', '"+Amount+"', '"+Date+"')";
                c.s.executeUpdate(query);
                System.out.println("Success");
                JOptionPane.showMessageDialog(null,"Passenger name: "+ PassengerName + "\n PNR Number: "+ PNRNumber+ "\n Amount: "+ Amount);
                JOptionPane.showMessageDialog(null, "Your Ticket is cancel successfully \n Amount is refund after 5 days!");

            }
            catch(Exception ae){
                System.out.println(ae);

            }
        }
        else if(e.getSource()==cancel)
        {
        name.setText("");
        number.setText("");
        amount.setText("");
        date.setToolTipText("");
        }

        else if(e.getSource()==back)
        {
            setVisible(false);
            new TicketBooking().setVisible(true);
        }

    }
}
