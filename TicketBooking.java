package OnlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketBooking  extends JFrame implements ActionListener {
    JButton Bookticket,Ticketcancel, Backpage, exit;
    TicketBooking()
    {
        setTitle("Online Reservation Syatem");
        setLayout(null);

        JLabel label = new JLabel("Welcome to Railway Ticket Booking System");
        label.setBounds(100,40,700,40);
        label.setFont(new Font("Osward",Font.BOLD, 26));
        add(label);

        JLabel label1 = new JLabel("Click given below button where you want to go");
        label1.setBounds(100,130,700,30);
        label1.setForeground(Color.red);
        label1.setFont(new Font("Osward",Font.BOLD, 14));
        add(label1);

        Bookticket = new JButton("Book Ticket");
        Bookticket.setBounds(130, 180,150,30);
        Bookticket.setFont(new Font ("Osward",Font.BOLD, 14));
        Bookticket.addActionListener(this);
        Bookticket.setBackground(Color.white);
        add(Bookticket);

        Ticketcancel = new JButton("Ticket Cancel");
        Ticketcancel.setBounds(450, 180,150,30);
        Ticketcancel.setFont(new Font ("Osward",Font.BOLD, 14));
        Ticketcancel.addActionListener(this);
        Ticketcancel.setBackground(Color.white);
        add(Ticketcancel);

        Backpage = new JButton("Back to login page");
        Backpage.setBounds(130, 250,200,30);
        Backpage.setFont(new Font ("Osward",Font.BOLD, 14));
        Backpage.addActionListener(this);
        Backpage.setBackground(Color.white);
        add(Backpage);

        exit = new JButton("Exit");
        exit.setBounds(450, 250,100,30);
        exit.setFont(new Font ("Osward",Font.BOLD, 14));
        exit.addActionListener(this);
        exit.setBackground(Color.white);
        add(exit);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 480);
        setVisible(true);
        setLocation(280, 140);
//        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new TicketBooking();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Bookticket)
        {
            setVisible(false);
            new Reservation().setVisible(true);
        }
        else if(e.getSource()==Backpage)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(e.getSource()==Ticketcancel)
        {
            setVisible(false);
            new TickatCancel().setVisible(true);
        }
        else if(e.getSource()==exit)
        {
            System.exit(0);
        }
    }
}
