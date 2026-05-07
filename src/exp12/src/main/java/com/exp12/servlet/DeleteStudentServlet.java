package com.exp12.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exp12db","root","G12020");
            PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            response.sendRedirect("view.jsp");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
