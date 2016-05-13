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
import dao.TayteDAO;

/**
 * Servlet implementation class tayteController
 */
@WebServlet("/tayteController")
public class tayteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tayteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
boolean vahvistus=false;
		
		HttpSession muistipizzasta= request.getSession(false);
		
		vahvistus= tunnistaKayttaja(request, response);
		
		if (vahvistus == true) {

		}

		else if (vahvistus == false) {
			request.getRequestDispatcher("Login.jsp").forward(request,
					response);
		}

		
		request.getRequestDispatcher("WEB-INF/luoTayte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	TayteDAO dao=new TayteDAO();	
		
	String nimi =request.getParameter("tayteNimi");	
	
	String saatavuusstr=request.getParameter("saatavuus");
	int saatavuus=0;
	boolean correct=false;
	
	try {
		saatavuus=Integer.parseInt(saatavuusstr);
		correct=true;
	}
	
	catch (Exception e){
		System.out.println("Saatavuus pit‰‰ ilmoittaa numerona");	
	}
	
	
	if(correct==true && nimi!=null){
		
	dao.luoTayte(nimi, saatavuus);	
	response.sendRedirect("/Sprintti/tayteController?tayte=true");	
	}
	
	else if(correct==false){
		response.sendRedirect("/Sprintti/tayteController?error=true");		
	}
	
	}
	
	
	
	
	private boolean tunnistaKayttaja(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		
		boolean vahvistus = false;
		AdminDao admintiedot = new AdminDao();
		String Kayttajanimi = "";
		String Salasana = "";
		
		HttpSession sessio = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("kayttunnus".equals(cookies[i].getName())) {
					String logged = "logged";
					Kayttajanimi = cookies[i].getValue();
					request.setAttribute("logged", logged);
					request.setAttribute("tunnus", Kayttajanimi);
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
			

		}

		catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
		return vahvistus;
	}
	
	

	
}
