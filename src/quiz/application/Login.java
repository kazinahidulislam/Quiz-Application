package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setLayout(new BorderLayout());

        // Create a custom JPanel with gradient background
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(null);

        // Add components to the gradient panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/1stpic.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 700, 500);
        gradientPanel.add(image);

        JLabel heading = new JLabel("IQ Minds Test");
        heading.setBounds(760, 60, 300, 50);
        heading.setFont(new Font("Forte", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        gradientPanel.add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(825, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.CYAN);
        gradientPanel.add(name);

        tfname = new JTextField();
        tfname.setBounds(750, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gradientPanel.add(tfname);

        rules = new JButton("Enter");
        rules.setBounds(760, 270, 120, 25);
        rules.setBackground(Color.RED);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        gradientPanel.add(rules);

        back = new JButton("Back");
        back.setBounds(920, 270, 120, 25);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        gradientPanel.add(back);

        getContentPane().add(gradientPanel, BorderLayout.CENTER);

        // Set the frame properties
        setSize(1100, 536);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

    // Custom JPanel with gradient background
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();
            Color color1 = Color.CYAN;  // Start color
            Color color2 = Color.BLACK;// End color
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }
}
