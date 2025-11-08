package employeeAttendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeeAttendance.DAO.DBConnection;
@WebServlet("/login")
public class  LoginServlet extends HttpServlet
{
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try(Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employees where email=? and password = ?"))
		{
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                HttpSession session = request.getSession();
                session.setAttribute("empId", rs.getInt("id"));
                session.setAttribute("empName", rs.getString("name"));
                
                response.sendRedirect("mark");
               
            }
            
            else
            {
            	 response.setContentType("text/html");
                 PrintWriter out = response.getWriter();
                 out.println("<h3>Invalid credentials!</h3>");
                 out.println("<a href='login.html'>Try again</a>");
            }
            	
            }
            	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
		   e.printStackTrace();
		}
	}
	

}
