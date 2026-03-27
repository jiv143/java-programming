package experiment7;
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
 
 
/** 
 * Servlet implementation class Details 
 */ 
@WebServlet("/Details") 
public class Details extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
        
 protected void doGet(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  doPost(request, response); 
 } 
 
 /** 
  * @see HttpServlet#doPost(HttpServletRequest request, 
HttpServletResponse response) 
  */ 
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException { 
  response.setContentType("text/html"); 
   
  String prn = request.getParameter("prn"); 
        String name = request.getParameter("name"); 
        String dob = request.getParameter("dob"); 
        String gender = request.getParameter("gender"); 
     String[] subjects = request.getParameterValues("subjects"); 
      
     request.setAttribute("prn", prn); 
        request.setAttribute("name", name); 
        request.setAttribute("dob", dob); 
        request.setAttribute("gender", gender); 
        request.setAttribute("subjects", subjects); 
 
        // Forward request to DisplayStudentServlet 
        RequestDispatcher dispatcher = 
request.getRequestDispatcher("Display_Student_Details"); 
        dispatcher.forward(request, response); 
 } 
} 