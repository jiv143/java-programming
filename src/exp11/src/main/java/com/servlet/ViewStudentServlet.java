package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.db.DBConnection;

@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        try {
            Connection con = DBConnection.getConnection();

            if (con == null) {
                response.getWriter().println("Connection Failed");
                return;
            }

            PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
            ResultSet rs = ps.executeQuery();

            response.getWriter().println("<h2>Student Records</h2>");
            response.getWriter().println("<table border='1'>");
            response.getWriter().println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                response.getWriter().println(
                    "<tr><td>" + rs.getInt("id") + "</td>" +
                    "<td>" + rs.getString("name") + "</td>" +
                    "<td>" + rs.getString("email") + "</td>" +
                    "<td>" + rs.getString("course") + "</td></tr>"
                );
            }

            if (!hasData) {
                response.getWriter().println("<tr><td colspan='4'>No Data Found</td></tr>");
            }

            response.getWriter().println("</table>");

        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}