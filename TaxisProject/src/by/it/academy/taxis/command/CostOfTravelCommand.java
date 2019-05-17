package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.taxis.entity.Taxis;

public class CostOfTravelCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<Integer, Taxis> taxis = new HashMap<Integer, Taxis>();
		taxis = dao.getAllCars();
		req.setAttribute("taxis", taxis);
		RequestDispatcher cost = req.getRequestDispatcher("/CostTrip.jsp");

		cost.forward(req, resp);

	}

}
