package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("about"));
		System.out.println(req.getParameter("first-name"));
		System.out.println(req.getParameter("last-name"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("country"));
		System.out.println(req.getParameter("street-address"));
		System.out.println(req.getParameter("city"));
		System.out.println(req.getParameter("region"));
		System.out.println(req.getParameter("postal-code"));
		System.out.println(req.getParameter("comments"));
		System.out.println(req.getParameter("candidates"));
		System.out.println(req.getParameter("offers"));
		System.out.println(req.getParameter("push-notifications"));
	}
}
