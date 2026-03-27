package marks;
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.io.PrintWriter; 
@jakarta.servlet.annotation.WebServlet("/Marks_Servlet")
public class Marks_Servlet extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 
 protected void doGet(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  doPost(request,response); 
  
 } 
  
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  response.setContentType("text/html"); 
  PrintWriter out = response.getWriter(); 
   
  String Username = request.getParameter("Username"); 
  String DCN_Marks = request.getParameter("DCN_Marks"); 
  String SE_Marks = request.getParameter("SE_Marks"); 
  String WT_Marks = request.getParameter("WT_Marks"); 
   
  if( Username == null || Username.trim().isEmpty() || DCN_Marks 
== null || DCN_Marks.trim().isEmpty() || 
    SE_Marks == null || SE_Marks.trim().isEmpty()|| 
WT_Marks == null || WT_Marks.trim().isEmpty()) 
  { 
   out.println("Please Enter Details."); 
   return; 
  } 
   
  String url ="Java_Servlet?Username=" + Username + 
"&DCN_Marks=" + DCN_Marks +  
             "&SE_Marks=" + SE_Marks + "&WT_Marks=" + WT_Marks; 
 
   
  out.println("<form action='"+url+"' method='post'>"); 
  out.println("Username:" + Username + "<br>"); 
  out.println("DCN Marks:" + DCN_Marks + "<br>"); 
  out.println("SE Marks:" + SE_Marks + "<br>"); 
  out.println("WT Marks:" + WT_Marks + "<br>"); 
  out.println("Enter Java Programming Marks: <input type='text' name='Java_Marks'><br>"); 
  out.println("<input type='submit' value='Next'>"); 
  out.println("</form>"); 
 } 
} 