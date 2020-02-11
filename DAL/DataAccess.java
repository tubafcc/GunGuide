package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

public class DataAccess {
	public Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	public DataAccess() throws Exception{
		String url="jdbc:sqlite:C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\DAL\\gunguide.db";
		Class.forName("org.sqlite.JDBC");
		con=DriverManager.getConnection(url);
		st=con.createStatement();
	}

	
	public ResultSet ExecuteQuery(String sql)throws Exception{
		ResultSet rs=st.executeQuery(sql);
		return st.executeQuery(sql);
	}
	
	public int ExecuteUpdate(String sql)throws Exception{
		return st.executeUpdate(sql);
	}
	
	public TableModel ExecuteQueryTableModel(String sql) throws Exception{
		st=con.createStatement();
		return buildTableModel(st.executeQuery(sql));
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)throws SQLException 
	{
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	
}
