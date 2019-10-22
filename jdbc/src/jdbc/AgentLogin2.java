package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AgentLogin2 {
	public void agentlogin() throws SQLException {
		
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root",""); 
    	 
    	 JFrame f1 = new JFrame("Agent Login");
         JLabel l1,l2;
 		l1 = new JLabel("username");
 		l1.setBounds(50,100,100,30);
 		l2 = new JLabel("Password");
 		l2.setBounds(50,150,100,30);
 		
 		final JTextField tf1;
 		tf1 = new JTextField();
 		tf1.setBounds(200,100,100,30);
 		final JPasswordField p1 = new JPasswordField();
 		p1.setBounds(200,150,100,30);
 		
 		JButton b = new JButton("Submit");
 		b.setBounds(150,200,100,30);
 		JButton b1 = new JButton("Register");
 		b1.setBounds(150,250,100,30);
         
         f1.add(l1);
         f1.add(l2);
         f1.add(tf1);
         f1.add(p1);
         f1.add(b);
         f1.add(b1);
         f1.setSize(400,400);
         f1.setLayout(null);
         f1.setVisible(true);
         
         b.addActionListener(new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				String u=tf1.getText();
 	    		String p= String.copyValueOf(p1.getPassword());
 	    		int count = 0;
 	       
 	            try {
 	            	java.sql.Statement st = con.createStatement();
 	            	ResultSet rs = st.executeQuery("Select Username,Password from agentdata");
 	            	while(rs.next()) {
 	            		if(rs.getString(1).equals(u) && rs.getString(2).equals(p)) {
 	            			JOptionPane.showMessageDialog(null,"Login Success");
 	            			count++;
 	            			JTable2 a = new JTable2();
 	            			try {
								a.agentProductDisplay();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
 	            			
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
         
         b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				 
			}
        	 
         });
         
		
		
		
	}

}
