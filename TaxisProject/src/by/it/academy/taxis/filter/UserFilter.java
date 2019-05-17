package by.it.academy.taxis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.it.academy.taxis.entity.User;

@WebFilter("/home")
public class UserFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		String homeURI = request.getContextPath() + "/home";

		User user = (User) session.getAttribute("user");
		boolean loggedIn = session != null && session.getAttribute("user") != null && user != null
				&& request.getParameter("action") != null;
		if (loggedIn && user != null && user.getRole().equals("user")
				&& (request.getParameter("action").equals("add")
						|| request.getParameter("action").equals("deleteOrUpdate")
						|| request.getParameter("action").equals("selection")
						|| request.getParameter("action").equals("settings"))) {
			response.sendRedirect(homeURI);

		} else {

			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
