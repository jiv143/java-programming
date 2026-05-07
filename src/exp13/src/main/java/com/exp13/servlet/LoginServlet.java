package com.exp13.servlet;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("username"); // from login.jsp
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exp13db", "root", "G12020"); // adjust user/pass

            PreparedStatement ps = con.prepareStatement(
                "SELECT role FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String role = rs.getString("role");
                session.setAttribute("role", role);
                session.setAttribute("email", email);
                session.setAttribute("message", "Login Successful!");

                if("admin".equals(role)) {
                    response.sendRedirect("admin.jsp");
                } else {
                    response.sendRedirect("student.jsp");
                }
            } else {
                response.sendRedirect("login.jsp?error=true");
            }

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
