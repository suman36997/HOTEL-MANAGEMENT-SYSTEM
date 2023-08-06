/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author suman
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    HotelManagementSystem(){
        setSize(1820,1000);
        setLocation(100,100);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(30,850,1000,30);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,40));
        JButton next=new JButton("Next");
        next.setBounds(1550,850,150,50);
        next.setBackground(Color.white);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,24));
        image.add(next); 
        setVisible(true);
        // lower while loop used for dipper functionlity 
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
         setVisible(false);//Here we close the frame
         new Login();//Here we open the Login by invoking its constructor
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
