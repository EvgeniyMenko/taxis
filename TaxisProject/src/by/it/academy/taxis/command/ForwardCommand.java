package by.it.academy.taxis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("action").equals("add")) {
			RequestDispatcher add = req.getRequestDispatcher("/AddCar.jsp");
			add.forward(req, resp);
		} else if (req.getParameter("action").equals("findCar")) {
			RequestDispatcher find = req.getRequestDispatcher("/FindCar.jsp");
			find.forward(req, resp);
		}

	}

}
