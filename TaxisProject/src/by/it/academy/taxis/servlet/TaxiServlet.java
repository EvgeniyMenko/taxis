package by.it.academy.taxis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.taxis.command.Command;
import by.it.academy.taxis.command.CommandFactory;
import by.it.academy.taxis.dao.TaxisJDBC;

@WebServlet("/home")
public class TaxiServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(TaxisJDBC.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		procesReguest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		procesReguest(req, resp);

	}

	protected void procesReguest(HttpServletRequest req, HttpServletResponse resp) {
		String action = req.getParameter("action");

		if (action == null) {
			action = "home";
		}
		try {
			CommandFactory factory = CommandFactory.getInstance();
			Command command = factory.getCommand(action);

			command.execute(req, resp);
		} catch (ServletException | IOException e) {
			log.error("Error servlet");
		}

	}
}
