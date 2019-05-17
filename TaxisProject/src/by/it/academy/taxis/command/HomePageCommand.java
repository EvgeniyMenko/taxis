package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.academy.taxis.entity.Taxis;

public class HomePageCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<Integer, Taxis> taxis = new HashMap<Integer, Taxis>();
		double costCar = 0;
		RequestDispatcher home = req.getRequestDispatcher("/HomePage.jsp");
		taxis = dao.getAllCars();
		costCar = utils.sumCostTaxis(taxis);
		req.setAttribute("cost", costCar);
		req.setAttribute("taxis", taxis);

		home.forward(req, resp);

	}

}
