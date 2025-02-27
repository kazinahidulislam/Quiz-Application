package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener
{

    String questions[][] = new String[10][5]; // Initialize the inner array size
    String answers[][] = new String[10][2]; // Initialize the inner array size
    JLabel quno,question;// local diclaration diye globaly diclear korlam easy
    JRadioButton op1, op2, op3, op4;
    public static int timer = 20;
    public static int answer_g = 0;
    ButtonGroup groupoptions;
    String uanswers [][] = new String[10][1];//option select korle
    public static int count = 0;
    JButton next, helpline, submit,back;
    public static int score = 0;
    String name,scoreboard;

    Quiz(String name)
    {
        this.name= name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        setTitle("Quiz Page 1");

        //image nisis
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/2ndpic.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 300);
        add(image);

        //question no auto change hobe
        quno = new JLabel();
        quno.setBounds(100, 450, 150, 30);
        quno.setFont(new Font("Tahoma", Font.PLAIN, 30));
        quno.setForeground(Color.WHITE);
        add(quno);

        question = new JLabel();
        question.setBounds(150, 450, 800, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 30));
        question.setForeground(Color.WHITE);
        add(question);

        // Initialize questions and answers arrays using loops
        String[] questionPrompts =
        {
            "Name the Java IDE’s??",
            "Number of primitive data types in Java are?",
            "Automatic type conversion is possible in which of the possible cases?",
            "An interface with no fields or methods is known as?",
            "In which memory a String is stored, when we create a string using new operator?",
            "Which of the following is a marker interface?",
            "Which keyword is used for accessing the features of a package?",
            "In java, jar stands for?",
            "Which of the following is a mutable class in java?",
            "Which of the following option leads to the portability and security of Java?"
        };

        String[][] options =
        {
            {"Inheritance", "High Performance", "Eclipse and NetBeans", "JRE"},
            {"8", "5", "4", "9"},
            {"Long to long.", "Int to long.", "Int to Int.", "Long to Int."},
            {"Runnable Interface", "Abstract Interface", "Marker Interface", "CharSequence Interface"},
            {"Stack", "String memory", "Random storage space", "Heap memory"},
            {"Runnable interface", "Remote interface", "Readable interface", "Result interface"},
            {"import", "package", "extends", "export"},
            {"Java Archive Runner", "Java Archive", "Java Application Resource", "Java Application Runner"},
            {"java.lang.StringBuilder", "java.lang.Short", "java.lang.Byte", "java.lang.String"},
            {
                "Bytecode is executed by JVM", "The applet makes the Java code secure and portable",
                "Use of exception handling", "Dynamic binding between objects"
            }
        };

        String[] correctAnswers = {"Eclipse and NetBeans", "8", "Int to long.", "Marker Interface", "Heap memory",
                                   "Remote interface", "import", "Java Archive", "java.lang.StringBuilder",
                                   "Bytecode is executed by JVM"
                                  };

        // Assigning values using loops
        for (int i = 0; i < questions.length; i++)
        {
            questions[i][0] = questionPrompts[i];
            for (int j = 1; j < options[i].length + 1; j++)
            {
                questions[i][j] = options[i][j - 1];
            }
            answers[i][1] = correctAnswers[i];
        }

        // Print the questions and answers array to verify
        for (int i = 0; i < questions.length; i++)
        {
            System.out.println("Question: " + questions[i][0]);
            for (int j = 1; j < options[i].length + 1; j++)
            {
                System.out.println("Option " + j + ": " + questions[i][j]);
            }
            System.out.println("Correct Answer: " + answers[i][1]);
            System.out.println();
        }

        //gol button asbe tai RadioButton
        op1 = new JRadioButton("option 1");
        op1.setBounds(170,520,700, 30);
        op1.setForeground(Color.WHITE);
        op1.setBackground(Color.BLACK);
        op1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(op1);

        op2 = new JRadioButton("option 1");
        op2.setBounds(170,560,700, 30);
        op2.setForeground(Color.WHITE);
        op2.setBackground(Color.BLACK);
        op2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(op2);


        op3 = new JRadioButton("option 1");
        op3.setBounds(170,600,700, 30);
        op3.setForeground(Color.WHITE);
        op3.setBackground(Color.BLACK);
        op3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(op3);

        op4 = new JRadioButton("option 1");
        op4.setBounds(170,640,700, 30);
        op4.setForeground(Color.WHITE);
        op4.setBackground(Color.BLACK);
        op4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(op4);

        //button group nah korle button sob gula e selelct kora jabe ekta button select korte e group kora
        groupoptions = new ButtonGroup();
        groupoptions.add(op1);
        groupoptions.add(op2);
        groupoptions.add(op3);
        groupoptions.add(op4);

        //next button er jonno
        next = new JButton ("Next");
        next.setBounds(1100, 450, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 25));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.yellow);
        next.addActionListener(this);//button ta click kore kaj jate hoy
        add(next);

        helpline = new JButton ("50-50 Chance");
        helpline.setBounds(1100, 525, 200, 40);
        helpline.setFont(new Font("Tahoma", Font.PLAIN, 25));
        helpline.setForeground(Color.BLACK);
        helpline.setBackground(Color.yellow);
        helpline.addActionListener(this);//button ta click kore kaj jate hoy
        add(helpline);

        submit = new JButton ("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 25));
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.yellow);
        submit.setEnabled(false);//disible korar jonno submite button
        submit.addActionListener(this);//button ta click kore kaj jate hoy
        add(submit);
        
        back = new JButton ("Back");
        back.setBounds(1100, 675, 200, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 25));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.yellow); 
        back.addActionListener(this);//button ta click kore kaj jate hoy
        add(back);
        
        
        

        Start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == next)
        {
            answer_g = 1;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if (groupoptions.getSelection() == null)
            {
                uanswers[count][0] = "";
            }
            else
            {
                uanswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) //jokhon last question e jabe tokhon next button off submite button on er jonno
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            if (count < questions.length)
            {
                Start(count);
                timer = 20;
                repaint();
            }
            else
            {
                // End of quiz
            }
        }
        else if (ae.getSource() == helpline)
        {
            // Handle 50-50 chance button
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9 )
            {
                op2.setEnabled(false);
                op3.setEnabled(false);
            }
            else
            {
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
            helpline.setEnabled(false);
        }
        else if (ae.getSource() == back)
        {
         new Qbox(name).setVisible(true);
         this.dispose();
      }
else if (ae.getSource() == submit)
{
    answer_g = 1;
    if (groupoptions.getSelection() == null)
    {
        uanswers[count][0] = "";
    }
    else
    {
        uanswers[count][0] = groupoptions.getSelection().getActionCommand();
    }
    //score calculate er jonno
    for (int i = 0; i < uanswers.length; i++)
    {
        if (uanswers[i][0].equals(answers[i][1]))
        {
            score += 5;
        }
        else
        {
            score += 0;
        }
    }
    setVisible(false);//score dekhanor jonno
    new scoreboard(name, score); // Change this line
}
 

    }


    //timer er jonno paint method lage
    public void paint(Graphics g)
    {
        super.paint(g);

        String time = timer + " seconds left..";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0)
        {
            g.drawString(time, 500, 760);
        }
        else
        {
            g.drawString("Time OVER", 500, 760); // 0 er theke choto hole e to time ses
            timer = 20; // Reset the timer

            if (groupoptions.getSelection() == null)
            {
                uanswers[count][0] = ""; // If no option is selected, set the user answer to empty
            }
            else
            {
                uanswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++; // Move to the next question
            if (count < questions.length)
            {
                Start(count); // Display the next question
            }
            else
            {
                // End of quiz
            }
        }

        timer--; // time kombe tai

        try
        {
            Thread.sleep(1000); // multy thered method er ekta method holo thread ekhane sleep diye time je 1s stop hobe tai 1000 mili second use kora hoise
            repaint(); // eta nah use korle sudhu 20s e uthe thakbe
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (answer_g ==1 )
        {
            answer_g = 0;
            timer = 20;
        }
        else if (timer < 0)
        {
            timer = 20;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if (count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9)
            {
                //submite button er jonno
                if (groupoptions.getSelection() == null)
                {
                    uanswers[count][0] = "";
                }
                else
                {
                    uanswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                //score calculate er jonno
                for (int i = 0; i<uanswers.length; i++)
                {
                    if (uanswers[i][0].equals(answers[i][1]))
                    {
                        score += 5;
                    }
                    else
                    {
                        score += 0;
                    }
                }
                setVisible(false);//score dekhanor jonno
               new scoreboard(name, score);

            }


            else
            {
                //next button er jonno
                if (groupoptions.getSelection() == null)
                {
                    uanswers[count][0] = "";
                }
                else
                {
                    uanswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count ++;
                start (count);
            }


        }
    }


    public void Start (int count)
    {
        quno.setText("" + (count + 1) + ".");
        question.setText (questions [count] [0]);

        // next question e option gula abar on korar jonno after click 50-50 button
        op1.setEnabled(true);
        op2.setEnabled(true);
        op3.setEnabled(true);
        op4.setEnabled(true);

        op1.setText(questions [count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions [count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions [count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions [count][4]);
        op4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();//time ses e agaer question jei option selecte korsilam sei option question er ses e 2nd question asle ta auto deselect hoye jabe
    }

    public static void main(String[] args)
    {
        new Quiz("User");
    }

    private void start(int count)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
