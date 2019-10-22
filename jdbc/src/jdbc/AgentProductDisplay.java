package jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgentProductDisplay {
  public void agentProductDisplay() throws ClassNotFoundException, SQLException {
	  
	  
		JFrame f = new JFrame("Agent Board");
		  
		JLabel l1,l2;
		l1 = new JLabel("Buy / Sell");
		l1.setBounds(50,100,100,30);
		l2 = new JLabel("Enter Product ID");
		l2.setBounds(50,150,100,30);
		
		JTextField tf1,tf2;
		tf1 = new JTextField();
		tf1.setBounds(200,100,150,20);
		tf2 = new JTextField();
		tf2.setBounds(200,150,100,30);
		
		JButton b = new JButton("Submit");
		b.setBounds(150,200,100,30);
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(tf2);
		f.add(b);
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		String textvalue = tf1.getText();
	  
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
            
	
          }
			
		});
		
	  
	  
  }
}
