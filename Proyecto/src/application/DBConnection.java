package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import localization.ProjectLocale;

public class DBConnection
{
	String usuario = ""; // username you are connected to
	int idenemy = -1;
	int idp; // id just for TIc tac toe match
	String controlTable;
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
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("lme"), ProjectLocale.rb.getString("ltt"), 1);
			
		}
		return false;
	}

	public String register(String username, String pass, String mail)
	{
		try
		{
			int id = 1;
			rs = stmt.executeQuery("Select max(id) from users");
			if(rs.next())
				id = rs.getInt(1) + 1;
			stmt.execute("insert into users values (" + id + ",'" + username + "','" + pass + "','" + mail + "')");
			return "";
		}
		catch (SQLException e)
		{
			return e.getMessage();
		}
	}
	
	public void setID()
	{
		try
		{
			rs = stmt.executeQuery("Select max(id) from gatopartida");
			if(rs.next())
				idp = rs.getInt(1) + 1;
			stmt.execute("insert into gatopartida values (" + idp + ", '" + usuario + "')");
		}
		catch (SQLException e)
		{
			if(e.getMessage().equals("Communications link failure"))
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
			}
			if(e.getMessage().equals("Duplicate entry '"+ usuario + "' for key 'user'"))
			{
				try
				{
					rs = stmt.executeQuery("Select id from gatopartida where user = '" + usuario + "'");
					if(rs.next())
						idp = rs.getInt(1);
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
					if(e.getMessage().equals("Communications link failure"))
						JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
				}
			}
			else
				setID();
		}
	}
	
	public boolean setEnemy(String enemy)
	{
		try
		{
			rs = stmt.executeQuery("Select id from gatopartida where user = '" + enemy + "'");
			if(rs.next())
				idenemy = rs.getInt(1);
			if(idenemy == -1)
				return false;
			else
				return true;
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
		}
		return false;
	}
	
	public void createMatchTable()
	{
		try
		{
			controlTable = "control_" + idp + "_" + idenemy;
			stmt.execute("create table " + controlTable + "( turn int, cha int, idu int)");
			stmt.execute("insert into " + controlTable + " (turn, idu) values(1, "+ idp +")");
		}
		catch (SQLException e)
		{
			if(e.getMessage().equals("Table '" + controlTable + "' already exists"))
			{
				cleanConTa();
			}
			else
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
			}
		}
	}
	
	public int checkControl()
	{
		try
		{
			int c = 0;
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery("select max(turn) from " + controlTable);
			if(rs2.next())
				c = rs2.getInt(1);
			return c;
		}
		catch (SQLException e)
		{
			if(!(e.getMessage().equals("Table 'paegame." + controlTable + "' doesn't exist")))
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
			}
		}
		return -1;
	}
	
	public int fetch(int t)
	{
		try
		{
			rs = stmt.executeQuery("Select cha from " + controlTable + " where turn = " + t);
			int u = -1;
			if(rs.next())
				u = rs.getInt(1);
			return u;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
		}
		
		return -1;
	}
	
	public void send(int t, int i)
	{
		try
		{
			Statement stmt = conn.createStatement();
			stmt.execute("update " + controlTable + " set cha = " + i + ", idu = "+ idp + " where turn = " + t);
			int tu = t + 1;
			System.out.println("Inserted turn " + tu);
			stmt.execute("insert into " + controlTable + " (turn) values(" + tu + ")");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
		}
	}
	
	public void removeControlTable()
	{
		try
		{
			stmt.execute("drop table " + controlTable);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
		}
	}
	
	public void clean()
	{
		try
		{
			stmt.execute("delete from gatopartida where id = " + idp + " or id = " + idenemy);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
		}
	}
	
	public void cleanConTa()
	{
		try
		{
			stmt.execute("Delete from " + controlTable + " where turn != 1");
			stmt.execute("Update " + controlTable + " set cha = null where turn = 1");
		}
		catch (SQLException e1)
		{
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("nocav"));
			e1.printStackTrace();
		}
	}
}
