package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class DBConnection
{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		DataSource ds = MyDataSourceFactory.getDataSource(MyDataSourceFactory.MYSQL);
		
		public void start()
		{
			try
			{
				conn  = ds.getConnection();
				stmt = conn.createStatement();
//				if(stmt.execute("Insert into users (id, username, password) values (3, 'kk', 'popo')"))
//					System.out.println("DONE");
			}
			catch(SQLException exc)
			{
				JOptionPane.showMessageDialog(null, "Connection not avaliable", "Database Error", 0);
			}
		}
		
		public boolean login(String username, String pass)
		{
			try
			{
				rs = stmt.executeQuery("Select password from users where username='" + username + "'");
				if(rs.next())
					if(rs.getString(1).equals(pass))
						return true;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Connection not avaliable", "Database Error", 1);
			}
			return false;
		}

}
