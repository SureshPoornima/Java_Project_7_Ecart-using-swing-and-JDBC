package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ecart2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root","");  
		
		if (con != null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("not Connected");
		}
		
		
		
        JFrame f = new JFrame("Welcome to Ecart");
		
		JButton b1,b2,b3;
		b1 = new JButton("Admin Login");
		b1.setBounds(50,100,150,30);
		b2 = new JButton("Agent Login");
		b2.setBounds(50,150,150,30);
		b3 = new JButton("Exit");
		b3.setBounds(50,200,150,30);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Adminlogin2 a = new Adminlogin2();
				try {
					try {
						a.adminlogin();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.dispose();
			}
			
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AgentLogin2 a = new AgentLogin2();
			
				try {
					a.agentlogin();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.dispose();
			}
			
			      
			
			
		});

	
}
}
