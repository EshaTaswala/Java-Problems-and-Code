package learning.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import learning.beans.PersonalInfoBean;

@WebServlet("/PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PersonalInfoBean personalInfo = new PersonalInfoBean();
    personalInfo.setFirstName(request.getParameter("firstName"));
    personalInfo.setLastName(request.getParameter("lastName"));
    personalInfo.setMiddleName(request.getParameter("middleName"));
    personalInfo.setGender(request.getParameter("gender"));


    HttpSession session = request.getSession();
    session.setAttribute("personalInfo", personalInfo);

    response.sendRedirect("contactinfo.jsp");
	}

}
