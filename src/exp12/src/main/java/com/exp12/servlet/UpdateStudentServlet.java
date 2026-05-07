package com.exp12.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exp12db","root","G12020");
            PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, email=?, course=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, id);
            ps.executeUpdate();
            con.close();
            response.sendRedirect("view.jsp");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
