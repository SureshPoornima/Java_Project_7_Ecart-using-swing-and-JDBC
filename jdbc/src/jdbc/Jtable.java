package jdbc;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Jtable {
	
	public  void main() throws SQLException, ClassNotFoundException
	{
		String[] columnNames = {"productid", "productname", "Minsell", "price"};

		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart","root",""); 
	
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
	
	String productid= "";
	String productname= "";
	String Minsell = "";
	String price = "";
	try
	{ 

	String sql = "select * from productdata";
	java.sql.PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	int i =0;
	while(rs.next())
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
	
}
