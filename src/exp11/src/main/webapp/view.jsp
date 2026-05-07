<%@ page import="java.util.ArrayList" %>
<%
ArrayList<String[]> list = (ArrayList<String[]>) request.getAttribute("data");
%>

<html>
<body>

<h2>Student Records</h2>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
</tr>

<%
if(list != null && list.size() > 0){
    for(String[] s : list){
%>
<tr>
<td><%= s[0] %></td>
<td><%= s[1] %></td>
<td><%= s[2] %></td>
<td><%= s[3] %></td>
</tr>
<%
    }
}else{
%>
<tr>
<td colspan="4">No Data Found</td>
</tr>
<%
}
%>

</table>

</body>
</html>