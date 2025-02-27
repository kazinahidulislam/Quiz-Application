package quiz.application;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;//image scaling

public class scoreboard extends JFrame implements ActionListener 
{
    JLabel heading,scoreboar;
    JButton submit;
     
   scoreboard(String name, int scoreboard)

    {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        //image nisis
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/3rd.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        //heading er jonno 
        heading = new JLabel("THANKyou " + name + " for playing IQ Minds");
        heading.setBounds(45, 80, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        scoreboar = new JLabel("Your Score is " + scoreboard);
        scoreboar.setBounds(350, 200, 300, 30);
        scoreboar.setFont(new Font("Tahoma", Font.PLAIN, 26));
        scoreboar.setForeground(Color.WHITE);
        add(scoreboar);
        
        submit = new JButton ("Play Again");
        submit.setBounds(550, 420, 150, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.yellow);
        //submit.setEnabled(false);//disible korar jonno submite button
        submit.addActionListener(this);//button ta click kore kaj jate hoy
        add(submit);

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args)
    {
        new scoreboard("User", 0);
    }
}
