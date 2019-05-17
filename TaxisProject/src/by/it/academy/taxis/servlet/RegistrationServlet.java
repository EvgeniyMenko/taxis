package by.it.academy.taxis.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import by.it.academy.taxis.dao.UserJDBC;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(RegistrationServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Map<String, String> messages = new HashMap<String, String>();

			UserJDBC userService = UserJDBC.getInstance();
			String login = request.getParameter("username");
			String password = request.getParameter("password");
			String digest = DigestUtils.md5Hex(password);
			int count = userService.addUser(login, digest);
			if (count == 1) {

				LoginServlet l = new LoginServlet();
				l.doPost(request, response);

			} else {
				messages.put("fail", getMessage("text.errorReg", (String) request.getSession().getAttribute("lang")));

				String json = new Gson().toJson(messages);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			}
		} catch (IOException e) {
			log.error("Error servlet");
		}

	}

	public String getMessage(String text, String locale) {
		ResourceBundle rb = ResourceBundle.getBundle("bundle.translations", new Locale(locale));
		return rb.getString(text);
	}
}
