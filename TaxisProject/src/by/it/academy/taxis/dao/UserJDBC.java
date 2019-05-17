package by.it.academy.taxis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.taxis.connector.DataSource;
import by.it.academy.taxis.entity.User;
import by.it.academy.taxis.myinterface.IUserDAO;

public class UserJDBC implements IUserDAO {
	static UserJDBC userService;
	private static Logger log = LogManager.getLogger(UserJDBC.class);

	private UserJDBC() {
	}

	public static UserJDBC getInstance() {
		if (userService == null) {
			synchronized (UserJDBC.class) {

				userService = new UserJDBC();
			}
		}
		return userService;
	}

	@Override
	public User findUser(String login, String password) {
		User user = null;
		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM taxis.user where login=?;");
			statemant.setString(1, login);
			ResultSet rs = statemant.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("login"), rs.getString("password"), rs.getString("role"));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			log.error("Error JDBC");
		}
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}

	}

	@Override
	public int addUser(String login, String password) {
		int count = 0;
		String role = "user";
		try (Connection connection = DataSource.getConnection()) {
			try (PreparedStatement pr = connection
					.prepareStatement("insert into taxis.user(login, password,role) values(?,?,?);");) {

				pr.setString(1, login);
				pr.setString(2, password);
				pr.setString(3, role);
				count = pr.executeUpdate();

			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");
		}
		return count;
	}

	@Override
	public Map<String, String> getAllLogins() {
		Map<String, String> allLogins = new HashMap<String, String>();
		String role = "user";
		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM taxis.user where role=?;");
			statemant.setString(1, role);
			ResultSet rs = statemant.executeQuery();
			while (rs.next()) {
				allLogins.put(rs.getString("login"), rs.getString("login"));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			log.error("Error JDBC");
		}
		return allLogins;
	}

	@Override
	public int giveAdmin(String login) {
		int count = 0;
		String role = "admin";
		try (Connection connection = DataSource.getConnection()) {
			try (PreparedStatement pr = connection.prepareStatement("update taxis.user set role=? where login=?");) {

				pr.setString(1, role);
				pr.setString(2, login);

				count = pr.executeUpdate();

			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");
		}
		return count;
	}

}
