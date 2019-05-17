package by.it.academy.taxis.myinterface;

import java.util.Map;

import by.it.academy.taxis.entity.User;

public interface IUserDAO {
	User findUser(String login, String password);

	int addUser(String login, String password);

	Map<String, String> getAllLogins();

	int giveAdmin(String login);
}
