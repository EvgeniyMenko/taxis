package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.it.academy.taxis.entity.Taxis;

public class CostOfTripResultCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Taxis car = null;
		String id = req.getParameter("id");
		String time = req.getParameter("time");
		car = dao.getCar(new Integer(id));
		double cost = car.taxiFare(new Integer(time));

		String message = getMessage("text.costResult", (String) req.getSession().getAttribute("lang")) + " = " + cost
				+ "$";

		Map<String, String> messages = new HashMap<String, String>();
		messages.put("result", message);

		String json = new Gson().toJson(messages);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		resp.getWriter().write(json);

	}

}
