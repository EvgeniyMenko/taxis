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
import by.it.academy.taxis.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Map<String, String> messages = new HashMap<String, String>();
		UserJDBC userService = UserJDBC.getInstance();
		if (messages.isEmpty()) {
			String digest = DigestUtils.md5Hex(password);
			User user = userService.findUser(username, digest);
			if (user != null) {
				request.getSession().setAttribute("user", user);

			} else {

				messages.put("unknown",
						getMessage("text.unknownLogin", (String) request.getSession().getAttribute("lang")));

				String json = new Gson().toJson(messages);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				try {
					response.getWriter().write(json);
				} catch (IOException e) {
					log.error("Error servlet");
				}

			}
		}

	}

	public String getMessage(String text, String locale) {
		ResourceBundle rb = ResourceBundle.getBundle("bundle.translations", new Locale(locale));
		return rb.getString(text);
	}

}
