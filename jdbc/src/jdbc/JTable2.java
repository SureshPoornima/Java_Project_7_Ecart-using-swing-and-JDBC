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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTable2 {
 public void agentProductDisplay() throws ClassNotFoundException, SQLException, NumberFormatException {
	 
	    Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root","");

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
		int textvalue=Integer.parseInt(tf1.getText());
	 b.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
	
	 
	 String[] columnNames = {"productid","productname", "Minsell", "price"};

		 
	
		JFrame frame1 = new JFrame("Database Search Result");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setLayout(new BorderLayout()); 
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(columnNames);

	JTable table = new JTable();
	table.setModel(model); 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	JScrollPane scroll = new JScrollPane(table);
	scroll.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
     
	
	String productname= "";
	String Minsell = "";
	String price = "";
	try
	{ 
		
	    String sql ="select * from productdata where productid="+textvalue+";";
		
	java.sql.PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	int i =0;
	while(rs.next())
	{
	
	productname = rs.getString("productname");
	Minsell = rs.getString("Minsell");
	price = rs.getString("price"); 
	model.addRow(new Object[]{productname, Minsell, price});
	i++; 
	}
	if(i <1)
	{
	JOptionPane.showMessageDialog(null, "No Record Found","Error",
	JOptionPane.ERROR_MESSAGE);
	}
	if(i ==1)
	{
	System.out.println(i+" Record Found");
	}
	else
	{
	System.out.println(i+" Records Found");
	}
	}
	catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
	JOptionPane.ERROR_MESSAGE);
	}
	frame1.add(scroll);
	frame1.setVisible(true);
	frame1.setSize(400,300);
	 
		 }
	 });
	 
 }
}
