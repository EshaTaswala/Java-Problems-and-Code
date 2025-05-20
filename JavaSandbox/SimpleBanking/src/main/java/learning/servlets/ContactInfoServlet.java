package learning.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learning.beans.ContactInfoBean;
@WebServlet("/ContactInfoServlet")
public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        ContactInfoBean contactInfo = new ContactInfoBean();
        contactInfo.setAddress(request.getParameter("address"));
        contactInfo.setCity(request.getParameter("city"));
        contactInfo.setState(request.getParameter("state"));
        contactInfo.setCountry(request.getParameter("country"));
        contactInfo.setPhone(request.getParameter("phone"));

  
        HttpSession session = request.getSession();
        session.setAttribute("contactInfo", contactInfo);


        response.sendRedirect("bankinfo.jsp");
	}

}
