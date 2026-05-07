<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name="", email="", course="";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exp12db","root","G12020");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            name = rs.getString("name");
            email = rs.getString("email");
            course = rs.getString("course");
        }
        con.close();
    } catch(Exception e) { out.println(e); }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <style>
    body { font-family:'Segoe UI',sans-serif; background:linear-gradient(135deg,#20c997,#2575fc); margin:0; }
    .container { width:420px; margin:80px auto; background:#fff; padding:30px; border-radius:12px; box-shadow:0 6px 15px rgba(0,0,0,0.25); }
    h2 { text-align:center; color:#20c997; }
    label { display:block; margin-top:15px; font-weight:bold; color:#333; }
    input[type="text"] { width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px; }
    input[type="submit"] { margin-top:20px; width:100%; padding:12px; background:#20c997; color:#fff; border:none; border-radius:6px; font-size:16px; cursor:pointer; }
    input[type="submit"]:hover { background:#17a589; }
    a { display:block; text-align:center; margin-top:15px; color:#2575fc; text-decoration:none; font-weight:bold; }
    a:hover { color:#1a5edb; }
</style>

</head>
<body>
<div class="container">
    <h2>Edit Student</h2>
    <form action="UpdateStudentServlet" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        <label>Name:</label>
        <input type="text" name="name" value="<%= name %>" required>
        <label>Email:</label>
        <input type="text" name="email" value="<%= email %>" required>
        <label>Course:</label>
        <input type="text" name="course" value="<%= course %>" required>
        <input type="submit" value="Update Student">
    </form>
    <a href="view.jsp">⬅ Back to Student List</a>
</div>
</body>
</html>
