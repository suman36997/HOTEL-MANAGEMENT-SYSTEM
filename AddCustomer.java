
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnumber , tfname, tfcountry,tfroomnumber,tfdeposit;
    JRadioButton rmale,rfemale;
    ButtonGroup bg;
    JLabel checkintime;
    Choice croom;
    JButton addcustomer,back;
    AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel heading=new JLabel("NEW CUSTOMER FORM");
        heading.setFont(new Font("Raleway",Font.PLAIN,20));
        heading.setForeground(Color.blue);
        heading.setBounds(100,20,300,30);
        add(heading);
        
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);
        
        String options[]={"Aadhar Card","Passport","Driving Lincense", "voter-Id-Card","Ration Card"};
        comboid =new JComboBox(options); 
        comboid.setBackground(Color.white);
        comboid.setBounds(200,80,150,25);
        add(comboid);
        
        JLabel lblnumber =new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(200,200,60,25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(270,200,100,25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroomnumber=new JLabel("Room Number");
        lblroomnumber.setBounds(35,280,150,20);
        lblroomnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroomnumber);
         
        croom =new Choice();
        try {
            conn c=new conn();
            String query="Select * from room where availability = 'Available'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbltime=new JLabel("Check-in time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        
        Date date=new Date();
        
          checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);
        
         JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35,360,150,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        addcustomer=new JButton("Add Customer");
        addcustomer.setBounds(50,410,120,30);
        addcustomer.setBackground(Color.black);
        addcustomer.setForeground(Color.white);
        addcustomer.addActionListener(this);
        add(addcustomer);
        
        back=new JButton("Back");
        back.setBounds(200,410,120,30);
       back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        setBounds(350,200,800,550);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==addcustomer){
             String id=(String)comboid.getSelectedItem(); 
             String number=tfnumber.getText();
             String name=tfname.getText();
             String gender=null;
             if(rmale.isSelected()){
                 gender="Male";
             }
             else
             {
                 gender="Female";
                 
             }
             String country=tfcountry.getText();
             String room=croom.getSelectedItem();
             String time=checkintime.getText();
             String deposit=tfdeposit.getText();
             try{
                 String query="insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"')";
                 String query2="update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                 conn c =new conn();
                 c.s.executeUpdate(query);
                 c.s.executeUpdate(query2);
                 JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                 setVisible(false);
                 new Reception();
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if(ae.getSource()== back){
             setVisible(false);
                 new Reception();
         }
     }
    public static void main(String[]args){
        new AddCustomer();
    }
}
