<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
   <style>
    body { font-family:'Segoe UI',sans-serif; background:#f3f6fb; }
    h2 { text-align:center; color:#2575fc; margin-top:30px; }
    table { width:85%; margin:30px auto; border-collapse:collapse; box-shadow:0 4px 12px rgba(0,0,0,0.15); }
    th, td { padding:12px; border:1px solid #ddd; text-align:center; }
    th { background:#6a11cb; color:#fff; }
    tr:nth-child(even) { background:#f9f9f9; }
    tr:hover { background:#eaf0ff; }
    a { padding:6px 14px; border-radius:6px; text-decoration:none; font-weight:bold; }
    .edit { background:#20c997; color:#fff; }
    .edit:hover { background:#17a589; }
    .delete { background:#e63946; color:#fff; }
    .delete:hover { background:#c82333; }
</style>

</head>
<body>
    <h2>Student Records</h2>
    <table>
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exp12db","root","G12020");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM student");
                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("course") %></td>
            <td>
                <a class="edit" href="edit.jsp?id=<%= rs.getInt("id") %>">Edit</a>
                <a class="delete" href="DeleteStudentServlet?id=<%= rs.getInt("id") %>">Delete</a>
            </td>
        </tr>
        <%
                }
                con.close();
            } catch(Exception e) { out.println(e); }
        %>
    </table>
</body>
</html>
