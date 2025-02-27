package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton start, back;
    
    Rules(String name)
    {
        this.name = name;
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel heading = new JLabel ("Welcome "+ name + " to simple Minds IQ Rules");
        heading.setBounds(30, 20, 700, 30);
        heading.setFont(new Font("Cooper Black", Font.PLAIN, 38));
        heading.setForeground(Color.CYAN);
        add(heading);
        
        JLabel rules = new JLabel ();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(Color.WHITE);
        rules.setText
        (
                  //rules gula hobe  
                    "<html>"+
                            "1.Do you know what Jonh Snow knows!!!?"+"<br><br>"+
                    "<html>"
        );
                
        add(rules);
        
        //back button
        back = new JButton ("Back");
        back.setBounds (250, 500, 100, 30);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);//for click
        add(back);
        
        //rules button
        start = new JButton ("Begin");
        start.setBounds (450, 500, 100, 30);
        start.setBackground(Color.red);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);//click option add kora
        add(start);
        
        //box create
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == start )
        {
//            setVisible(false);
//            new Quiz(name);
            new Qbox(name).setVisible(true);
            this.dispose();
            
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args)
    {
        new Rules("User");
        
    }
    
}