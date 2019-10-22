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

public class AdminDB {
public void db() throws SQLException {
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root","");  
	JFrame j = new JFrame("Data");
	
	   JLabel l1;
	   l1 = new JLabel("Enter product id");
	   JTextField tf1;
	   tf1 = new JTextField();
	   JButton b;
	   b = new JButton("Submit");
	   

	   j.add(b);
	   j.add(l1);
	   j.add(tf1);
	    j.setSize(500,800);  
	    j.setLayout(null);  
	    j.setVisible(true); 
	   
	   
	   
	   b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] columnNames = {"productid", "productname", "Minsell", "price"};
	
					
			JFrame frame1 = new JFrame("Database Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout()); 
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//table = new JTable(model);
		JTable table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String textvalue = tf1.getText();
		String productid= "";
		String productname= "";
		String Minsell = "";
		String price = "";
		try
		{ 

		String sql = "select * from productdata where productid="+textvalue;
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i =0;
		if(rs.next())
		{
		productid = rs.getString("productid");
		productname = rs.getString("productname");
		Minsell = rs.getString("Minsell");
		price = rs.getString("price"); 
		model.addRow(new Object[]{productid, productname, Minsell, price});
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
