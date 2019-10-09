package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
public class Login {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");  
		
		if (con != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("not Connected");
		}
		
	
		
		 JFrame f=new JFrame("Welcome");  
		    final JTextField tf1=new JTextField();  
		    tf1.setBounds(200,100, 150,20); 
		    final JPasswordField p1 = new JPasswordField();
		    p1.setBounds(200,150, 150,20);
		  
		  
		    JButton b=new JButton("Sign in"); 
		    b.setBounds(100,200,95,30); 
		    JButton c=new JButton("Sign up"); 
		    c.setBounds(300,200,95,30); 
		    JLabel l,l1,l6;  
		    l=new JLabel("Sign in");  
		    l.setBounds(150,50, 150,30);
		    l1=new JLabel("Username :");  
		    l1.setBounds(50,100, 100,30);  
	  
		    l6=new JLabel("Password :"); 
		    l6.setBounds(50,150, 100,30);  
	
		    f.add(l); f.add(l1);f.add(l6);
		    b.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){  
		    		String u=tf1.getText();
		    		String p= String.copyValueOf(p1.getPassword());
		    		int count = 0;
		       
		            try {
		            	Statement st = con.createStatement();
		            	ResultSet rs = st.executeQuery("Select Username,Password from reg");
		            	while(rs.next()) {
		            		if(rs.getString(1).equals(u) && rs.getString(2).equals(p)) {
		            			JOptionPane.showMessageDialog(null,"Login Success");
		            			count++;
		            			break;
		            		}
		            	}
		            	if(count==0) {
		            		JOptionPane.showMessageDialog(null,"Invalid Username or Password\nGoto Reistration");
		            	}
		         	  
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				        }  
				    });
		    c.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){  
		            
		          
		            try {
		            	  //Statement statement = con.createStatement();
						ConnectionManager.main(args);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				        }  
				    });
		    
		    
		    f.add(b);f.add(tf1);f.add(p1);f.add(c);
		    f.setSize(500,800);  
		    f.setLayout(null);  
		    f.setVisible(true); 
	
	}

}
