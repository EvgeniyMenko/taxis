package by.it.academy.taxis.command;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.taxis.dao.TaxisJDBC;
import by.it.academy.taxis.dao.UserJDBC;
import by.it.academy.taxis.utils.Utils;

public abstract class Command {
	final int ID = 0;
	final String MIDDLEE_CLASS = "Middle Class";
	final String ECONOMY_CLASS = "Economy Class";
	final String BUSINESS_CLASS = "Business Class";
	TaxisJDBC dao = TaxisJDBC.getInstance();
	Utils utils = Utils.getInstance();
	UserJDBC userService = UserJDBC.getInstance();
	Logger log = LogManager.getLogger();

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	public String getMessage(String text, String locale) {

		ResourceBundle rb = ResourceBundle.getBundle("bundle.translations", new Locale(locale));
		return rb.getString(text);
	}

}
