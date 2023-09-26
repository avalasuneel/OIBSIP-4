import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
class Exam
{
    public static void main(String args[])  
    {  
        JOptionPane.showMessageDialog(null,"ONLINE EXAMINATION");
        boolean again=true;
        int ln=0;
        Another ob=new Another();
        while(again==true)
        {
            JOptionPane.showMessageDialog(null," 1.Login\n 2.Update details\n 3.Start Exam\n 4.logout\n 5.Exit");
            String option=JOptionPane.showInputDialog("Enter your option:");
            int opt=Integer.valueOf(option);
            switch(opt)
            {
                case 1:
                    ob.login();
                    ln=1;
                    break;
                case 2:
                    if(ln==1)
                    {
                        ob.updatedetails();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 3:
                    if(ln==1)
                    {
                        Online on =new Online("Online test");
                        on.actionPerformed(null);
                        on.set();
                        on.check();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 4:
                    if(ln==1)
                    {
                        ob.logout();
                        ln=0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 5:
                    again=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    break;
            }
        }
    }  
}
class Online extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;

    int m[]=new int[10];      
    Online(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Submit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);
        add(b1);
        add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Submit"))
        {
            JOptionPane.showMessageDialog(this,"Do you want to submit");
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(1);
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals(""+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);   
        }  
    
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: What is the purpose of using loops in programming?");  
            jb[0].setText("Comparison ");
            jb[1].setText("Condition ");
            jb[2].setText("Repetition ");
            jb[3].setText("Initialization ");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: What is the difference between == and === operators in JavaScript?");  
            jb[0].setText("Equality and strict equality ");
            jb[1].setText("Equal and identical ");   
            jb[2].setText("Greater than and equal to ");
            jb[3].setText("Assignment and comparison");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: What does the print function do in Python?");  
            jb[0].setText("Output ");
            jb[1].setText("Input ");
            jb[2].setText("Calculation ");
            jb[3].setText("Looping ");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: What is the syntax for declaring a variable in Java?");  
            jb[0].setText("declare ");
            jb[1].setText("define ");
            jb[2].setText("set ");
            jb[3].setText("initialize ");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: How do you add an element to the end of an array in JavaScript?");  
            jb[0].setText("append() ");
            jb[1].setText("push() ");
            jb[2].setText("insert() ");
            jb[3].setText("add() ");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: What is the purpose of the else statement in an if-else statement?");  
            jb[0].setText("Iteration ");
            jb[1].setText("Comparison ");
            jb[2].setText("Alternative ");
            jb[3].setText("Initialization ");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: How do you define a function in Python?");  
            jb[0].setText("function ");
            jb[1].setText("def ");
            jb[2].setText("define ");  
            jb[3].setText("func ");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: What does CSS stand for in web development?");  
            jb[0].setText("Centralized Style Sheets ");
            jb[1].setText("Cascading Script Styles ");
            jb[2].setText("Creative Style Sheets ");  
            jb[3].setText("Cascading Style Sheets ");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: How do you remove an element from an array in JavaScript?");  
            jb[0].setText("delete() ");
            jb[1].setText("splice() ");
            jb[2].setText("remove() ");
            jb[3].setText("extract() ");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: What is the purpose of a constructor in object-oriented programming?");  
            jb[0].setText("Inheritance ");
            jb[1].setText("Modification ");
            jb[2].setText("Initialization ");  
            jb[3].setText("Creation ");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
}  
class Another
{
    public String name,password,email;
    void login()
    {
        name=JOptionPane.showInputDialog("Enter your Name:");
        email=JOptionPane.showInputDialog("Enter your email:");
        password=JOptionPane.showInputDialog("Enter your password:");
    }
    void updatedetails()
    {
        String ch;
        JOptionPane.showMessageDialog(null," Your Name: "+name+"\n Your email: "+email+"\n Your password: "+password);
        ch=JOptionPane.showInputDialog("enter your choice\n (NOTE:\n name-->1 \n email-->2 \nemail--3):");
        int choice=Integer.valueOf(ch);
        switch(choice)
        {
            case 1:
                name=JOptionPane.showInputDialog("Enter your Name: ");
                JOptionPane.showMessageDialog(null," Your updated Name: "+name);
                break;
            case 2:
                email=JOptionPane.showInputDialog("Enter your email: ");
                JOptionPane.showMessageDialog(null," Your updated email : "+email);
                break;
            case 3:
                password=JOptionPane.showInputDialog("Enter your password:");
                JOptionPane.showMessageDialog(null," Your password: "+password);
                break;
            default:
                JOptionPane.showMessageDialog(null,"You entered invalid option");
                break;
            }
            JOptionPane.showMessageDialog(null,"UPDATED DETAILS:\n Your Name: "+name+"\n Your email: "+email+"\n Your password: "+password);
    }
    void logout()
    {
        name=null;
        password=null;
        email=null;
        JOptionPane.showMessageDialog(null,"Logged Out successfully");
    }
}