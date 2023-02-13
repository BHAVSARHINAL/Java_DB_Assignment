package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Swing_database implements ActionListener {
	
	
	
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	
	
	public Swing_database()
	{
		
		
		f = new JFrame("EMPLOYEE REGISTRATION");
		
	    f.setVisible(true);
	    f.setResizable(false);
	    f.setSize(500,500);
	    f.setLayout(null);
	    
	    
	    l1= new JLabel("ID");
	    l2= new JLabel("FIRST NAME");
	    l3= new JLabel("LAST NAME");
	    l4= new JLabel("EMAIL");
	    l5= new JLabel("MOBILE");
		
		t1 = new JTextField(50);
		t2 = new JTextField(50);
		t3 = new JTextField(50);
		t4 = new JTextField(50);
		t5 = new JTextField(50);

		b1 = new JButton("INSERT");
		b2 = new JButton("SEARCH");
		b3 = new JButton("UPDATE");
		b4 = new JButton("DELET");
		
		
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		
		
		
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		l1.setBounds(50,50,100,50);
		l2.setBounds(50,100,100,50);
		l3.setBounds(50,150,100,50);
		l4.setBounds(50,200,100,50);
		l5.setBounds(50,250,100,50);

		
		t1.setBounds(150,70, 190,20);
		t2.setBounds(150,120, 190,20);
		t3.setBounds(150,170, 190,20);
		t4.setBounds(150,220, 190,20);
		t5.setBounds(150,270, 190,20);
		
		b1.setBounds(60,340,90,30);
		b2.setBounds(170,340,90,30);
		b3.setBounds(60,390,90,30);
		b4.setBounds(170,390,90,30);
		
		
		
		
		
		
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		
		
		

		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new Swing_database();
		
		
	}
	
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			if(ae.getSource()==b1)
				
				
				
			{
				try {
					//Import the Driver
					Class.forName("com.mysql.jdbc.Driver");
					
					//Establish the Connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "");
					
					//Write the Query
					
					String sql = "insert into employee (f_name,l_name,email,mobile) values (?,?,?,?)";
					
					//Prepare the Statement
					
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setString(1, t2.getText());
					pst.setString(2, t3.getText());
					pst.setString(3, t4.getText());
					pst.setLong(4, Long.parseLong(t5.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(f, "Data Inserted Successfully.");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
			
				
				
				
				

			
			else if(ae.getSource()==b2)
			{
				System.out.println("SEARCH CLICK");
			}
			
			else if(ae.getSource()==b3)
			{
				System.out.println("UPDATE CLICK");
			}
			
			else	if(ae.getSource()==b4)
			{
				System.out.println("DELET CLICK");
			}
			
			
			
		}
		
		
	}







	


