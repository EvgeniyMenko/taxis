package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.exception.IncorrectNumberException;

public class FindCarCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Taxis> listTaxis = null;
		Map<Integer, Taxis> taxis = new HashMap<Integer, Taxis>();
		Map<String, String> messages = new HashMap<String, String>();
		RequestDispatcher sort = req.getRequestDispatcher("/Sort.jsp");

		taxis = dao.getAllCars();
		Integer minSpeed = new Integer(req.getParameter("minSpeed"));
		Integer maxSpeed = new Integer(req.getParameter("maxSpeed"));
		Integer minAcceleration = new Integer(req.getParameter("minAcceleration"));
		Integer maxAcceleration = new Integer(req.getParameter("maxAcceleration"));

		try {
			listTaxis = utils.FindCarRangeSpeedSettings(taxis, minSpeed, minAcceleration, maxSpeed, maxAcceleration);
		} catch (IncorrectNumberException e) {
			log.error("Error utils");
		}

		if (listTaxis == null) {
			messages.put("result", getMessage("text.carNotFound", (String) req.getSession().getAttribute("lang")));
			String json = new Gson().toJson(messages);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);

		} else if (req.getParameter("forward") == null) {

			messages.put("minSpeed", req.getParameter("minSpeed"));
			messages.put("maxSpeed", req.getParameter("maxSpeed"));
			messages.put("minAcceleration", req.getParameter("minAcceleration"));
			messages.put("maxAcceleration", req.getParameter("maxAcceleration"));

			String json = new Gson().toJson(messages);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);

		} else {

			String message = getMessage("text.carFound", (String) req.getSession().getAttribute("lang"));
			req.setAttribute("message", message);
			req.setAttribute("listTaxis", listTaxis);
			sort.forward(req, resp);

		}

	}

}
