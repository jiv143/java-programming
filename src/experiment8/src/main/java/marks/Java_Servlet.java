package marks;
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.io.PrintWriter; 
@jakarta.servlet.annotation.WebServlet("/Java_Servlet")
public class Java_Servlet extends HttpServlet { 
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
  String Java_Marks = request.getParameter("Java_Marks"); 
   
  if( Java_Marks == null || Java_Marks.trim().isEmpty()) 
  { 
   out.println("Please Enter Marks."); 
   return; 
  } 
 
  String url ="Final_Servlet?Username=" + Username + 
"&DCN_Marks=" + DCN_Marks +  
             "&SE_Marks=" + SE_Marks + "&WT_Marks=" + WT_Marks + 
"&Java_Marks=" + Java_Marks; 
 
  out.println("<form action='" + url + "' method='post'>"); 
  out.println("Username:" + Username + "<br>"); 
  out.println("Java Marks:" + Java_Marks + "<br>"); 
  out.println("<input type='submit' value='Next'>"); 
  out.println("</form>"); 
 } 
} 