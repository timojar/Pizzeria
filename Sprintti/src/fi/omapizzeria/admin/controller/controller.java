package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import fi.omapizzeria.admin.bean.*;

/**
 * @Timo Jarmala
 */

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Salasana = null;
	private static boolean vahvistus = false;
	private static boolean kayttvahvistus = false;
	private static boolean asiakasvahvistus = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AdminDao admintiedot = new AdminDao();

		boolean vahvistus = false;
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

			if (vahvistus == true) {

			}

			else if (vahvistus == false) {
				request.getRequestDispatcher("Login.jsp").forward(request,
						response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);
		}

		int noofPizzas, pizzasperPage, page, nextIndex, noofPages, startindex;

		PizzaDAO kanta = new PizzaDAO();
		TayteDAO taytehallinta = new TayteDAO();

		noofPizzas = kanta.getnoofPizzas();
		pizzasperPage = 10;
		page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}

		catch (Exception e) {

		}

		if (request.getParameter("page") == null) {
			page = 1;

		}

		String v = (String) request.getAttribute("visible");

		System.out.println(v);
		noofPages = 0;
		startindex = 2;
		nextIndex = (page - 1) * pizzasperPage;
		double jakojaanos = (double) noofPizzas % pizzasperPage;
		System.out.println("jakoj‰‰nnˆs " + jakojaanos);
		if (jakojaanos > 0) {

			noofPages = noofPizzas / pizzasperPage + 1;
		}

		else if (jakojaanos == 0)

		{
			noofPages = noofPizzas / pizzasperPage;
		}

		List<Pizza> pizzalista = kanta.haePizzat(nextIndex, pizzasperPage);
		List<Tayte> taytelista = taytehallinta.haeTaytteet();

		if (noofPages > 1) {
			startindex = 1;
		}

		request.setAttribute("currentpage", page);
		request.setAttribute("startindex", startindex);
		request.setAttribute("taytelista", taytelista);
		request.setAttribute("noofPages", noofPages);
		request.setAttribute("lista", pizzalista);

		if (vahvistus == true) {
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		AdminDao admintiedot = new AdminDao();

		/**
		 * Otetaan parametrit login.jsp:st‰ vastaan.
		 */

		String salattavaTeksti = request.getParameter("Salasana");
		String Kayttajanimi = request.getParameter("Kayttajanimi");
		String muisti = request.getParameter("memory");

		kayttvahvistus=admintiedot.checkUser(Kayttajanimi);
		/**
		 * Tarkistetaan onko kirjautuja admin vai k‰ytt‰j‰. Jos kirjautuja on
		 * admin, salataan salasana ja k‰yd‰‰nn admin tunnistus l‰pi
		 */

		if (kayttvahvistus == true) {
			
		adminTunnistus(request, response, salattavaTeksti, Kayttajanimi);		
		}

		/**
		 * Jos kirjautuja on asiakas, salataan salasana ja k‰yd‰‰n
		 * asiakastunnistus l‰pi
		 */

		else

		{
asiakasTunnistus(request, response, salattavaTeksti, Kayttajanimi);

		}

		

		
	}

	
	
	
	
	
	
	private void asiakasTunnistus(HttpServletRequest request,
			HttpServletResponse response, String salattavaTeksti,
			String Kayttajanimi)throws ServletException, IOException {
		KantaAsiakas k=null;
		String etunimi=null;
		String sukunimi=null;
		AsiakasDAO asiakastiedot = new AsiakasDAO();
		HttpSession sessio = request.getSession(false);
		String muisti = request.getParameter("memory");
		Salasana = asiakastiedot.salaaTeksti(salattavaTeksti, Kayttajanimi);
		asiakasvahvistus = asiakastiedot.vahvistaTunnus(Salasana, Kayttajanimi);

		/**
		 * Jos asiakasvahvistus on true luodaan sessio, johon talletetaan
		 * asiakkaan tunnukset. Jos kirjautuja on merkinnyt muista
		 * minut-toiminnon, tunnukset talletetaan ev‰steisiin. Ohjataan lopuksi
		 * Asiakascontroller:lle.
		 */

		if (asiakasvahvistus == true) {

			k=asiakastiedot.getAsiakas(Kayttajanimi);
			etunimi=k.getEtunimi();
			sukunimi=k.getSukunimi();
			
			sessio = request.getSession(true);
			String logged = "logged";
			sessio.setAttribute("etunimi", k.getEtunimi());
			sessio.setAttribute("sukunimi", k.getSukunimi());
			sessio.setAttribute("asiakas", k);
			sessio.setAttribute("logged", logged);
			sessio.setAttribute("tunnus", Kayttajanimi);
			sessio.setAttribute("salasana", Salasana);
			if (muisti != null) {

				lisaaAsiakasEvasteet(request, response, logged, Kayttajanimi, Salasana, etunimi, sukunimi, k);

			}
			response.sendRedirect("/Sprintti/AsiakasController");

		}
		

		/**
		 * Jos tunnistautuminen on v‰‰rin ohtajaan takaisin login.jsp:lle
		 */

		else  {
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);

			System.out.println("ei mennyt l‰pi");

		}

	}

	
	
	
	
	
	private void adminTunnistus(HttpServletRequest request,
			HttpServletResponse response, String salattavaTeksti,
			String Kayttajanimi) throws ServletException, IOException 
	{
		
		HttpSession sessio = request.getSession(false);
		String muisti = request.getParameter("memory");
		
		AdminDao admintiedot = new AdminDao();

		Salasana = admintiedot.salaaTeksti(salattavaTeksti,
				Kayttajanimi);
		vahvistus = admintiedot.vahvistaTunnus(Salasana, Kayttajanimi);	
		
		
		
		/**
		 * Jos adminvahvistus on true luodaan sessio, johon talletetaan
		 * asiakkaan tunnukset. Jos kirjautuja on merkinnyt muista
		 * minut-toiminnon, tunnukset talletetaan ev‰steisiin. Ohjataan lopuksi
		 * controller:lle.
		 */
		
		
		if (vahvistus == true) {

			sessio = request.getSession(true);
			sessio.setAttribute("tunnus", Kayttajanimi);
			sessio.setAttribute("salasana", Salasana);
			String logged="logged";
			if (muisti != null) {
				lisaaEvasteet(request, response, logged, Kayttajanimi, Salasana);
				
			}
			response.sendRedirect("/Sprintti/controller?added=true");}
			else {
				request.getRequestDispatcher("Login.jsp").forward(request,
						response);

			}
		

		
	

		
	}
	
	
	
	
	
	private void lisaaAsiakasEvasteet (HttpServletRequest request,
			HttpServletResponse response, String login,
			String Kayttajanimi, String Salasana, String etunimi, String sukunimi, KantaAsiakas k) throws ServletException, IOException{
		
		Cookie ck = new Cookie("kayttunnus", Kayttajanimi);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);

		ck = new Cookie("password", Salasana);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);
		
		ck = new Cookie("etunimi", etunimi);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);
		
		ck = new Cookie("sukunimi", sukunimi);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);

		
		
		ck = new Cookie("puhelin", ""+k.getNumero());
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);

		ck = new Cookie("id", ""+k.getId());
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);


		
		
	}
	
	
	
	private void lisaaEvasteet (HttpServletRequest request,
			HttpServletResponse response, String login,
			String Kayttajanimi, String Salasana) throws ServletException, IOException{
		
		Cookie ck = new Cookie("kayttunnus", Kayttajanimi);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);

		ck = new Cookie("password", Salasana);
		ck.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(ck);

		
		
	}
	
	
	
}
