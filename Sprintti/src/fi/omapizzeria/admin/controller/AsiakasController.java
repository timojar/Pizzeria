package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.omapizzeria.admin.bean.Asiakas;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class AsiakasController
 */
@WebServlet("/AsiakasController")
public class AsiakasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsiakasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sessio= request.getSession(false);	
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				
				if ("etunimi".equals(cookies[i].getName())) {
					String logged = "logged";
					String etunimi = cookies[i].getValue();
					request.setAttribute("logged", logged);
					request.setAttribute("etunimi", etunimi);
				}
				
				
				if ("sukunimi".equals(cookies[i].getName())) {
					
					String sukunimi = cookies[i].getValue();
					request.setAttribute("sukunimi", sukunimi);
				}
				
				
				
				
			}}
		
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
