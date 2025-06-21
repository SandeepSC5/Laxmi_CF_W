/*package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logged")
public class Logged extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
	}

}*/
//--------------------------------------------------------------
package pack1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ConnectionBuilder;

@WebServlet("/Logged")
public class Logged extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname= request.getParameter("uname");
		try
		{
			//step1 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fund","root", "#tijori@#$80");
			
			String query= "create table fund."+uname+"(date_col date, emi int, loan int);";
			
			//Step 3
			PreparedStatement ps = con.prepareStatement(query);
			
			//Step 4
			int i = ps.executeUpdate();
			 if(i>=0)
			 {
				response.sendRedirect("signin.html");
			 }
			
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}
}