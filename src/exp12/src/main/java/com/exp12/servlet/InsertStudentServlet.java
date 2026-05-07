package com.exp12.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class InsertStudentServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/exp12db";
    private static final String USER = "root";   // change if your MySQL username is different
    private static final String PASS = "G12020";   // change if your MySQL password is different

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get values from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to database
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // Insert query
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO student(name,email,course) VALUES(?,?,?)"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int i = ps.executeUpdate();
            if(i > 0) {
                response.sendRedirect("success.jsp"); // go to success page
            } else {
                out.println("Error inserting data");
            }

            con.close();
        } catch(Exception e) {
            e.printStackTrace(out);
        }
    }
}
