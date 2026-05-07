<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <style>
    body { font-family:'Segoe UI',sans-serif; background:linear-gradient(135deg,#ff7e5f,#feb47b); margin:0; }
    .container { width:420px; margin:80px auto; background:#fff; padding:30px; border-radius:12px; box-shadow:0 6px 15px rgba(0,0,0,0.25); }
    h2 { text-align:center; color:#ff7e5f; }
    label { display:block; margin-top:15px; font-weight:bold; color:#444; }
    input[type="text"] { width:100%; padding:10px; margin-top:5px; border:1px solid #ccc; border-radius:6px; }
    input[type="submit"] { margin-top:20px; width:100%; padding:12px; background:#ff7e5f; color:#fff; border:none; border-radius:6px; font-size:16px; cursor:pointer; }
    input[type="submit"]:hover { background:#e85c3f; }
    a { display:block; text-align:center; margin-top:15px; color:#ff7e5f; text-decoration:none; font-weight:bold; }
    a:hover { color:#e85c3f; }
</style>


</head>
<body>
<div class="container">
    <h2>Student Registration</h2>
    <form action="insert" method="post">
        <label>Name:</label>
        <input type="text" name="name" required>
        <label>Email:</label>
        <input type="text" name="email" required>
        <label>Course:</label>
        <input type="text" name="course" required>
        <input type="submit" value="Register Student">
    </form>
    <a href="view.jsp">View All Students</a>
</div>
</body>
</html>
