package OnlineReservationSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Reservation extends JFrame implements ActionListener {
    JComboBox  train , classty, from, destination;
    JDateChooser dateChooser;
    JTextField passenger , passenger1, amount;
    JButton insert, back;
    Reservation()
    {
        setTitle("Ticket booking form");
        setLayout(null);
        JLabel label = new JLabel("Tickat Booking Form");
        label.setBounds(180,20,300,30);
        label.setFont(new Font("Osward", Font.BOLD, 18));
        add(label);

        JLabel TrainName = new JLabel("Select Train Name ");
        TrainName.setFont(new Font("Osward", Font.BOLD, 16));
        TrainName.setBounds(60, 80, 180, 30);
        add(TrainName);
        String[] valTrain = {"--- Please Select Train ---","01884 Gwalior - Bina Passenger Special", "11123 Gwalior - Barauni Mail",
                "12566 Bihar Sampark Kranti Express", "12239 Hisar Duranto Express"};
        train = new JComboBox<>(valTrain);
        train.setBounds(260, 80, 230, 30);
        train.setFont(new Font("Osward", Font.BOLD, 14));
        train.setBackground(Color.white);
        train.setBackground(Color.white);
        add(train);

        JLabel date = new JLabel("Date of journy");
        date.setFont(new Font("Osward", Font.BOLD, 16));
        date.setBounds(60, 130, 230, 30);
        add(date);
        dateChooser= new JDateChooser();
        dateChooser.setBounds(260,130, 230, 30);
        add(dateChooser);

        JLabel ClassType = new JLabel("Class Type ");
        ClassType.setFont(new Font("Osward", Font.BOLD, 16));
        ClassType.setBounds(60, 180, 230, 30);
        add(ClassType);
        String[] valclasstype = {"AC1", "AC2" ,"AC3", "SL", "GENERAL"};
        classty = new JComboBox<>(valclasstype);
        classty.setBounds(260, 180, 230, 30);
        classty.setFont(new Font("Osward", Font.BOLD, 14));
        classty.setBackground(Color.white);
        classty.setBackground(Color.white);
        add(classty);

        JLabel destination1= new JLabel("From");
        destination1.setFont(new Font("Osward", Font.BOLD, 16));
        destination1.setBounds(60,230,230,30);
        add(destination1);
        String[] valfrom = {"--- please Select ---", "Kanpur" ,"Lucknow", "Banaras", "Delhi", "Mathura","Siwan"};
        from = new JComboBox<>(valfrom);
        from.setBounds(260, 230, 230, 30);
        from.setFont(new Font("Osward", Font.BOLD, 14));
        from.setBackground(Color.white);
        from.setBackground(Color.white);
        add(from);

        JLabel Destination = new JLabel("Destination");
        Destination.setFont(new Font("Osward", Font.BOLD, 16));
        Destination.setBounds(60,280,230,30);
        add(Destination);
        String[] valDestination = {"--- please Select ---", "Kanpur" ,"Lucknow", "Banaras", "Delhi", "Mathura","Siwan"};
        destination = new JComboBox<>(valDestination);
        destination.setBounds(260, 280, 230, 30);
        destination.setFont(new Font("Osward", Font.BOLD, 14));
        destination.setBackground(Color.white);
        destination.setBackground(Color.white);
        add(destination);

        JLabel PassengerName = new JLabel("Passenger Name");
        PassengerName.setBounds(60,330,230,30);
        PassengerName.setFont(new Font("Osward", Font.BOLD, 14));
        add(PassengerName);
        passenger = new JTextField();
        passenger.setBounds(260,330,230,30);
        add(passenger);

        JLabel PassengerAge = new JLabel("Passenger Age");
        PassengerAge.setBounds(60,380,230,30);
        PassengerAge.setFont(new Font("Osward", Font.BOLD, 14));
        add(PassengerAge);
        passenger1 = new JTextField();
        passenger1.setBounds(260,380,230,30);
        add(passenger1);

        JLabel PNRNumber = new JLabel("PNR Number");
        PNRNumber.setBounds(60,430,230,30);
        PNRNumber.setFont(new Font("Osward", Font.BOLD, 14));
        add(PNRNumber);
        JLabel digit = new JLabel("XXX XXX X12");
        digit.setBounds(280,430,230,30);
        digit.setFont(new Font("Osward", Font.BOLD, 16));
        add(digit);

        JLabel Amount = new JLabel("Amount");
        Amount.setBounds(60,480,230,30);
        Amount.setFont(new Font("Osward", Font.BOLD, 14));
        add(Amount);
        amount = new JTextField();
        amount.setBounds(260, 480,100,30);
        add(amount);


        insert = new JButton("Insert");
        insert.setBounds(180,550,100, 30);
        insert.setFont(new Font("Osward", Font.BOLD, 14));
        insert.addActionListener(this);
        insert.setBackground(Color.black);
        insert.setForeground(Color.white);
        add(insert);

        back = new JButton("Back");
        back.setBounds(320,550,100, 30);
        back.setFont(new Font("Osward", Font.BOLD, 14));
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);



        getContentPane().setBackground(Color.WHITE);

        setSize(600, 650);
        setVisible(true);
        setLocation(350, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new Reservation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==insert)
        {
        String PassengerName = passenger.getText();
        String PassengerAge = passenger1.getText();
        String Amount = amount.getText();
        Random random = new Random();
        String PNRNumber = ""+ Math.abs((random.nextLong() % 90000000)+ 504093600);

        String TrainName = (String) train.getSelectedItem();
        String ClassType = (String) classty.getSelectedItem();
        String destination1= (String) from.getSelectedItem();
        String Destination= (String) destination.getSelectedItem();
        String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        try{
            Conn c = new Conn();
            String query = "insert into Reservation values('"+PassengerName+"' , '"+PassengerAge+"' ,'"+PNRNumber+"', '"+TrainName+"', '"+ClassType+"', '"+destination1+"', '"+Destination+"', '"+date+"', '"+Amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"success");
             JOptionPane.showMessageDialog(null,"PNR Number: "+PNRNumber + "\n Passenger Name: " + PassengerName +"\n Amount: "+ Amount);
             System.out.println("success");
        }catch(Exception ae)
        {
            System.out.println(ae);
        }}
        else if(e.getSource()==back)
        {
            setVisible(false);
            new TicketBooking().setVisible(true);
        }
    }
}
