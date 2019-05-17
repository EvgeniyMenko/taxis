package by.it.academy.taxis.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource {
	private static Connection connection;

	public static Connection getConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		ResourceBundle resource = ResourceBundle.getBundle("database");
		String url = resource.getString("db.url");
		String user = resource.getString("db.user");
		String pass = resource.getString("db.password");
		connection = DriverManager.getConnection(url, user, pass);
		return connection;
	}
}
