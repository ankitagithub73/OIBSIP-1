package OnlineReservationSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class personalinfo extends JFrame implements ActionListener {
    JButton  next;
    JTextField Fname, Lname;
    JComboBox occupation, language;
    JRadioButton Male, Female, Married, Unmarried;
    JDateChooser dob;
    personalinfo() {
        setTitle("Online Reservation System");
        setLayout(null);
        JLabel jLabel = new JLabel("Personal Info");
        jLabel.setFont(new Font("Osward", Font.BOLD, 25));
        jLabel.setBounds(90, 40, 260, 30);
        add(jLabel);

        JLabel Firstname = new JLabel("Enter your first name");
        Firstname.setFont(new Font("Osward", Font.BOLD, 16));
        Firstname.setBounds(120, 90, 200, 30);
        add(Firstname);
        Fname = new JTextField();
        Fname.setBounds(120, 130, 230, 30);
        Fname.setFont(new Font("Osward", Font.BOLD, 14));
        add(Fname);

        JLabel Lastname = new JLabel("Enter Your last name");
        Lastname.setFont(new Font("Osward", Font.BOLD, 16));
        Lastname.setBounds(420, 90, 250, 30);
        add(Lastname);
        Lname = new JTextField();
        Lname.setBounds(420, 130, 230, 30);
        Lname.setFont(new Font("Osward", Font.BOLD, 14));
        add(Lname);

        JLabel Dob = new JLabel("Enter your date of birth");
        Dob.setFont(new Font("Osward", Font.BOLD, 16));
        Dob.setBounds(120, 180, 200, 30);
        add(Dob);
        dob= new JDateChooser();
        dob.setBounds(120,210, 230, 30);
        add(dob);

        JLabel Occupation = new JLabel("Select your Occupation");
        Occupation.setFont(new Font("Osward", Font.BOLD, 16));
        Occupation.setBounds(420, 180, 250, 30);
        add(Occupation);
        String[] valoccupation = {"Government", "Private", "Business"};
        occupation = new JComboBox<>(valoccupation);
        occupation.setBounds(420, 220, 230, 30);
        occupation.setFont(new Font("Osward", Font.BOLD, 14));
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel Gender = new JLabel("Select your gender");
        Gender.setBounds(120, 270, 230, 30);
        Gender.setFont(new Font("Osward", Font.BOLD, 16));
        add(Gender);
        Male = new JRadioButton("Male");
        Male.setBounds(120, 310, 100, 30);
        Male.setFont(new Font("Osward", Font.BOLD, 14));
        Male.setBackground(Color.white);
        add(Male);
        Female = new JRadioButton("Female");
        Female.setBounds(250, 310, 100, 30);
        Female.setFont(new Font("Osward", Font.BOLD, 14));
        Female.setBackground(Color.white);
        add(Female);
        ButtonGroup group = new ButtonGroup();
        group.add(Male);
        group.add(Female);

        JLabel Marital = new JLabel("Select your Merital status");
        Marital.setBounds(420, 270, 230, 30);
        Marital.setFont(new Font("Osward", Font.BOLD, 16));
        add(Marital);
        Married = new JRadioButton("Married");
        Married.setBounds(420, 310, 100, 30);
        Married.setFont(new Font("Osward", Font.BOLD, 14));
        Married.setBackground(Color.white);
        add(Married);
        Unmarried = new JRadioButton("UnMarried");
        Unmarried.setBounds(530, 310, 100, 30);
        Unmarried.setFont(new Font("Osward", Font.BOLD, 14));
        Unmarried.setBackground(Color.white);
        add(Unmarried);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(Married);
        group1.add(Unmarried);

        JLabel Language = new JLabel("Select your language");
        Language.setBounds(120, 360, 250, 30);
        Language.setFont(new Font("Osward", Font.BOLD, 16));
        add(Language);
        String[] valbhasa = {"Hindi", "English", "Bhojpuri","Marathi","French","Japanies"};
        language = new JComboBox<>(valbhasa);
        language.setBounds(120,400,250,30);
        add(language);

        next = new JButton("Next");
        next.setBounds(540, 470, 100, 40);
        next.setFont(new Font("Osward", Font.BOLD, 18));
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


    public static void main(String[] args) {

        new personalinfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String FirstName = Fname.getText();
        String LastName = Lname.getText();
        String Occupation = (String) occupation.getSelectedItem();
        String Language = (String) language.getSelectedItem();

        String Gender = null;
        if(Male.isSelected())
        {
            Gender = "Male";
        }
        else if(Female.isSelected())
        {
           Gender = "Female";
        }

        String Marital = null;
        if(Married.isSelected())
        {
            Marital = "Married";
        }
       else if (Unmarried.isSelected())
        {
            Marital = "Unmarried";
        }
    String Dob = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
       try{
           Conn c = new Conn();
           String query = "insert into personalinfo values('"+FirstName+"' , '"+LastName+"', '"+Occupation+"', '"+Language+"', '"+Gender+"', '"+Marital+"', '"+Dob+"' )";
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Successfully inserted");
           System.out.println("success");
           setVisible(false);
           new Addressinfo().setVisible(true);
       }catch(Exception ae)
       {
           System.out.println(ae);
       }
    }
}





