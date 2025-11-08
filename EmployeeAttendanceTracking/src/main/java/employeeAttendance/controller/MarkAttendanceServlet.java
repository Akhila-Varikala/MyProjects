package employeeAttendance.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeeAttendance.DAO.DBConnection;

@WebServlet("/mark")
public class MarkAttendanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("empId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        int empId = (int) session.getAttribute("empId");
        LocalDate date = LocalDate.now();

        try (Connection con = DBConnection.getConnection()) {
            // Check if attendance already exists for today
            String checkQuery = "SELECT * FROM attendance WHERE emp_id = ? AND date = ?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setInt(1, empId);
            checkPs.setDate(2, java.sql.Date.valueOf(date));

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                // Attendance already marked
                out.println("<html><body>");
                out.println("<h3 style='color: red;'>Attendance already marked for today (" + date + ")!</h3>");
                out.println("<a href='dasboard.html'>Back to Dasboard</a>");
                out.println("</body></html>");
            } else {
                // Mark attendance
                String insertQuery = "INSERT INTO attendance (emp_id, date) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setInt(1, empId);
                ps.setDate(2, java.sql.Date.valueOf(date));

                ps.executeUpdate();

                out.println("<html><body>");
                out.println("<h3 style='color: green;'>Attendance marked successfully for today (" + date + ")!</h3>");
                out.println("<a href='dasboard.html'>Back to Dasboard</a>");
                out.println("</body></html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color: red;'>Error while marking attendance. Please try again later.</h3>");
            out.println("<a href='dasboard.html'>Back to Dasboard</a>");
        }
    }
}

