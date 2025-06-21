
package pack1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Transaction")
public class Transaction extends HttpServlet
{
	private static final long serialVersionUID=1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,  ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			
			//step1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/fund","root", "#tijori@#$80");
			
			String name = request.getParameter("uname");
			String emi = request.getParameter("emi");
			String loan = request.getParameter("loan");
			String tarik = request.getParameter("tarik");
			String query= "INSERT INTO fund."+name+" values(\""+tarik+"\","+emi+","+loan+");";
			
			//step3
			PreparedStatement ps = con.prepareStatement(query);
			//create statement ???
			int i =ps.executeUpdate();
			if(i>=0)
			{
				response.sendRedirect("signin.html");
			}
		}
		catch(Exception e)
		{
			out.println(e); //sends exception back to the client’s browser.
			
		}
		
	}
}

