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

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURI = request.getContextPath() + "/login";
		String url = request.getRequestURI();

		boolean resource = fileFilter(url);
		boolean loggedIn = session != null && session.getAttribute("user") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);

		String locale = (String) request.getSession().getAttribute("lang");

		if (locale == null) {
			request.getSession().setAttribute("lang", req.getLocale().getLanguage());
		}
		if (req.getParameter("sessionLocale") != null) {
			request.getSession().setAttribute("lang", req.getParameter("sessionLocale"));
		}

		if (loggedIn || loginRequest || resource) {

			chain.doFilter(request, response);
		} else {
			response.sendRedirect(loginURI);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public boolean fileFilter(String url) {
		if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png") || url.endsWith(".woff2")
				|| url.endsWith(".woff") || url.endsWith(".ttf") || url.endsWith("/registration")) {
			return true;
		} else {
			return false;
		}

	}

}