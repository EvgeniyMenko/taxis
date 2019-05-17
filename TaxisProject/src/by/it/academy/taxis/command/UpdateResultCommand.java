package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.it.academy.taxis.entity.Taxis;

public class UpdateResultCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String id = req.getParameter("id");
		Taxis car = null;
		car = dao.getCar(new Integer(id));
		car.setCar(req.getParameter("car"));
		car.setCarModel(req.getParameter("carModel"));
		car.setCost(new Double(req.getParameter("cost")));
		car.setFuelConsumption(new Double(req.getParameter("fuelConsumption")));
		car.setAcceleration(new Double(req.getParameter("acceleration")));
		car.setMaxSpeed(new Double(req.getParameter("maxSpeed")));
		car.setPriceForOneMinute(new Double(req.getParameter("priceForOneMinute")));
		String classCar = car.getClassCar();
		int count = dao.updateCar(car);

		Map<String, String> messages = new HashMap<String, String>();
		if (count == 1) {
			messages.put("result", getMessage("text.updateResult", (String) req.getSession().getAttribute("lang")));
			messages.put("car", req.getParameter("car"));
			messages.put("cost", req.getParameter("cost"));
			messages.put("carModel", req.getParameter("carModel"));
			messages.put("fuelConsumption", req.getParameter("fuelConsumption"));
			messages.put("acceleration", req.getParameter("acceleration"));
			messages.put("maxSpeed", req.getParameter("maxSpeed"));
			messages.put("priceForOneMinute", req.getParameter("priceForOneMinute"));
			messages.put("classCar", classCar);
			messages.put("id", req.getParameter("id"));
		} else {
			messages.put("error", getMessage("text.error", (String) req.getSession().getAttribute("lang")));
		}

		String json = new Gson().toJson(messages);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		resp.getWriter().write(json);

	}

}
