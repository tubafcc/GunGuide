package Model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class myUtil {
	

	

	
		public static boolean isEmpty(String str)
		{
			return str.trim().isEmpty();
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


