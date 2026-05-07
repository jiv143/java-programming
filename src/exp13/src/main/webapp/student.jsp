<%@ page import="jakarta.servlet.http.*" %>
<%
    HttpSession userSession = request.getSession(false);
    if(userSession == null || !"student".equals(userSession.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #00c6ff, #0072ff);
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .dashboard {
            background: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.25);
            width: 400px;
            text-align: center;
        }
        h2 {
            color: #0072ff;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            background: #00c6ff;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            transition: 0.3s;
        }
        a:hover {
            background: #0072ff;
        }
    </style>
</head>
<body>
<div class="dashboard">
    <h2>Welcome Student!</h2>
    <p style="color:green;"><%= userSession.getAttribute("message") %></p>
    <p>Logged in as: <%= userSession.getAttribute("email") %></p>
    <a href="LogoutServlet">Logout</a>
</div>
</body>
</html>
