package marks;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.io.PrintWriter; 
@jakarta.servlet.annotation.WebServlet("/Final_Servlet")
public class Final_Servlet extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
    
 protected void doGet(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  doPost(request, response); 
 } 
 
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  response.setContentType("text/html"); 
  PrintWriter out = response.getWriter(); 
   
  String Username = request.getParameter("Username"); 
  String DCN_Marks = request.getParameter("DCN_Marks"); 
  String SE_Marks = request.getParameter("SE_Marks"); 
  String WT_Marks = request.getParameter("WT_Marks"); 
  String Java_Marks = request.getParameter("Java_Marks"); 
   
  if( Username == null || Username.trim().isEmpty() || DCN_Marks 
== null || DCN_Marks.trim().isEmpty() || 
    SE_Marks == null || SE_Marks.trim().isEmpty()|| 
WT_Marks == null || WT_Marks.trim().isEmpty()  
    || Java_Marks == null || Java_Marks.trim().isEmpty()) 
  { 
   out.println("Please Enter Marks."); 
   return; 
  } 
   
  int Total = Integer.parseInt(DCN_Marks) + 
Integer.parseInt(SE_Marks) + 
  Integer.parseInt(WT_Marks) + Integer.parseInt(Java_Marks); 
 
  out.println("Username:" + Username + "<br>"); 
  out.println("DCN Marks:" + DCN_Marks + "<br>"); 
  out.println("SE Marks:" + SE_Marks + "<br>"); 
  out.println("WT Marks:" + WT_Marks + "<br>"); 
  out.println("Java Marks:" + Java_Marks + "<br>"); 
  out.println("Total Marks:" + Total); 
   
 } 
} 