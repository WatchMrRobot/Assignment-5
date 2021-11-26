	
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.*;


class Picture implements ActionListener{
	 JFrame frame = new JFrame();
     JLabel Title = new JLabel("Credit Card Application Form: SunDevil Bank");
     JLabel Message1 = new JLabel("Failure to process due to Duplicate Customer ID");
     JLabel Message2 = new JLabel("Customer ID must be 4 digits long");
     JLabel fName = new JLabel("First Name:");
     JLabel lName = new JLabel("Last Name:");
     JLabel ID = new JLabel("Customer ID:");
     JLabel phone = new JLabel("Phone Number:");
     JLabel Address = new JLabel("Address:");
     JLabel SavingNum = new JLabel("Savings Account Number:");
     JLabel CheckingNum = new JLabel("Checkings Account Number:"); 
     JLabel Message3 = new JLabel("Application Submitted");
     JButton Cancel = new JButton("Cancel");
     JButton Save = new JButton("Save");
     JTextField first = new JTextField();
     JTextField Last = new JTextField();
     JTextField identification = new JTextField();
     JTextField num = new JTextField();
     JTextField home = new JTextField();
     JTextField Saving = new JTextField();
     JTextField Checking = new JTextField();
     Container container = new Container();
     Button test = new Button();
     Picture()
     {
    	 prepareGUI();
    	 properties();
     }
     
     public void prepareGUI()
     {
    	 Title.setBounds(200, -50, 300, 200);
         fName.setBounds(50, 50, 100, 100);
         first.setBounds(125, 87, 150, 30);
         
         lName.setBounds(350, 50, 100, 100);
         Last.setBounds(425, 87, 150, 30);
         
         ID.setBounds(50, 150, 100, 100 );
         identification.setBounds(125, 150+37, 150, 30);
         
         phone.setBounds(350, 150, 100, 100 );
         num.setBounds(350+95, 150+37, 150, 30);
         
         Address.setBounds(50, 250, 100, 100 );
         home.setBounds(50+75, 250+37, 150, 30);
         
         SavingNum.setBounds(50, 350, 200, 100 );
         Saving.setBounds(50+150, 350+37, 150, 30 );
         
         CheckingNum.setBounds(400, 350, 200, 100 );
         Checking.setBounds(400+175, 350+37, 150, 30);
         
         Cancel.setBounds(50, 450, 100,45);
         Save.setBounds(400, 450, 100,45);
         
         Message1.setBounds(50, 525, 500, 45);
         Message2.setBounds(50, 525, 500, 45);
         Message3.setBounds(50, 525, 500, 45);
         
         
     }
     public void properties()
     {
    	 container.add(Title);
         container.add(fName);
         container.add(lName);
         container.add(ID);
         container.add(phone);
         container.add(Address);
         container.add(SavingNum);
         container.add(CheckingNum);
         container.add(Cancel);
         container.add(Save);
         container.add(first);
         container.add(Last);
         container.add(identification);
         container.add(num);
         container.add(home);
         container.add(Saving);
         container.add(Checking);
         container.add(Message1);
         container.add(Message2);
         container.add(Message3);
         
         int frameWidth = 800;
         int frameHeight = 800;
         Message1.setForeground(Color.red);
         Message2.setForeground(Color.red);
         Message3.setForeground(Color.green);
         Message1.setVisible(false);
         Message2.setVisible(false);
         Message3.setVisible(false);    
         frame.add(container);
         frame.setSize(frameWidth, frameHeight);
         Cancel.addActionListener(this);
         Save.addActionListener(this);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
    @Override
	public void actionPerformed(ActionEvent e) 
    {
			if(e.getSource() == Cancel)
			{
				first.setText("");
				Last.setText("");
				identification.setText("");
				num.setText("");
				home.setText("");
				Saving.setText("");
				Checking.setText("");	
			}
			else if(e.getSource() == Save)
			{
				String test = identification.getText();
				File save = new File(test + ".txt");
				if(save.exists())
				{
					Message1.setVisible(true);
				}
				else if(test.length() != 4)
				{
					Message1.setVisible(false);
					Message2.setVisible(true);
				}
				else
				{
					Message3.setVisible(true);
					Message2.setVisible(false);
					Message1.setVisible(false);
					try {
						PrintWriter myWriter = new PrintWriter(new FileWriter(save, false));
						myWriter.write(first + "\n");
						myWriter.write(Last + "\n");
						myWriter.write(ID + "\n");
						myWriter.write(num + "\n");
						myWriter.write(home + "\n");
						myWriter.write(Saving + "\n");
						myWriter.write(Checking + "\n");
						myWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
				}
				
			}
	}
    
}

public class Main {	
    public static void main(String[] args) 
    {
    	new Picture();
    }
   
};