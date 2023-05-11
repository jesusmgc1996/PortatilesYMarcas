package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException {
		// Si es la primera vez que se accede a la conexión, debe instanciarse
		if (connection == null) {
			connect();
		}
		// Se comprueba si la conexión sigue estando activa
		while (!connection.isValid(5)) {
			connect();
		}
		return connection;
	}
	
	private static void connect() throws SQLException {
		String driver = JDBCProperties.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCProperties.getProperty("JDBC_USER");
		String password = JDBCProperties.getProperty("JDBC_PASSWORD");
		String host = JDBCProperties.getProperty("JDBC_HOST");
		String schema = JDBCProperties.getProperty("JDBC_SCHEMA_NAME");
		String properties = JDBCProperties.getProperty("JDBC_PROPERTIES");
		try {
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + schema + properties, user, password);		   
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
	}
	
}
