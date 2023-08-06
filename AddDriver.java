
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname , tflocation,tfage,tfcompany,tfmodel;
    JComboBox typecombo,availablecombo,gendercombo;
    AddDriver(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel heading=new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Name");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,70 ,120,30);
        add(lblroomno);
        
         tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage=new JLabel("Age");
       lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,110 ,120,30);
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(60,150,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblgender);
        
        String genderOption[]={"Male","Female"};
       gendercombo =new JComboBox(genderOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
        JLabel lbcompany=new JLabel("Car Company");
        lbcompany.setBounds(60,190,120,30);
        lbcompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbcompany);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        JLabel lblcarModel=new JLabel("Car Model");
        lblcarModel.setBounds(60,230,120,30);
        lblcarModel.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblcarModel);
        
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel lblcarMOdel =new JLabel("Car Model");
        lblcarMOdel.setBounds(60,270,120,30);
        lblcarMOdel.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblcarMOdel);
        
        String driverOption[]={"Available","Busy"};
        availablecombo =new JComboBox(driverOption);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(60,310,120,30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        add=new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
         cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
           String gender=(String)gendercombo.getSelectedItem();
           String company =tfcompany.getText();
           
           String brand=tfmodel.getText();
           String available=(String)availablecombo.getSelectedItem();
           String location=tflocation.getText();
           try{
               conn c=new conn();
               String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
           }
           catch(Exception e){
               e.printStackTrace();
           }
        }
        
        
        
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[]args){
        new AddDriver();
    }
}
