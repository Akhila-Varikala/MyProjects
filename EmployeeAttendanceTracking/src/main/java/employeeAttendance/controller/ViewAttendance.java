package employeeAttendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeeAttendance.DAO.DBConnection;
@WebServlet("/view")
public class ViewAttendance extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		        HttpSession session = request.getSession(false);
		        if (session == null) {
		            response.sendRedirect("login.html");
		            return;
		        }

		        int empId = (int) session.getAttribute("empId");

		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<h2>Attendance History</h2>");
		        out.println("<table border='1'><tr><th>Date</th><th>Status</th></tr>");

		        try (Connection con = DBConnection.getConnection()) 
		        {
		            PreparedStatement ps = con.prepareStatement("SELECT date, status FROM attendance WHERE emp_id=?");
		            ps.setInt(1, empId);
		            ResultSet rs = ps.executeQuery();

		            while (rs.next()) {
		                out.println("<tr><td>" + rs.getDate("date") + "</td><td>" + rs.getString("status") + "</td></tr>");
		            }
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }

		        out.println("</table>");
		        out.println("<a href='dasboard.html'>Back to Dashboard</a>");
		    }
		}

		
	