package application;
import java.sql.*;

import javax.sql.DataSource;

public class MyDBConnection {

	private static DataSource ds;


//	public static void main(String[] args) throws SQLException {
//		ds = MyDataSourceFactory.getDataSource("MySQL");
////		Connection con = ds.getConnection();
////		Statement stmt = con.createStatement();
////		ResultSet rs = stmt.executeQuery("Select...");
//		System.out.println("¡Conexión 2 exitosa!");
//	}


	public static void main(String[] args){
		// <tipo de conexión>:<proveedor BD>:<Ruta a la BD>:<puerto>:<nombre_BD>
		String url = "jdbc:mysql://db4free.net:3306/paegame";
		/*
		// Referencias
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{
			// Cargamos el driver en el DriverManager
			Class.forName("com.mysql.jdbc.Driver");
			// Intentamos hacer/obtener la conexión, a través del DriverManager
			conn = DriverManager.getConnection(url, "javdav", "otono2018");
			// Creamos el objeto Statement para enviar a ejecutar comandos SQL a la BD
			stmt = conn.createStatement();
			// Creamos una consulta que nos regresa un ResultSet
			rs = stmt.executeQuery("SELECT * FROM customers");

			System.out.println("¡Conexión exitosa!");
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		} finally{
			try{
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
			} catch (SQLException sqle){ sqle.printStackTrace();}
		}

		*/

		try{
			Class.forName("com.mysql.jdbc.Driver");

			// Try-with-resources
			try(Connection conn = DriverManager.getConnection(url, "anyone", "kk123456");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM users")	)
			{

				System.out.println("¡Conexión exitosa!");

			} catch (SQLException e){
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
