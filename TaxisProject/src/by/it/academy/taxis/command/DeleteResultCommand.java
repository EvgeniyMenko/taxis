package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class DeleteResultCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Map<String, String> messages = new HashMap<String, String>();
		String id = req.getParameter("id");
		int count = dao.removeCar(new Integer(id));
		if (count == 1) {
			messages.put("result", getMessage("text.deleteResult", (String) req.getSession().getAttribute("lang")));

		} else {
			messages.put("error", getMessage("text.error", (String) req.getSession().getAttribute("lang")));

		}

		String json = new Gson().toJson(messages);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		resp.getWriter().write(json);

	}

}
