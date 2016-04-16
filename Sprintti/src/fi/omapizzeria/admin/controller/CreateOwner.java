package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

/**
 * Servlet implementation class CreateOwner
 */
@WebServlet("/CreateOwner")
public class CreateOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("owner.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	String etunimi=request.getParameter("etunimi");
	String sukunimi=request.getParameter("sukunimi");
	String tunnus=request.getParameter("tunnus");
	String salattavaTeksti=request.getParameter("salasana");
	String tehtava="omistaja";
	
	AdminDao admin=new AdminDao();
	
	admin.createOwner(etunimi, sukunimi, tehtava, tunnus, salattavaTeksti);
		
		
		
	}

}
