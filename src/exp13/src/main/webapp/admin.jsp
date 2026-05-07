<%@ page import="jakarta.servlet.http.*" %>
<%
    HttpSession userSession = request.getSession(false);
    if(userSession == null || !"admin".equals(userSession.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #ff512f, #dd2476);
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
            color: #dd2476;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            background: #ff512f;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            transition: 0.3s;
        }
        a:hover {
            background: #e03e1d;
        }
    </style>
</head>
<body>
<div class="dashboard">
    <h2>Welcome Admin!</h2>
    <p style="color:green;"><%= userSession.getAttribute("message") %></p>
    <p>Logged in as: <%= userSession.getAttribute("email") %></p>
    <a href="LogoutServlet">Logout</a>
</div>
</body>
</html>
