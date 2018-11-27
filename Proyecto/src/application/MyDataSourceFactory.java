package application;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {
	
	public static final String MYSQL = "mysql";

	private static ResourceBundle rb;

	// Regresa un DataSource de tipo MySQL
	public static DataSource getMySQLDataSource() {
		MysqlDataSource mysqlDS = null;
		try {
			rb = ResourceBundle.getBundle("application.db");
			mysqlDS = new MysqlDataSource();
			mysqlDS.setUrl(rb.getString("MYSQL_DB_URL"));
			mysqlDS.setDatabaseName(rb.getString("MYSQL_DB_NAME"));
			mysqlDS.setUser(rb.getString("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(rb.getString("MYSQL_DB_PWD"));

		} catch (MissingResourceException e) {
			e.printStackTrace();
		}

		return mysqlDS;
	}

	// Permite solicitar el tipo de DataSource
	public static DataSource getDataSource(String dbType) {
		if (dbType != null) {
			if (dbType.equalsIgnoreCase("mysql"))
				return getMySQLDataSource();
			// Si su aplicación maneja más tipos de bases de datos
			// agregar los demás tipos y regresar el DataSource de dicho tipo.
		}
		return null;
	}

//	public static void main(String[] args) {
//
//	}

}
