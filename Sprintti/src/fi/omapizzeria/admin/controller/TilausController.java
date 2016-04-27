package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.AsiakasDAO;
import dao.TilausDao;
import dao.TilausRiviDao;
import fi.omapizzeria.admin.bean.Asiakas;
import fi.omapizzeria.admin.bean.KantaAsiakas;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class TilausController
 */
@WebServlet("/TilausController")
public class TilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TilausController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AsiakasDAO asiakashallinta=new AsiakasDAO();
		
		
		
		HttpSession sessio= request.getSession(false);	
		List<Pizza> ostoslista=null;
		Asiakas asiakas=null;
		Cookie[] cookies = request.getCookies();
		String logged=null;
		
		
		
		
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("kayttunnus".equals(cookies[i].getName())) {
					 logged = "logged";
					String Kayttajanimi = cookies[i].getValue();
					request.setAttribute("logged", logged);
					request.setAttribute("tunnus", Kayttajanimi);
				}

			
			}}

		try {
			asiakas=(Asiakas)sessio.getAttribute("asiakas");
		} catch (Exception e) {
			// TODO: handle exception
		}
		int asiakasnumero=tuoAsiakasnumero(request, response);
		
		
		if(logged!=null){
		asiakas=asiakashallinta.tuoTilaaja(asiakasnumero);
		request.setAttribute("asiakas", asiakas);	
			
		}
		
		
		request.getRequestDispatcher("tilauslomake.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * KantaAsiakas-luokkaa käytetään tässä, koska sillä ja Asiakas-luokalla on yhteinen id.
		 * Asiakkaan luodessa luoAsiakas()-metodi palauttaa KantaAsiakas-olion, josta saadan Asiakas-id.
		 */
		KantaAsiakas asiakas=null;
		
		
		
		List<Pizza> ostoslista=null;
		double yhteishinta=0;
		
		
		HttpSession muistiostoslistasta= request.getSession(false);
		
		try { ostoslista=(List<Pizza>)muistiostoslistasta.getAttribute("ostoslista");
		System.out.println("vfc"+ostoslista.size());
for(Pizza p : ostoslista) {
		    
			yhteishinta=yhteishinta+p.getYhteishinta();
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			
			
			
			
		}
		
		
		AsiakasDAO a=new AsiakasDAO();
		TilausRiviDao rivikasittely=new TilausRiviDao();
		TilausDao tilauskasittely=new TilausDao();
		Date date=new Date();
		SimpleDateFormat Totimestamp=new SimpleDateFormat("yyy.MM.dd hh:mm");
		String tilausajankohta=null;
		
		
		try {
			tilausajankohta=Totimestamp.format(date);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		String salattavaTeksti=null;
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String numerostr = request.getParameter("numero");
		int numero=0;
		
		try {numero=Integer.parseInt(numerostr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String toimosoite = request.getParameter("toimosoite");
		String postinrostr = request.getParameter("postinro");
		int postinro=0;
		try {postinro=Integer.parseInt(postinrostr);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String postitmp = request.getParameter("postitmp");
		String email = request.getParameter("email");
		String toimitustapa = request.getParameter("toimtapa");
		String maksutapa = request.getParameter("maksutapa");
		
		asiakas=a.luoAsiakas(etunimi, sukunimi, email, salattavaTeksti, numero ,toimosoite,postitmp, postinro);
		
		int asiakasnumero=asiakas.getId();
		
		int tilausnumero=tilauskasittely.luoTilaus(asiakasnumero, tilausajankohta, toimitustapa, maksutapa, yhteishinta);
		
		rivikasittely.luoTilausRivi(ostoslista, tilausnumero);
		
	}

	
	
	
	
	
	
	private int tuoAsiakasnumero(HttpServletRequest request, HttpServletResponse response){
		
		Cookie[] cookies = request.getCookies();
	int asiakasnumero=0;	
	

	String asiakasnumerostr=null;
	
	for (int i = 0; i < cookies.length; i++) {

		if ("id".equals(cookies[i].getName())) {
			
			 asiakasnumerostr = cookies[i].getValue();
							
			
		}

	
	}
	
	
	HttpSession sessio= request.getSession(false);

	asiakasnumero=(int)sessio.getAttribute("asiakasnumero");
	
	
	if(asiakasnumero==0){
		
	asiakasnumero=Integer.parseInt(asiakasnumerostr)	;
		
	}
	
	return asiakasnumero;
	
	}
		
		
		
	}
	
	
	
	
	
	
	

