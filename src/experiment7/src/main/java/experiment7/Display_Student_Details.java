package experiment7;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.io.PrintWriter; 
 
/** 
 * Servlet implementation class Display_Student_Details 
 */ 
@WebServlet("/Display_Student_Details") 
public class Display_Student_Details extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
   response.setContentType("text/html"); 
      PrintWriter out = response.getWriter(); 
       
      String prn = (String) request.getAttribute("prn"); 
         String name = (String) request.getAttribute("name"); 
         String dob = (String) request.getAttribute("dob"); 
         String gender = (String) request.getAttribute("gender"); 
      String[] subjects = (String[]) request.getAttribute("subjects"); 
 
  out.println("<html><head><title>StudentInfo</title></head><body>"); 
        out.println("<h2>Student Information</h2>"); 
        out.println("<b>PRN:</b> " + prn + "<br/>"); 
        out.println("<b>Name:</b>" + name + "<br/>"); 
        out.println("<b>DOB:</b>" + dob + "<br/>"); 
        out.println("<b>Gender:</b>" + gender + "<br/>"); 
        out.println("<b>Subjects:</b>" + "<br/>"); 
        for (String sub : subjects) { 
            out.println(sub + "<br>"); 
        } 
        out.println("</body></html>"); 
 } 
} 