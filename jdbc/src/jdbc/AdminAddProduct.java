package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminAddProduct {
	public void adminAddProduct() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root","");  
	JFrame f = new JFrame("Admin Login");
	 JButton  b1,b2,b3; 
	b1 = new JButton("Add Product");
	b1.setBounds(50,100,150,30);
	b2 = new JButton("Display Inventory Details");
	b2.setBounds(50,150,150,30);
	b3 = new JButton("Logout");
	b3.setBounds(50,200,100,30);
	
	 b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JFrame f1 = new JFrame("Add product");
				
				JLabel l1,l2,l3,l4;
				l1 = new JLabel("Product Id");
				l1.setBounds(50,100,100,30);
				l2 = new JLabel("Product name");
				l2.setBounds(50,150,100,30);
				l3 = new JLabel("MinSell Quantity");
				l3.setBounds(50,200,100,30);
				l4 = new JLabel("Price");
				l4.setBounds(50,250,100,30);
				
				
				final JTextField tf1,tf2,tf3,tf4;
				tf1 = new JTextField();
				tf1.setBounds(200,100,100,30);
				tf2 = new JTextField();
				tf2.setBounds(200,150,100,30);
				tf3 = new JTextField();
				tf3.setBounds(200,200,100,30);
				tf4 = new JTextField();
				tf4.setBounds(200,250,100,30);
				
				JButton b = new JButton("Submit");
				b.setBounds(150,300,100,30);

				
				 b.addActionListener(new ActionListener(){ 
					 @Override
				    	public void actionPerformed(ActionEvent e){  
				           
				    		String productid = tf1.getText();
				    		String productname = tf2.getText();
				    		String Minsell = tf3.getText();
				    		String price = tf4.getText();
				    		
				          
				            try {
				            	  Statement statement = con.createStatement();
								statement.executeUpdate("INSERT INTO productdata VALUES ('"+productid+"','"+productname+"','"+Minsell+"','"+price+"')");
							} catch (SQLException e1) {
								
								e1.printStackTrace();
							}
				           
						        }  
						    });
				
				
				
				f1.add(b);
				
				f1.add(tf1);
				f1.add(tf2);
				f1.add(tf3);
				f1.add(tf4);
				
				f1.add(l1);
				f1.add(l2);
				f1.add(l3);
				f1.add(l4);
				
				f1.setSize(500,500);  
			    f1.setLayout(null);  
			    f1.setVisible(true);
			    
			}
	       });
	
	 
	 b2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
		Jtable a = new Jtable();
	
			try {
				a.main();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
}

});
	 
	 
		
		
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
		
		f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true);
	 
	}
}

