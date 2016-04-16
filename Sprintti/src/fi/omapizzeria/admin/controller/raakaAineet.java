package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

/**
 * Servlet implementation class raakaAineet
 */
@WebServlet("/raakaAineet")
public class raakaAineet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public raakaAineet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AdminDao admintiedot = new AdminDao();

		boolean vahvistus = false;
		String Kayttajanimi = "";
		String Salasana = "";

		HttpSession sessio = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("kayttunnus".equals(cookies[i].getName())) {
					Kayttajanimi = cookies[i].getValue();
				}

				if ("password".equals(cookies[i].getName())) {
					Salasana = cookies[i].getValue();
				}

			}
		}

		if (Salasana.equals("") && Kayttajanimi.equals("")) {
			try {

				Kayttajanimi = (String) sessio.getAttribute("tunnus");
				Salasana = (String) sessio.getAttribute("salasana");

			} catch (Exception e) {

			}
		}

		try {

			vahvistus = admintiedot.vahvistaTunnus(Salasana, Kayttajanimi);

			if (vahvistus == true) {

			}

			else if(vahvistus == false) {
				request.getRequestDispatcher("Login.jsp").forward(request,
						response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);
		}
		
		
		
		
		if(vahvistus==true){
			request.getRequestDispatcher("raakaaineet.jsp").forward(request, response);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
