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
import java.util.ArrayList;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AsiakasDAO asiakashallinta = new AsiakasDAO();

		HttpSession sessio = request.getSession(false);
		List<Pizza> ostoslista = null;
		Asiakas asiakas = null;
		Cookie[] cookies = request.getCookies();
		String logged = (String) sessio.getAttribute("logged");

		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("etunimi".equals(cookies[i].getName())) {
					logged = "logged";
					String etunimi = cookies[i].getValue();
					request.setAttribute("logged", logged);
					request.setAttribute("etunimi", etunimi);
				}

				if ("sukunimi".equals(cookies[i].getName())) {

					String sukunimi = cookies[i].getValue();
					request.setAttribute("sukunimi", sukunimi);
				}

			}
		}

		try {
			asiakas = (Asiakas) sessio.getAttribute("asiakas");
		} catch (Exception e) {
			// TODO: handle exception
		}
		int asiakasnumero = tuoAsiakasnumero(request, response);
		request.setAttribute("asiakasnumero", asiakasnumero);

		if (logged != null) {

			asiakas = asiakashallinta.tuoTilaaja(asiakasnumero);
			request.setAttribute("osoite", asiakas.getOsoite());
			request.setAttribute("numero", asiakas.getNumero());
			request.setAttribute("postinro", asiakas.getPostinro());
			request.setAttribute("tmp", asiakas.getTmp());
			request.setAttribute("email", asiakas.getEmail());

		}

		request.getRequestDispatcher("tilauslomake.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * KantaAsiakas-luokkaa käytetään tässä, koska sillä ja Asiakas-luokalla
		 * on yhteinen id. Asiakkaan luodessa luoAsiakas()-metodi palauttaa
		 * KantaAsiakas-olion, josta saadan Asiakas-id.
		 */

		boolean eiNumero = false;

		List<Pizza> ostoslista = null;
		double yhteishinta = 0;

		HttpSession muistiostoslistasta = request.getSession(false);

		try {
			ostoslista = (List<Pizza>) muistiostoslistasta
					.getAttribute("ostoslista");

			for (Pizza p : ostoslista) {

				yhteishinta = yhteishinta + p.getYhteishinta();
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		AsiakasDAO a = new AsiakasDAO();
		TilausRiviDao rivikasittely = new TilausRiviDao();
		TilausDao tilauskasittely = new TilausDao();
		Date date = new Date();
		SimpleDateFormat Totimestamp = new SimpleDateFormat("yyy.MM.dd hh:mm");
		String tilausajankohta = null;

		try {
			tilausajankohta = Totimestamp.format(date);

		} catch (Exception e) {
			// TODO: handle exception
		}

		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String numerostr = request.getParameter("numero");

		String toimosoite = request.getParameter("toimosoite");
		String postinro = request.getParameter("postinro");

		String postitmp = request.getParameter("postitmp");
		String email = request.getParameter("email");
		String toimitustapa = request.getParameter("toimtapa");
		String maksutapa = request.getParameter("maksutapa");
		String asiakasstr = "";
		asiakasstr = request.getParameter("asiakasnro");
		int asiakasnumero = 0;
		try {
			asiakasnumero = Integer.parseInt(asiakasstr);
		} catch (Exception e) {

			// TODO: handle exception
		}

		if (ostoslista != null) {
			teeTilaus(request, response, eiNumero, ostoslista, asiakasnumero,
					etunimi, sukunimi, email, numerostr, toimosoite, postinro,
					postitmp, toimitustapa, maksutapa, yhteishinta);
		}

		if (eiNumero == true) {

			response.sendRedirect("/Sprintti/TilausController?number=true");

		}

		else if (ostoslista == null || ostoslista.size() == 0) {

			response.sendRedirect("/Sprintti/menuController?shoppingcart=true");

		}

	}

	private void teeTilaus(HttpServletRequest request,
			HttpServletResponse response, boolean eiNumero,
			List<Pizza> ostoslista, int asiakasnumero, String etunimi,
			String sukunimi, String email, String numerostr, String toimosoite,
			String postinro, String postitmp, String toimitustapa,
			String maksutapa, double yhteishinta) throws ServletException,
			IOException {

		String salattavaTeksti = null;
		KantaAsiakas asiakas = null;
		AsiakasDAO a = new AsiakasDAO();
		TilausRiviDao rivikasittely = new TilausRiviDao();
		TilausDao tilauskasittely = new TilausDao();
		Date date = new Date();
		SimpleDateFormat Totimestamp = new SimpleDateFormat("yyy.MM.dd hh:mm");
		String tilausajankohta = null;
		HttpSession muistiostoslistasta = request.getSession(false);

		if (eiNumero == false && ostoslista.size() > 0) {
			System.out.println("Asikas" + asiakasnumero);
			if (asiakasnumero == 0) {
				asiakas = a.luoAsiakas(etunimi, sukunimi, email,
						salattavaTeksti, numerostr, toimosoite, postitmp,
						postinro);
				System.out.println("asiakasnro " + asiakasnumero);
				asiakasnumero = asiakas.getId();

			}

			else if (asiakasnumero != 0) {
				a.MuokkaAsiakas(asiakasnumero, etunimi, sukunimi, email,
						numerostr, toimosoite, postitmp, postinro);
			}

			int tilausnumero = tilauskasittely.luoTilaus(asiakasnumero,
					tilausajankohta, toimitustapa, maksutapa, yhteishinta);

			rivikasittely.luoTilausRivi(ostoslista, tilausnumero);

			ostoslista = new ArrayList<Pizza>();

			muistiostoslistasta.setAttribute("ostoslista", ostoslista);
			request.getRequestDispatcher("kuittaus.jsp").forward(request,
					response);

		}

	}

	private int tuoAsiakasnumero(HttpServletRequest request,
			HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		int asiakasnumero = 0;

		String asiakasnumerostr = null;

		for (int i = 0; i < cookies.length; i++) {

			if ("id".equals(cookies[i].getName())) {

				asiakasnumerostr = cookies[i].getValue();

			}

		}

		HttpSession sessio = request.getSession(false);
		try {
			asiakasnumero = (int) sessio.getAttribute("asiakasnumero");
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (asiakasnumero == 0) {
			try {
				asiakasnumero = Integer.parseInt(asiakasnumerostr);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return asiakasnumero;

	}

}
