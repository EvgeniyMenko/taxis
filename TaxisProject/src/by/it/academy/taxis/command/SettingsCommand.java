package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SettingsCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String> allLogin = new HashMap<String, String>();
		allLogin = userService.getAllLogins();
		req.setAttribute("allLogin", allLogin);

		req.getRequestDispatcher("/Settings.jsp").forward(req, resp);

	}

}
