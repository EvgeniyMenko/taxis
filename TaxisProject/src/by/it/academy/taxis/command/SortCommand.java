package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.taxis.entity.Taxis;

public class SortCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Taxis> listTaxis = new ArrayList<Taxis>();
		Map<Integer, Taxis> taxis = new HashMap<Integer, Taxis>();
		RequestDispatcher sort = req.getRequestDispatcher("/Sort.jsp");
		taxis = dao.getAllCars();
		listTaxis = utils.sortCar(taxis);
		String message = getMessage("text.carSorted", (String) req.getSession().getAttribute("lang"));

		req.setAttribute("message", message);
		req.setAttribute("listTaxis", listTaxis);

		sort.forward(req, resp);

	}

}
