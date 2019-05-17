package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.entity.businessclass.BusinessClass;
import by.it.academy.taxis.entity.economyclass.EconomyClass;
import by.it.academy.taxis.entity.middlecalss.MidlleClass;

public class AddCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Taxis car = null;
		if (ECONOMY_CLASS.equals(req.getParameter("classCar"))) {
			car = new EconomyClass(ID, req.getParameter("car"), req.getParameter("carModel"),
					new Double(req.getParameter("cost")), new Double(req.getParameter("fuelConsumption")),
					new Double(req.getParameter("acceleration")), new Double(req.getParameter("maxSpeed")),
					new Double(req.getParameter("priceForOneMinute")));

		} else if (MIDDLEE_CLASS.equals(req.getParameter("classCar"))) {
			car = new MidlleClass(ID, req.getParameter("car"), req.getParameter("carModel"),
					new Double(req.getParameter("cost")), new Double(req.getParameter("fuelConsumption")),
					new Double(req.getParameter("acceleration")), new Double(req.getParameter("maxSpeed")),
					new Double(req.getParameter("priceForOneMinute")));

		} else if (BUSINESS_CLASS.equals(req.getParameter("classCar"))) {
			car = new BusinessClass(ID, req.getParameter("car"), req.getParameter("carModel"),
					new Double(req.getParameter("cost")), new Double(req.getParameter("fuelConsumption")),
					new Double(req.getParameter("acceleration")), new Double(req.getParameter("maxSpeed")),
					new Double(req.getParameter("priceForOneMinute")));

		}

		int count = dao.addCar(car);
		Map<String, String> messages = new HashMap<String, String>();
		if (count == 1) {

			messages.put("result", getMessage("text.add", (String) req.getSession().getAttribute("lang")));
		} else {
			messages.put("error", getMessage("text.error", (String) req.getSession().getAttribute("lang")));

		}

		String json = new Gson().toJson(messages);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		resp.getWriter().write(json);

	}

}
