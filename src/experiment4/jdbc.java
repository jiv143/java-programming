package experiment4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class JDBC{
public static void main(String[] args) {
 String url = "jdbc:mysql://localhost:3306/product";
 String username = "root";
 String password = "G12020";
 String query = "select * from Product_Details";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 // Establish connection
 Connection c = DriverManager.getConnection(url, username,
password);
 Statement st = c.createStatement();

 //ResultSet
 ResultSet rs = st.executeQuery(query);

 while(rs.next())
 {
 System.out.println("Id: " + rs.getInt("Pro_id") +
 " , Name: " + rs.getString("Pro_name") +
 ", Price: " + rs.getFloat("Pro_price"));

 }
 // Close the connection
 rs.close();
 st.close();
 c.close();
 System.out.println("Connection closed.");
 }
 catch (ClassNotFoundException e) {
 System.err.println("JDBC Driver not found: "
 + e.getMessage());
 }
 catch (SQLException e) {
 System.err.println("SQL Error: "
 + e.getMessage());
 }
}
}