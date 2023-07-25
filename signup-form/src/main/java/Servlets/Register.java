package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb","root","9er$Y%F49yD4");
			String query = "insert into users(username,about,first_name,last_name,email,country,street_address,city,region,postal_code,comments,candidates,offers,push_notifications) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, req.getParameter("username"));
			prepareStatement.setString(2, req.getParameter("about"));
			prepareStatement.setString(3, req.getParameter("first-name"));
			prepareStatement.setString(4, req.getParameter("last-name"));
			prepareStatement.setString(5, req.getParameter("email"));
			prepareStatement.setString(6, req.getParameter("country"));
			prepareStatement.setString(7, req.getParameter("street-address"));
			prepareStatement.setString(8, req.getParameter("city"));
			prepareStatement.setString(9, req.getParameter("region"));
			prepareStatement.setString(10, req.getParameter("postal-code"));
			prepareStatement.setString(11, req.getParameter("comments"));
			prepareStatement.setString(12, req.getParameter("candidates"));
			prepareStatement.setString(13, req.getParameter("offers"));
			prepareStatement.setString(14, req.getParameter("push-notifications"));
			
			Thread.sleep(3000); //This sleep is added just to demonstrate the effect of the spinner in save button
			prepareStatement.executeUpdate();
			
			prepareStatement.close();
			connection.close();
			
			resp.getWriter().print("Registration Successful"); //For successful registration
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			resp.getWriter().print("MySQL Driver Class Missing"); //For MySQL Driver class missing
		} 
		catch (SQLException e) {
			e.printStackTrace();
			if(e.getMessage().contains("username"))
				resp.getWriter().print("User Name Already Claimed"); //For duplicate user name
			else if(e.getMessage().contains("email"))
				resp.getWriter().print("Email Already Claimed"); //For duplicate email
			else
				resp.getWriter().print("Generic SQL Exception"); //For unknown SQL exception check server log for more details
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			resp.getWriter().print("Thread Interrupted"); //For thread interruption exception
		} 
		catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().print("Generic Exception"); //For unknown exception check server log for more details
		}
		
		

	}
}
