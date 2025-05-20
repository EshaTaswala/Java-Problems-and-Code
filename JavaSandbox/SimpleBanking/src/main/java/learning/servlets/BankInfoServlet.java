package learning.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learning.beans.BankInfoBean;
import learning.beans.ContactInfoBean;
import learning.beans.PersonalInfoBean;

@WebServlet("/BankInfoServlet")
public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/userbankingdetails";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Admin1234";
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	 HttpSession session = request.getSession();
         PersonalInfoBean personalInfo = (PersonalInfoBean) session.getAttribute("personalInfo");
         ContactInfoBean contactInfo = (ContactInfoBean) session.getAttribute("contactInfo");

         BankInfoBean bankInfo = new BankInfoBean();
         bankInfo.setBankName(request.getParameter("bankName"));
         bankInfo.setAccountNumber(request.getParameter("accountNumber"));
         bankInfo.setSsn(request.getParameter("ssn"));

         session.setAttribute("bankInfo", bankInfo);

         Connection conn = null;
         PreparedStatement statement = null;
         try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 
        	 conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	 
        	 String sql = "INSERT INTO user_info (first_name, last_name, middle_name, gender, address, city, state, country, phone, bank_name, account_number, ssn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
             statement = conn.prepareStatement(sql);
             
             statement.setString(1, personalInfo.getFirstName());
             statement.setString(2, personalInfo.getLastName());
             statement.setString(3, personalInfo.getMiddleName());
             statement.setString(4, personalInfo.getGender());
             statement.setString(5, contactInfo.getAddress());
             statement.setString(6, contactInfo.getCity());
             statement.setString(7, contactInfo.getState());
             statement.setString(8, contactInfo.getCountry());
             statement.setString(9, contactInfo.getPhone());
             statement.setString(10, bankInfo.getBankName());
             statement.setString(11, bankInfo.getAccountNumber());
             statement.setString(12, bankInfo.getSsn());

             statement.executeUpdate();
             session.invalidate();
             
             response.sendRedirect("success.jsp");
         }catch(ClassNotFoundException e){
        	 e.printStackTrace();
             response.getWriter().println("Database driver not found.");
             
         }catch(Exception e){
        	 e.printStackTrace();
             response.sendRedirect("error.jsp");
         }
         finally {
             try {
                 if (statement != null) statement.close();
                 if (conn != null) conn.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }

}
